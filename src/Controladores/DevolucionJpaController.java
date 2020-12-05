/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Modelo.Devolucion;
import Modelo.DevolucionPK;
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
public class DevolucionJpaController implements Serializable {

    public DevolucionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Devolucion devolucion) throws PreexistingEntityException, Exception {
        if (devolucion.getDevolucionPK() == null) {
            devolucion.setDevolucionPK(new DevolucionPK());
        }
        devolucion.getDevolucionPK().setIdFactura(devolucion.getFacturaVenta().getIdFactura());
        devolucion.getDevolucionPK().setIdProducto(devolucion.getProducto().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FacturaVenta facturaVenta = devolucion.getFacturaVenta();
            if (facturaVenta != null) {
                facturaVenta = em.getReference(facturaVenta.getClass(), facturaVenta.getIdFactura());
                devolucion.setFacturaVenta(facturaVenta);
            }
            Producto producto = devolucion.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                devolucion.setProducto(producto);
            }
            em.persist(devolucion);
            if (facturaVenta != null) {
                facturaVenta.getDevolucionList().add(devolucion);
                facturaVenta = em.merge(facturaVenta);
            }
            if (producto != null) {
                producto.getDevolucionList().add(devolucion);
                producto = em.merge(producto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDevolucion(devolucion.getDevolucionPK()) != null) {
                throw new PreexistingEntityException("Devolucion " + devolucion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Devolucion devolucion) throws NonexistentEntityException, Exception {
        devolucion.getDevolucionPK().setIdFactura(devolucion.getFacturaVenta().getIdFactura());
        devolucion.getDevolucionPK().setIdProducto(devolucion.getProducto().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Devolucion persistentDevolucion = em.find(Devolucion.class, devolucion.getDevolucionPK());
            FacturaVenta facturaVentaOld = persistentDevolucion.getFacturaVenta();
            FacturaVenta facturaVentaNew = devolucion.getFacturaVenta();
            Producto productoOld = persistentDevolucion.getProducto();
            Producto productoNew = devolucion.getProducto();
            if (facturaVentaNew != null) {
                facturaVentaNew = em.getReference(facturaVentaNew.getClass(), facturaVentaNew.getIdFactura());
                devolucion.setFacturaVenta(facturaVentaNew);
            }
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                devolucion.setProducto(productoNew);
            }
            devolucion = em.merge(devolucion);
            if (facturaVentaOld != null && !facturaVentaOld.equals(facturaVentaNew)) {
                facturaVentaOld.getDevolucionList().remove(devolucion);
                facturaVentaOld = em.merge(facturaVentaOld);
            }
            if (facturaVentaNew != null && !facturaVentaNew.equals(facturaVentaOld)) {
                facturaVentaNew.getDevolucionList().add(devolucion);
                facturaVentaNew = em.merge(facturaVentaNew);
            }
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getDevolucionList().remove(devolucion);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getDevolucionList().add(devolucion);
                productoNew = em.merge(productoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DevolucionPK id = devolucion.getDevolucionPK();
                if (findDevolucion(id) == null) {
                    throw new NonexistentEntityException("The devolucion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DevolucionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Devolucion devolucion;
            try {
                devolucion = em.getReference(Devolucion.class, id);
                devolucion.getDevolucionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The devolucion with id " + id + " no longer exists.", enfe);
            }
            FacturaVenta facturaVenta = devolucion.getFacturaVenta();
            if (facturaVenta != null) {
                facturaVenta.getDevolucionList().remove(devolucion);
                facturaVenta = em.merge(facturaVenta);
            }
            Producto producto = devolucion.getProducto();
            if (producto != null) {
                producto.getDevolucionList().remove(devolucion);
                producto = em.merge(producto);
            }
            em.remove(devolucion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Devolucion> findDevolucionEntities() {
        return findDevolucionEntities(true, -1, -1);
    }

    public List<Devolucion> findDevolucionEntities(int maxResults, int firstResult) {
        return findDevolucionEntities(false, maxResults, firstResult);
    }

    private List<Devolucion> findDevolucionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Devolucion.class));
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

    public Devolucion findDevolucion(DevolucionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Devolucion.class, id);
        } finally {
            em.close();
        }
    }

    public int getDevolucionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Devolucion> rt = cq.from(Devolucion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
