/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.FacturaCompra;
import Modelo.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) throws PreexistingEntityException, Exception {
        if (proveedor.getFacturaCompraList() == null) {
            proveedor.setFacturaCompraList(new ArrayList<FacturaCompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<FacturaCompra> attachedFacturaCompraList = new ArrayList<FacturaCompra>();
            for (FacturaCompra facturaCompraListFacturaCompraToAttach : proveedor.getFacturaCompraList()) {
                facturaCompraListFacturaCompraToAttach = em.getReference(facturaCompraListFacturaCompraToAttach.getClass(), facturaCompraListFacturaCompraToAttach.getIdFactura());
                attachedFacturaCompraList.add(facturaCompraListFacturaCompraToAttach);
            }
            proveedor.setFacturaCompraList(attachedFacturaCompraList);
            em.persist(proveedor);
            for (FacturaCompra facturaCompraListFacturaCompra : proveedor.getFacturaCompraList()) {
                Proveedor oldNitFkOfFacturaCompraListFacturaCompra = facturaCompraListFacturaCompra.getNitFk();
                facturaCompraListFacturaCompra.setNitFk(proveedor);
                facturaCompraListFacturaCompra = em.merge(facturaCompraListFacturaCompra);
                if (oldNitFkOfFacturaCompraListFacturaCompra != null) {
                    oldNitFkOfFacturaCompraListFacturaCompra.getFacturaCompraList().remove(facturaCompraListFacturaCompra);
                    oldNitFkOfFacturaCompraListFacturaCompra = em.merge(oldNitFkOfFacturaCompraListFacturaCompra);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProveedor(proveedor.getNit()) != null) {
                throw new PreexistingEntityException("Proveedor " + proveedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getNit());
            List<FacturaCompra> facturaCompraListOld = persistentProveedor.getFacturaCompraList();
            List<FacturaCompra> facturaCompraListNew = proveedor.getFacturaCompraList();
            List<String> illegalOrphanMessages = null;
            for (FacturaCompra facturaCompraListOldFacturaCompra : facturaCompraListOld) {
                if (!facturaCompraListNew.contains(facturaCompraListOldFacturaCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain FacturaCompra " + facturaCompraListOldFacturaCompra + " since its nitFk field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<FacturaCompra> attachedFacturaCompraListNew = new ArrayList<FacturaCompra>();
            for (FacturaCompra facturaCompraListNewFacturaCompraToAttach : facturaCompraListNew) {
                facturaCompraListNewFacturaCompraToAttach = em.getReference(facturaCompraListNewFacturaCompraToAttach.getClass(), facturaCompraListNewFacturaCompraToAttach.getIdFactura());
                attachedFacturaCompraListNew.add(facturaCompraListNewFacturaCompraToAttach);
            }
            facturaCompraListNew = attachedFacturaCompraListNew;
            proveedor.setFacturaCompraList(facturaCompraListNew);
            proveedor = em.merge(proveedor);
            for (FacturaCompra facturaCompraListNewFacturaCompra : facturaCompraListNew) {
                if (!facturaCompraListOld.contains(facturaCompraListNewFacturaCompra)) {
                    Proveedor oldNitFkOfFacturaCompraListNewFacturaCompra = facturaCompraListNewFacturaCompra.getNitFk();
                    facturaCompraListNewFacturaCompra.setNitFk(proveedor);
                    facturaCompraListNewFacturaCompra = em.merge(facturaCompraListNewFacturaCompra);
                    if (oldNitFkOfFacturaCompraListNewFacturaCompra != null && !oldNitFkOfFacturaCompraListNewFacturaCompra.equals(proveedor)) {
                        oldNitFkOfFacturaCompraListNewFacturaCompra.getFacturaCompraList().remove(facturaCompraListNewFacturaCompra);
                        oldNitFkOfFacturaCompraListNewFacturaCompra = em.merge(oldNitFkOfFacturaCompraListNewFacturaCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = proveedor.getNit();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getNit();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<FacturaCompra> facturaCompraListOrphanCheck = proveedor.getFacturaCompraList();
            for (FacturaCompra facturaCompraListOrphanCheckFacturaCompra : facturaCompraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Proveedor (" + proveedor + ") cannot be destroyed since the FacturaCompra " + facturaCompraListOrphanCheckFacturaCompra + " in its facturaCompraList field has a non-nullable nitFk field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
