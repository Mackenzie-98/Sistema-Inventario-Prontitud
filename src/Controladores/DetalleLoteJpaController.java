/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Modelo.DetalleLote;
import Modelo.DetalleLotePK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Lote;
import Modelo.Producto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class DetalleLoteJpaController implements Serializable {

    public DetalleLoteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleLote detalleLote) throws PreexistingEntityException, Exception {
        if (detalleLote.getDetalleLotePK() == null) {
            detalleLote.setDetalleLotePK(new DetalleLotePK());
        }
        detalleLote.getDetalleLotePK().setIdproductoFK(detalleLote.getProducto().getIdProducto());
        detalleLote.getDetalleLotePK().setIdloteFK(detalleLote.getLote().getIdLote());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lote lote = detalleLote.getLote();
            if (lote != null) {
                lote = em.getReference(lote.getClass(), lote.getIdLote());
                detalleLote.setLote(lote);
            }
            Producto producto = detalleLote.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                detalleLote.setProducto(producto);
            }
            em.persist(detalleLote);
            if (lote != null) {
                lote.getDetalleLoteList().add(detalleLote);
                lote = em.merge(lote);
            }
            if (producto != null) {
                producto.getDetalleLoteList().add(detalleLote);
                producto = em.merge(producto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDetalleLote(detalleLote.getDetalleLotePK()) != null) {
                throw new PreexistingEntityException("DetalleLote " + detalleLote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleLote detalleLote) throws NonexistentEntityException, Exception {
        detalleLote.getDetalleLotePK().setIdproductoFK(detalleLote.getProducto().getIdProducto());
        detalleLote.getDetalleLotePK().setIdloteFK(detalleLote.getLote().getIdLote());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleLote persistentDetalleLote = em.find(DetalleLote.class, detalleLote.getDetalleLotePK());
            Lote loteOld = persistentDetalleLote.getLote();
            Lote loteNew = detalleLote.getLote();
            Producto productoOld = persistentDetalleLote.getProducto();
            Producto productoNew = detalleLote.getProducto();
            if (loteNew != null) {
                loteNew = em.getReference(loteNew.getClass(), loteNew.getIdLote());
                detalleLote.setLote(loteNew);
            }
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                detalleLote.setProducto(productoNew);
            }
            detalleLote = em.merge(detalleLote);
            if (loteOld != null && !loteOld.equals(loteNew)) {
                loteOld.getDetalleLoteList().remove(detalleLote);
                loteOld = em.merge(loteOld);
            }
            if (loteNew != null && !loteNew.equals(loteOld)) {
                loteNew.getDetalleLoteList().add(detalleLote);
                loteNew = em.merge(loteNew);
            }
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getDetalleLoteList().remove(detalleLote);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getDetalleLoteList().add(detalleLote);
                productoNew = em.merge(productoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DetalleLotePK id = detalleLote.getDetalleLotePK();
                if (findDetalleLote(id) == null) {
                    throw new NonexistentEntityException("The detalleLote with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DetalleLotePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleLote detalleLote;
            try {
                detalleLote = em.getReference(DetalleLote.class, id);
                detalleLote.getDetalleLotePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleLote with id " + id + " no longer exists.", enfe);
            }
            Lote lote = detalleLote.getLote();
            if (lote != null) {
                lote.getDetalleLoteList().remove(detalleLote);
                lote = em.merge(lote);
            }
            Producto producto = detalleLote.getProducto();
            if (producto != null) {
                producto.getDetalleLoteList().remove(detalleLote);
                producto = em.merge(producto);
            }
            em.remove(detalleLote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleLote> findDetalleLoteEntities() {
        return findDetalleLoteEntities(true, -1, -1);
    }

    public List<DetalleLote> findDetalleLoteEntities(int maxResults, int firstResult) {
        return findDetalleLoteEntities(false, maxResults, firstResult);
    }

    private List<DetalleLote> findDetalleLoteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleLote.class));
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

    public DetalleLote findDetalleLote(DetalleLotePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleLote.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleLoteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleLote> rt = cq.from(DetalleLote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
