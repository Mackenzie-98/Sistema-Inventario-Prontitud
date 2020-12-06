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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
        detalleLote.getDetalleLotePK().setIdloteFK(detalleLote.getLote().getIdLote());
        detalleLote.getDetalleLotePK().setIdproductoFK(detalleLote.getProducto().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(detalleLote);
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
        detalleLote.getDetalleLotePK().setIdloteFK(detalleLote.getLote().getIdLote());
        detalleLote.getDetalleLotePK().setIdproductoFK(detalleLote.getProducto().getIdProducto());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            detalleLote = em.merge(detalleLote);
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
