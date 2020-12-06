/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Cliente;
import Modelo.Devolucion;
import java.util.ArrayList;
import java.util.List;
import Modelo.DetalleVenta;
import Modelo.FacturaVenta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class FacturaVentaJpaController1 implements Serializable {

    public FacturaVentaJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FacturaVenta facturaVenta) {
        if (facturaVenta.getDevolucionList() == null) {
            facturaVenta.setDevolucionList(new ArrayList<Devolucion>());
        }
        if (facturaVenta.getDetalleVentaList() == null) {
            facturaVenta.setDetalleVentaList(new ArrayList<DetalleVenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente identificacionFK = facturaVenta.getIdentificacionFK();
            if (identificacionFK != null) {
                identificacionFK = em.getReference(identificacionFK.getClass(), identificacionFK.getIdentificacion());
                facturaVenta.setIdentificacionFK(identificacionFK);
            }
            List<Devolucion> attachedDevolucionList = new ArrayList<Devolucion>();
            for (Devolucion devolucionListDevolucionToAttach : facturaVenta.getDevolucionList()) {
                devolucionListDevolucionToAttach = em.getReference(devolucionListDevolucionToAttach.getClass(), devolucionListDevolucionToAttach.getDevolucionPK());
                attachedDevolucionList.add(devolucionListDevolucionToAttach);
            }
            facturaVenta.setDevolucionList(attachedDevolucionList);
            List<DetalleVenta> attachedDetalleVentaList = new ArrayList<DetalleVenta>();
            for (DetalleVenta detalleVentaListDetalleVentaToAttach : facturaVenta.getDetalleVentaList()) {
                detalleVentaListDetalleVentaToAttach = em.getReference(detalleVentaListDetalleVentaToAttach.getClass(), detalleVentaListDetalleVentaToAttach.getDetalleVentaPK());
                attachedDetalleVentaList.add(detalleVentaListDetalleVentaToAttach);
            }
            facturaVenta.setDetalleVentaList(attachedDetalleVentaList);
            em.persist(facturaVenta);
            if (identificacionFK != null) {
                identificacionFK.getFacturaVentaList().add(facturaVenta);
                identificacionFK = em.merge(identificacionFK);
            }
            for (Devolucion devolucionListDevolucion : facturaVenta.getDevolucionList()) {
                FacturaVenta oldFacturaVentaOfDevolucionListDevolucion = devolucionListDevolucion.getFacturaVenta();
                devolucionListDevolucion.setFacturaVenta(facturaVenta);
                devolucionListDevolucion = em.merge(devolucionListDevolucion);
                if (oldFacturaVentaOfDevolucionListDevolucion != null) {
                    oldFacturaVentaOfDevolucionListDevolucion.getDevolucionList().remove(devolucionListDevolucion);
                    oldFacturaVentaOfDevolucionListDevolucion = em.merge(oldFacturaVentaOfDevolucionListDevolucion);
                }
            }
            for (DetalleVenta detalleVentaListDetalleVenta : facturaVenta.getDetalleVentaList()) {
                FacturaVenta oldFacturaVentaOfDetalleVentaListDetalleVenta = detalleVentaListDetalleVenta.getFacturaVenta();
                detalleVentaListDetalleVenta.setFacturaVenta(facturaVenta);
                detalleVentaListDetalleVenta = em.merge(detalleVentaListDetalleVenta);
                if (oldFacturaVentaOfDetalleVentaListDetalleVenta != null) {
                    oldFacturaVentaOfDetalleVentaListDetalleVenta.getDetalleVentaList().remove(detalleVentaListDetalleVenta);
                    oldFacturaVentaOfDetalleVentaListDetalleVenta = em.merge(oldFacturaVentaOfDetalleVentaListDetalleVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FacturaVenta facturaVenta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaVenta persistentFacturaVenta = em.find(FacturaVenta.class, facturaVenta.getIdFactura());
            Cliente identificacionFKOld = persistentFacturaVenta.getIdentificacionFK();
            Cliente identificacionFKNew = facturaVenta.getIdentificacionFK();
            List<Devolucion> devolucionListOld = persistentFacturaVenta.getDevolucionList();
            List<Devolucion> devolucionListNew = facturaVenta.getDevolucionList();
            List<DetalleVenta> detalleVentaListOld = persistentFacturaVenta.getDetalleVentaList();
            List<DetalleVenta> detalleVentaListNew = facturaVenta.getDetalleVentaList();
            List<String> illegalOrphanMessages = null;
            for (Devolucion devolucionListOldDevolucion : devolucionListOld) {
                if (!devolucionListNew.contains(devolucionListOldDevolucion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Devolucion " + devolucionListOldDevolucion + " since its facturaVenta field is not nullable.");
                }
            }
            for (DetalleVenta detalleVentaListOldDetalleVenta : detalleVentaListOld) {
                if (!detalleVentaListNew.contains(detalleVentaListOldDetalleVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleVenta " + detalleVentaListOldDetalleVenta + " since its facturaVenta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (identificacionFKNew != null) {
                identificacionFKNew = em.getReference(identificacionFKNew.getClass(), identificacionFKNew.getIdentificacion());
                facturaVenta.setIdentificacionFK(identificacionFKNew);
            }
            List<Devolucion> attachedDevolucionListNew = new ArrayList<Devolucion>();
            for (Devolucion devolucionListNewDevolucionToAttach : devolucionListNew) {
                devolucionListNewDevolucionToAttach = em.getReference(devolucionListNewDevolucionToAttach.getClass(), devolucionListNewDevolucionToAttach.getDevolucionPK());
                attachedDevolucionListNew.add(devolucionListNewDevolucionToAttach);
            }
            devolucionListNew = attachedDevolucionListNew;
            facturaVenta.setDevolucionList(devolucionListNew);
            List<DetalleVenta> attachedDetalleVentaListNew = new ArrayList<DetalleVenta>();
            for (DetalleVenta detalleVentaListNewDetalleVentaToAttach : detalleVentaListNew) {
                detalleVentaListNewDetalleVentaToAttach = em.getReference(detalleVentaListNewDetalleVentaToAttach.getClass(), detalleVentaListNewDetalleVentaToAttach.getDetalleVentaPK());
                attachedDetalleVentaListNew.add(detalleVentaListNewDetalleVentaToAttach);
            }
            detalleVentaListNew = attachedDetalleVentaListNew;
            facturaVenta.setDetalleVentaList(detalleVentaListNew);
            facturaVenta = em.merge(facturaVenta);
            if (identificacionFKOld != null && !identificacionFKOld.equals(identificacionFKNew)) {
                identificacionFKOld.getFacturaVentaList().remove(facturaVenta);
                identificacionFKOld = em.merge(identificacionFKOld);
            }
            if (identificacionFKNew != null && !identificacionFKNew.equals(identificacionFKOld)) {
                identificacionFKNew.getFacturaVentaList().add(facturaVenta);
                identificacionFKNew = em.merge(identificacionFKNew);
            }
            for (Devolucion devolucionListNewDevolucion : devolucionListNew) {
                if (!devolucionListOld.contains(devolucionListNewDevolucion)) {
                    FacturaVenta oldFacturaVentaOfDevolucionListNewDevolucion = devolucionListNewDevolucion.getFacturaVenta();
                    devolucionListNewDevolucion.setFacturaVenta(facturaVenta);
                    devolucionListNewDevolucion = em.merge(devolucionListNewDevolucion);
                    if (oldFacturaVentaOfDevolucionListNewDevolucion != null && !oldFacturaVentaOfDevolucionListNewDevolucion.equals(facturaVenta)) {
                        oldFacturaVentaOfDevolucionListNewDevolucion.getDevolucionList().remove(devolucionListNewDevolucion);
                        oldFacturaVentaOfDevolucionListNewDevolucion = em.merge(oldFacturaVentaOfDevolucionListNewDevolucion);
                    }
                }
            }
            for (DetalleVenta detalleVentaListNewDetalleVenta : detalleVentaListNew) {
                if (!detalleVentaListOld.contains(detalleVentaListNewDetalleVenta)) {
                    FacturaVenta oldFacturaVentaOfDetalleVentaListNewDetalleVenta = detalleVentaListNewDetalleVenta.getFacturaVenta();
                    detalleVentaListNewDetalleVenta.setFacturaVenta(facturaVenta);
                    detalleVentaListNewDetalleVenta = em.merge(detalleVentaListNewDetalleVenta);
                    if (oldFacturaVentaOfDetalleVentaListNewDetalleVenta != null && !oldFacturaVentaOfDetalleVentaListNewDetalleVenta.equals(facturaVenta)) {
                        oldFacturaVentaOfDetalleVentaListNewDetalleVenta.getDetalleVentaList().remove(detalleVentaListNewDetalleVenta);
                        oldFacturaVentaOfDetalleVentaListNewDetalleVenta = em.merge(oldFacturaVentaOfDetalleVentaListNewDetalleVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = facturaVenta.getIdFactura();
                if (findFacturaVenta(id) == null) {
                    throw new NonexistentEntityException("The facturaVenta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaVenta facturaVenta;
            try {
                facturaVenta = em.getReference(FacturaVenta.class, id);
                facturaVenta.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturaVenta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Devolucion> devolucionListOrphanCheck = facturaVenta.getDevolucionList();
            for (Devolucion devolucionListOrphanCheckDevolucion : devolucionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This FacturaVenta (" + facturaVenta + ") cannot be destroyed since the Devolucion " + devolucionListOrphanCheckDevolucion + " in its devolucionList field has a non-nullable facturaVenta field.");
            }
            List<DetalleVenta> detalleVentaListOrphanCheck = facturaVenta.getDetalleVentaList();
            for (DetalleVenta detalleVentaListOrphanCheckDetalleVenta : detalleVentaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This FacturaVenta (" + facturaVenta + ") cannot be destroyed since the DetalleVenta " + detalleVentaListOrphanCheckDetalleVenta + " in its detalleVentaList field has a non-nullable facturaVenta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente identificacionFK = facturaVenta.getIdentificacionFK();
            if (identificacionFK != null) {
                identificacionFK.getFacturaVentaList().remove(facturaVenta);
                identificacionFK = em.merge(identificacionFK);
            }
            em.remove(facturaVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FacturaVenta> findFacturaVentaEntities() {
        return findFacturaVentaEntities(true, -1, -1);
    }

    public List<FacturaVenta> findFacturaVentaEntities(int maxResults, int firstResult) {
        return findFacturaVentaEntities(false, maxResults, firstResult);
    }

    private List<FacturaVenta> findFacturaVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FacturaVenta.class));
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

    public FacturaVenta findFacturaVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FacturaVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FacturaVenta> rt = cq.from(FacturaVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
