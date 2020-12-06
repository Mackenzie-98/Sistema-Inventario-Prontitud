/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Modelo.Lote;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class LoteJpaController1 implements Serializable {

    public LoteJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lote lote) throws PreexistingEntityException, Exception {
        if (lote.getProductoList() == null) {
            lote.setProductoList(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedProductoList = new ArrayList<Producto>();
            for (Producto productoListProductoToAttach : lote.getProductoList()) {
                productoListProductoToAttach = em.getReference(productoListProductoToAttach.getClass(), productoListProductoToAttach.getIdProducto());
                attachedProductoList.add(productoListProductoToAttach);
            }
            lote.setProductoList(attachedProductoList);
            em.persist(lote);
            for (Producto productoListProducto : lote.getProductoList()) {
                Lote oldIdloteFKOfProductoListProducto = productoListProducto.getIdloteFK();
                productoListProducto.setIdloteFK(lote);
                productoListProducto = em.merge(productoListProducto);
                if (oldIdloteFKOfProductoListProducto != null) {
                    oldIdloteFKOfProductoListProducto.getProductoList().remove(productoListProducto);
                    oldIdloteFKOfProductoListProducto = em.merge(oldIdloteFKOfProductoListProducto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLote(lote.getIdLote()) != null) {
                throw new PreexistingEntityException("Lote " + lote + " already exists.", ex);
            }
            throw ex;
        } finally {
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
            List<Producto> productoListOld = persistentLote.getProductoList();
            List<Producto> productoListNew = lote.getProductoList();
            List<String> illegalOrphanMessages = null;
            for (Producto productoListOldProducto : productoListOld) {
                if (!productoListNew.contains(productoListOldProducto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producto " + productoListOldProducto + " since its idloteFK field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Producto> attachedProductoListNew = new ArrayList<Producto>();
            for (Producto productoListNewProductoToAttach : productoListNew) {
                productoListNewProductoToAttach = em.getReference(productoListNewProductoToAttach.getClass(), productoListNewProductoToAttach.getIdProducto());
                attachedProductoListNew.add(productoListNewProductoToAttach);
            }
            productoListNew = attachedProductoListNew;
            lote.setProductoList(productoListNew);
            lote = em.merge(lote);
            for (Producto productoListNewProducto : productoListNew) {
                if (!productoListOld.contains(productoListNewProducto)) {
                    Lote oldIdloteFKOfProductoListNewProducto = productoListNewProducto.getIdloteFK();
                    productoListNewProducto.setIdloteFK(lote);
                    productoListNewProducto = em.merge(productoListNewProducto);
                    if (oldIdloteFKOfProductoListNewProducto != null && !oldIdloteFKOfProductoListNewProducto.equals(lote)) {
                        oldIdloteFKOfProductoListNewProducto.getProductoList().remove(productoListNewProducto);
                        oldIdloteFKOfProductoListNewProducto = em.merge(oldIdloteFKOfProductoListNewProducto);
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
            List<Producto> productoListOrphanCheck = lote.getProductoList();
            for (Producto productoListOrphanCheckProducto : productoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Lote (" + lote + ") cannot be destroyed since the Producto " + productoListOrphanCheckProducto + " in its productoList field has a non-nullable idloteFK field.");
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
