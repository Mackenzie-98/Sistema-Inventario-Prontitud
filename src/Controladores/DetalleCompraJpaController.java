/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Modelo.DetalleCompra;
import Modelo.DetalleCompraPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.FacturaCompra;
import Modelo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class DetalleCompraJpaController implements Serializable {

    public DetalleCompraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleCompra detalleCompra) throws PreexistingEntityException, Exception {
        if (detalleCompra.getDetalleCompraPK() == null) {
            detalleCompra.setDetalleCompraPK(new DetalleCompraPK());
        }
        detalleCompra.getDetalleCompraPK().setIdfacturaFK(detalleCompra.getFacturaCompra().getIdFactura());
        detalleCompra.getDetalleCompraPK().setIdproductoFK(detalleCompra.getProducto().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaCompra facturaCompra = detalleCompra.getFacturaCompra();
            if (facturaCompra != null) {
                facturaCompra = em.getReference(facturaCompra.getClass(), facturaCompra.getIdFactura());
                detalleCompra.setFacturaCompra(facturaCompra);
            }
            Producto producto = detalleCompra.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                detalleCompra.setProducto(producto);
            }
            em.persist(detalleCompra);
            if (facturaCompra != null) {
                facturaCompra.getDetalleCompraList().add(detalleCompra);
                facturaCompra = em.merge(facturaCompra);
            }
            if (producto != null) {
                producto.getDetalleCompraList().add(detalleCompra);
                producto = em.merge(producto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalleCompra(detalleCompra.getDetalleCompraPK()) != null) {
                throw new PreexistingEntityException("DetalleCompra " + detalleCompra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleCompra detalleCompra) throws NonexistentEntityException, Exception {
        detalleCompra.getDetalleCompraPK().setIdfacturaFK(detalleCompra.getFacturaCompra().getIdFactura());
        detalleCompra.getDetalleCompraPK().setIdproductoFK(detalleCompra.getProducto().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleCompra persistentDetalleCompra = em.find(DetalleCompra.class, detalleCompra.getDetalleCompraPK());
            FacturaCompra facturaCompraOld = persistentDetalleCompra.getFacturaCompra();
            FacturaCompra facturaCompraNew = detalleCompra.getFacturaCompra();
            Producto productoOld = persistentDetalleCompra.getProducto();
            Producto productoNew = detalleCompra.getProducto();
            if (facturaCompraNew != null) {
                facturaCompraNew = em.getReference(facturaCompraNew.getClass(), facturaCompraNew.getIdFactura());
                detalleCompra.setFacturaCompra(facturaCompraNew);
            }
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                detalleCompra.setProducto(productoNew);
            }
            detalleCompra = em.merge(detalleCompra);
            if (facturaCompraOld != null && !facturaCompraOld.equals(facturaCompraNew)) {
                facturaCompraOld.getDetalleCompraList().remove(detalleCompra);
                facturaCompraOld = em.merge(facturaCompraOld);
            }
            if (facturaCompraNew != null && !facturaCompraNew.equals(facturaCompraOld)) {
                facturaCompraNew.getDetalleCompraList().add(detalleCompra);
                facturaCompraNew = em.merge(facturaCompraNew);
            }
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getDetalleCompraList().remove(detalleCompra);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getDetalleCompraList().add(detalleCompra);
                productoNew = em.merge(productoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetalleCompraPK id = detalleCompra.getDetalleCompraPK();
                if (findDetalleCompra(id) == null) {
                    throw new NonexistentEntityException("The detalleCompra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetalleCompraPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleCompra detalleCompra;
            try {
                detalleCompra = em.getReference(DetalleCompra.class, id);
                detalleCompra.getDetalleCompraPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleCompra with id " + id + " no longer exists.", enfe);
            }
            FacturaCompra facturaCompra = detalleCompra.getFacturaCompra();
            if (facturaCompra != null) {
                facturaCompra.getDetalleCompraList().remove(detalleCompra);
                facturaCompra = em.merge(facturaCompra);
            }
            Producto producto = detalleCompra.getProducto();
            if (producto != null) {
                producto.getDetalleCompraList().remove(detalleCompra);
                producto = em.merge(producto);
            }
            em.remove(detalleCompra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleCompra> findDetalleCompraEntities() {
        return findDetalleCompraEntities(true, -1, -1);
    }

    public List<DetalleCompra> findDetalleCompraEntities(int maxResults, int firstResult) {
        return findDetalleCompraEntities(false, maxResults, firstResult);
    }

    private List<DetalleCompra> findDetalleCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleCompra.class));
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

    public DetalleCompra findDetalleCompra(DetalleCompraPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleCompra.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleCompra> rt = cq.from(DetalleCompra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
