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
import Modelo.Proveedor;
import Modelo.DetalleCompra;
import Modelo.FacturaCompra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class FacturaCompraJpaController implements Serializable {

    public FacturaCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FacturaCompra facturaCompra) {
        if (facturaCompra.getDetalleCompraList() == null) {
            facturaCompra.setDetalleCompraList(new ArrayList<DetalleCompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor nitFk = facturaCompra.getNitFk();
            if (nitFk != null) {
                nitFk = em.getReference(nitFk.getClass(), nitFk.getNit());
                facturaCompra.setNitFk(nitFk);
            }
            List<DetalleCompra> attachedDetalleCompraList = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraListDetalleCompraToAttach : facturaCompra.getDetalleCompraList()) {
                detalleCompraListDetalleCompraToAttach = em.getReference(detalleCompraListDetalleCompraToAttach.getClass(), detalleCompraListDetalleCompraToAttach.getDetalleCompraPK());
                attachedDetalleCompraList.add(detalleCompraListDetalleCompraToAttach);
            }
            facturaCompra.setDetalleCompraList(attachedDetalleCompraList);
            em.persist(facturaCompra);
            if (nitFk != null) {
                nitFk.getFacturaCompraList().add(facturaCompra);
                nitFk = em.merge(nitFk);
            }
            for (DetalleCompra detalleCompraListDetalleCompra : facturaCompra.getDetalleCompraList()) {
                FacturaCompra oldFacturaCompraOfDetalleCompraListDetalleCompra = detalleCompraListDetalleCompra.getFacturaCompra();
                detalleCompraListDetalleCompra.setFacturaCompra(facturaCompra);
                detalleCompraListDetalleCompra = em.merge(detalleCompraListDetalleCompra);
                if (oldFacturaCompraOfDetalleCompraListDetalleCompra != null) {
                    oldFacturaCompraOfDetalleCompraListDetalleCompra.getDetalleCompraList().remove(detalleCompraListDetalleCompra);
                    oldFacturaCompraOfDetalleCompraListDetalleCompra = em.merge(oldFacturaCompraOfDetalleCompraListDetalleCompra);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FacturaCompra facturaCompra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaCompra persistentFacturaCompra = em.find(FacturaCompra.class, facturaCompra.getIdFactura());
            Proveedor nitFkOld = persistentFacturaCompra.getNitFk();
            Proveedor nitFkNew = facturaCompra.getNitFk();
            List<DetalleCompra> detalleCompraListOld = persistentFacturaCompra.getDetalleCompraList();
            List<DetalleCompra> detalleCompraListNew = facturaCompra.getDetalleCompraList();
            List<String> illegalOrphanMessages = null;
            for (DetalleCompra detalleCompraListOldDetalleCompra : detalleCompraListOld) {
                if (!detalleCompraListNew.contains(detalleCompraListOldDetalleCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleCompra " + detalleCompraListOldDetalleCompra + " since its facturaCompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (nitFkNew != null) {
                nitFkNew = em.getReference(nitFkNew.getClass(), nitFkNew.getNit());
                facturaCompra.setNitFk(nitFkNew);
            }
            List<DetalleCompra> attachedDetalleCompraListNew = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraListNewDetalleCompraToAttach : detalleCompraListNew) {
                detalleCompraListNewDetalleCompraToAttach = em.getReference(detalleCompraListNewDetalleCompraToAttach.getClass(), detalleCompraListNewDetalleCompraToAttach.getDetalleCompraPK());
                attachedDetalleCompraListNew.add(detalleCompraListNewDetalleCompraToAttach);
            }
            detalleCompraListNew = attachedDetalleCompraListNew;
            facturaCompra.setDetalleCompraList(detalleCompraListNew);
            facturaCompra = em.merge(facturaCompra);
            if (nitFkOld != null && !nitFkOld.equals(nitFkNew)) {
                nitFkOld.getFacturaCompraList().remove(facturaCompra);
                nitFkOld = em.merge(nitFkOld);
            }
            if (nitFkNew != null && !nitFkNew.equals(nitFkOld)) {
                nitFkNew.getFacturaCompraList().add(facturaCompra);
                nitFkNew = em.merge(nitFkNew);
            }
            for (DetalleCompra detalleCompraListNewDetalleCompra : detalleCompraListNew) {
                if (!detalleCompraListOld.contains(detalleCompraListNewDetalleCompra)) {
                    FacturaCompra oldFacturaCompraOfDetalleCompraListNewDetalleCompra = detalleCompraListNewDetalleCompra.getFacturaCompra();
                    detalleCompraListNewDetalleCompra.setFacturaCompra(facturaCompra);
                    detalleCompraListNewDetalleCompra = em.merge(detalleCompraListNewDetalleCompra);
                    if (oldFacturaCompraOfDetalleCompraListNewDetalleCompra != null && !oldFacturaCompraOfDetalleCompraListNewDetalleCompra.equals(facturaCompra)) {
                        oldFacturaCompraOfDetalleCompraListNewDetalleCompra.getDetalleCompraList().remove(detalleCompraListNewDetalleCompra);
                        oldFacturaCompraOfDetalleCompraListNewDetalleCompra = em.merge(oldFacturaCompraOfDetalleCompraListNewDetalleCompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = facturaCompra.getIdFactura();
                if (findFacturaCompra(id) == null) {
                    throw new NonexistentEntityException("The facturaCompra with id " + id + " no longer exists.");
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
            FacturaCompra facturaCompra;
            try {
                facturaCompra = em.getReference(FacturaCompra.class, id);
                facturaCompra.getIdFactura();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The facturaCompra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DetalleCompra> detalleCompraListOrphanCheck = facturaCompra.getDetalleCompraList();
            for (DetalleCompra detalleCompraListOrphanCheckDetalleCompra : detalleCompraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This FacturaCompra (" + facturaCompra + ") cannot be destroyed since the DetalleCompra " + detalleCompraListOrphanCheckDetalleCompra + " in its detalleCompraList field has a non-nullable facturaCompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Proveedor nitFk = facturaCompra.getNitFk();
            if (nitFk != null) {
                nitFk.getFacturaCompraList().remove(facturaCompra);
                nitFk = em.merge(nitFk);
            }
            em.remove(facturaCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FacturaCompra> findFacturaCompraEntities() {
        return findFacturaCompraEntities(true, -1, -1);
    }

    public List<FacturaCompra> findFacturaCompraEntities(int maxResults, int firstResult) {
        return findFacturaCompraEntities(false, maxResults, firstResult);
    }

    private List<FacturaCompra> findFacturaCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FacturaCompra.class));
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

    public FacturaCompra findFacturaCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FacturaCompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FacturaCompra> rt = cq.from(FacturaCompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
