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
import Modelo.DetalleLote;
import Modelo.Lote;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author garun
 */
public class LoteJpaController implements Serializable {

    public LoteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lote lote) {
        if (lote.getDetalleLoteList() == null) {
            lote.setDetalleLoteList(new ArrayList<DetalleLote>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<DetalleLote> attachedDetalleLoteList = new ArrayList<DetalleLote>();
            for (DetalleLote detalleLoteListDetalleLoteToAttach : lote.getDetalleLoteList()) {
                detalleLoteListDetalleLoteToAttach = em.getReference(detalleLoteListDetalleLoteToAttach.getClass(), detalleLoteListDetalleLoteToAttach.getDetalleLotePK());
                attachedDetalleLoteList.add(detalleLoteListDetalleLoteToAttach);
            }
            lote.setDetalleLoteList(attachedDetalleLoteList);
            em.persist(lote);
            for (DetalleLote detalleLoteListDetalleLote : lote.getDetalleLoteList()) {
                Lote oldLoteOfDetalleLoteListDetalleLote = detalleLoteListDetalleLote.getLote();
                detalleLoteListDetalleLote.setLote(lote);
                detalleLoteListDetalleLote = em.merge(detalleLoteListDetalleLote);
                if (oldLoteOfDetalleLoteListDetalleLote != null) {
                    oldLoteOfDetalleLoteListDetalleLote.getDetalleLoteList().remove(detalleLoteListDetalleLote);
                    oldLoteOfDetalleLoteListDetalleLote = em.merge(oldLoteOfDetalleLoteListDetalleLote);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLote(lote.getIdLote()) != null) {
                JOptionPane.showMessageDialog(null, "ERROR: Lote ya existente", "ERROR", JOptionPane.WARNING_MESSAGE);
                //throw new PreexistingEntityException("Cliente " + cliente + " already exists.", ex);
            }
            throw ex;        
        }finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lote lote) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lote persistentLote = em.find(Lote.class, lote.getIdLote());
            List<DetalleLote> detalleLoteListOld = persistentLote.getDetalleLoteList();
            List<DetalleLote> detalleLoteListNew = lote.getDetalleLoteList();
            List<String> illegalOrphanMessages = null;
            for (DetalleLote detalleLoteListOldDetalleLote : detalleLoteListOld) {
                if (!detalleLoteListNew.contains(detalleLoteListOldDetalleLote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleLote " + detalleLoteListOldDetalleLote + " since its lote field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<DetalleLote> attachedDetalleLoteListNew = new ArrayList<DetalleLote>();
            for (DetalleLote detalleLoteListNewDetalleLoteToAttach : detalleLoteListNew) {
                detalleLoteListNewDetalleLoteToAttach = em.getReference(detalleLoteListNewDetalleLoteToAttach.getClass(), detalleLoteListNewDetalleLoteToAttach.getDetalleLotePK());
                attachedDetalleLoteListNew.add(detalleLoteListNewDetalleLoteToAttach);
            }
            detalleLoteListNew = attachedDetalleLoteListNew;
            lote.setDetalleLoteList(detalleLoteListNew);
            lote = em.merge(lote);
            for (DetalleLote detalleLoteListNewDetalleLote : detalleLoteListNew) {
                if (!detalleLoteListOld.contains(detalleLoteListNewDetalleLote)) {
                    Lote oldLoteOfDetalleLoteListNewDetalleLote = detalleLoteListNewDetalleLote.getLote();
                    detalleLoteListNewDetalleLote.setLote(lote);
                    detalleLoteListNewDetalleLote = em.merge(detalleLoteListNewDetalleLote);
                    if (oldLoteOfDetalleLoteListNewDetalleLote != null && !oldLoteOfDetalleLoteListNewDetalleLote.equals(lote)) {
                        oldLoteOfDetalleLoteListNewDetalleLote.getDetalleLoteList().remove(detalleLoteListNewDetalleLote);
                        oldLoteOfDetalleLoteListNewDetalleLote = em.merge(oldLoteOfDetalleLoteListNewDetalleLote);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = lote.getIdLote();
                if (findLote(id) == null) {
                    throw new NonexistentEntityException("The lote with id " + id + " no longer exists.");
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
            Lote lote;
            try {
                lote = em.getReference(Lote.class, id);
                lote.getIdLote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lote with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DetalleLote> detalleLoteListOrphanCheck = lote.getDetalleLoteList();
            for (DetalleLote detalleLoteListOrphanCheckDetalleLote : detalleLoteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Lote (" + lote + ") cannot be destroyed since the DetalleLote " + detalleLoteListOrphanCheckDetalleLote + " in its detalleLoteList field has a non-nullable lote field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(lote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lote> findLoteEntities() {
        return findLoteEntities(true, -1, -1);
    }

    public List<Lote> findLoteEntities(int maxResults, int firstResult) {
        return findLoteEntities(false, maxResults, firstResult);
    }

    private List<Lote> findLoteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lote.class));
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

    public Lote findLote(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lote.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lote> rt = cq.from(Lote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
