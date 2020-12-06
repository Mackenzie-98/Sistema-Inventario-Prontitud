/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Modelo.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.FacturaVenta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class ClienteJpaController1 implements Serializable {

    public ClienteJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) throws PreexistingEntityException, Exception {
        if (cliente.getFacturaVentaList() == null) {
            cliente.setFacturaVentaList(new ArrayList<FacturaVenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<FacturaVenta> attachedFacturaVentaList = new ArrayList<FacturaVenta>();
            for (FacturaVenta facturaVentaListFacturaVentaToAttach : cliente.getFacturaVentaList()) {
                facturaVentaListFacturaVentaToAttach = em.getReference(facturaVentaListFacturaVentaToAttach.getClass(), facturaVentaListFacturaVentaToAttach.getIdFactura());
                attachedFacturaVentaList.add(facturaVentaListFacturaVentaToAttach);
            }
            cliente.setFacturaVentaList(attachedFacturaVentaList);
            em.persist(cliente);
            for (FacturaVenta facturaVentaListFacturaVenta : cliente.getFacturaVentaList()) {
                Cliente oldIdentificacionFKOfFacturaVentaListFacturaVenta = facturaVentaListFacturaVenta.getIdentificacionFK();
                facturaVentaListFacturaVenta.setIdentificacionFK(cliente);
                facturaVentaListFacturaVenta = em.merge(facturaVentaListFacturaVenta);
                if (oldIdentificacionFKOfFacturaVentaListFacturaVenta != null) {
                    oldIdentificacionFKOfFacturaVentaListFacturaVenta.getFacturaVentaList().remove(facturaVentaListFacturaVenta);
                    oldIdentificacionFKOfFacturaVentaListFacturaVenta = em.merge(oldIdentificacionFKOfFacturaVentaListFacturaVenta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCliente(cliente.getIdentificacion()) != null) {
                throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdentificacion());
            List<FacturaVenta> facturaVentaListOld = persistentCliente.getFacturaVentaList();
            List<FacturaVenta> facturaVentaListNew = cliente.getFacturaVentaList();
            List<String> illegalOrphanMessages = null;
            for (FacturaVenta facturaVentaListOldFacturaVenta : facturaVentaListOld) {
                if (!facturaVentaListNew.contains(facturaVentaListOldFacturaVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain FacturaVenta " + facturaVentaListOldFacturaVenta + " since its identificacionFK field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<FacturaVenta> attachedFacturaVentaListNew = new ArrayList<FacturaVenta>();
            for (FacturaVenta facturaVentaListNewFacturaVentaToAttach : facturaVentaListNew) {
                facturaVentaListNewFacturaVentaToAttach = em.getReference(facturaVentaListNewFacturaVentaToAttach.getClass(), facturaVentaListNewFacturaVentaToAttach.getIdFactura());
                attachedFacturaVentaListNew.add(facturaVentaListNewFacturaVentaToAttach);
            }
            facturaVentaListNew = attachedFacturaVentaListNew;
            cliente.setFacturaVentaList(facturaVentaListNew);
            cliente = em.merge(cliente);
            for (FacturaVenta facturaVentaListNewFacturaVenta : facturaVentaListNew) {
                if (!facturaVentaListOld.contains(facturaVentaListNewFacturaVenta)) {
                    Cliente oldIdentificacionFKOfFacturaVentaListNewFacturaVenta = facturaVentaListNewFacturaVenta.getIdentificacionFK();
                    facturaVentaListNewFacturaVenta.setIdentificacionFK(cliente);
                    facturaVentaListNewFacturaVenta = em.merge(facturaVentaListNewFacturaVenta);
                    if (oldIdentificacionFKOfFacturaVentaListNewFacturaVenta != null && !oldIdentificacionFKOfFacturaVentaListNewFacturaVenta.equals(cliente)) {
                        oldIdentificacionFKOfFacturaVentaListNewFacturaVenta.getFacturaVentaList().remove(facturaVentaListNewFacturaVenta);
                        oldIdentificacionFKOfFacturaVentaListNewFacturaVenta = em.merge(oldIdentificacionFKOfFacturaVentaListNewFacturaVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cliente.getIdentificacion();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdentificacion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<FacturaVenta> facturaVentaListOrphanCheck = cliente.getFacturaVentaList();
            for (FacturaVenta facturaVentaListOrphanCheckFacturaVenta : facturaVentaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the FacturaVenta " + facturaVentaListOrphanCheckFacturaVenta + " in its facturaVentaList field has a non-nullable identificacionFK field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cliente findCliente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
