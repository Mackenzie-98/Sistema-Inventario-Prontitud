/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Modelo.DetalleVenta;
import Modelo.DetalleVentaPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.FacturaVenta;
import Modelo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class DetalleVentaJpaController implements Serializable {

    public DetalleVentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleVenta detalleVenta) throws PreexistingEntityException, Exception {
        if (detalleVenta.getDetalleVentaPK() == null) {
            detalleVenta.setDetalleVentaPK(new DetalleVentaPK());
        }
        detalleVenta.getDetalleVentaPK().setIdproductoFK(detalleVenta.getProducto().getIdProducto());
        detalleVenta.getDetalleVentaPK().setIdfacturaFK(detalleVenta.getFacturaVenta().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaVenta facturaVenta = detalleVenta.getFacturaVenta();
            if (facturaVenta != null) {
                facturaVenta = em.getReference(facturaVenta.getClass(), facturaVenta.getIdFactura());
                detalleVenta.setFacturaVenta(facturaVenta);
            }
            Producto producto = detalleVenta.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                detalleVenta.setProducto(producto);
            }
            em.persist(detalleVenta);
            if (facturaVenta != null) {
                facturaVenta.getDetalleVentaList().add(detalleVenta);
                facturaVenta = em.merge(facturaVenta);
            }
            if (producto != null) {
                producto.getDetalleVentaList().add(detalleVenta);
                producto = em.merge(producto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalleVenta(detalleVenta.getDetalleVentaPK()) != null) {
                throw new PreexistingEntityException("DetalleVenta " + detalleVenta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleVenta detalleVenta) throws NonexistentEntityException, Exception {
        detalleVenta.getDetalleVentaPK().setIdproductoFK(detalleVenta.getProducto().getIdProducto());
        detalleVenta.getDetalleVentaPK().setIdfacturaFK(detalleVenta.getFacturaVenta().getIdFactura());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleVenta persistentDetalleVenta = em.find(DetalleVenta.class, detalleVenta.getDetalleVentaPK());
            FacturaVenta facturaVentaOld = persistentDetalleVenta.getFacturaVenta();
            FacturaVenta facturaVentaNew = detalleVenta.getFacturaVenta();
            Producto productoOld = persistentDetalleVenta.getProducto();
            Producto productoNew = detalleVenta.getProducto();
            if (facturaVentaNew != null) {
                facturaVentaNew = em.getReference(facturaVentaNew.getClass(), facturaVentaNew.getIdFactura());
                detalleVenta.setFacturaVenta(facturaVentaNew);
            }
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                detalleVenta.setProducto(productoNew);
            }
            detalleVenta = em.merge(detalleVenta);
            if (facturaVentaOld != null && !facturaVentaOld.equals(facturaVentaNew)) {
                facturaVentaOld.getDetalleVentaList().remove(detalleVenta);
                facturaVentaOld = em.merge(facturaVentaOld);
            }
            if (facturaVentaNew != null && !facturaVentaNew.equals(facturaVentaOld)) {
                facturaVentaNew.getDetalleVentaList().add(detalleVenta);
                facturaVentaNew = em.merge(facturaVentaNew);
            }
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getDetalleVentaList().remove(detalleVenta);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getDetalleVentaList().add(detalleVenta);
                productoNew = em.merge(productoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetalleVentaPK id = detalleVenta.getDetalleVentaPK();
                if (findDetalleVenta(id) == null) {
                    throw new NonexistentEntityException("The detalleVenta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetalleVentaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleVenta detalleVenta;
            try {
                detalleVenta = em.getReference(DetalleVenta.class, id);
                detalleVenta.getDetalleVentaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleVenta with id " + id + " no longer exists.", enfe);
            }
            FacturaVenta facturaVenta = detalleVenta.getFacturaVenta();
            if (facturaVenta != null) {
                facturaVenta.getDetalleVentaList().remove(detalleVenta);
                facturaVenta = em.merge(facturaVenta);
            }
            Producto producto = detalleVenta.getProducto();
            if (producto != null) {
                producto.getDetalleVentaList().remove(detalleVenta);
                producto = em.merge(producto);
            }
            em.remove(detalleVenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleVenta> findDetalleVentaEntities() {
        return findDetalleVentaEntities(true, -1, -1);
    }

    public List<DetalleVenta> findDetalleVentaEntities(int maxResults, int firstResult) {
        return findDetalleVentaEntities(false, maxResults, firstResult);
    }

    private List<DetalleVenta> findDetalleVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleVenta.class));
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

    public DetalleVenta findDetalleVenta(DetalleVentaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleVenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleVenta> rt = cq.from(DetalleVenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
