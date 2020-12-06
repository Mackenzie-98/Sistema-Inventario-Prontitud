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
import Modelo.Categoria;
import Modelo.Lote;
import Modelo.DetalleCompra;
import java.util.ArrayList;
import java.util.List;
import Modelo.Devolucion;
import Modelo.DetalleVenta;
import Modelo.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author garun
 */
public class ProductoJpaController implements Serializable {

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) throws PreexistingEntityException, Exception {
        if (producto.getDetalleCompraList() == null) {
            producto.setDetalleCompraList(new ArrayList<DetalleCompra>());
        }
        if (producto.getDevolucionList() == null) {
            producto.setDevolucionList(new ArrayList<Devolucion>());
        }
        if (producto.getDetalleVentaList() == null) {
            producto.setDetalleVentaList(new ArrayList<DetalleVenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria idcategoriaFK = producto.getIdcategoriaFK();
            if (idcategoriaFK != null) {
                idcategoriaFK = em.getReference(idcategoriaFK.getClass(), idcategoriaFK.getIdCategoria());
                producto.setIdcategoriaFK(idcategoriaFK);
            }
            Lote idloteFK = producto.getIdloteFK();
            if (idloteFK != null) {
                idloteFK = em.getReference(idloteFK.getClass(), idloteFK.getIdLote());
                producto.setIdloteFK(idloteFK);
            }
            List<DetalleCompra> attachedDetalleCompraList = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraListDetalleCompraToAttach : producto.getDetalleCompraList()) {
                detalleCompraListDetalleCompraToAttach = em.getReference(detalleCompraListDetalleCompraToAttach.getClass(), detalleCompraListDetalleCompraToAttach.getDetalleCompraPK());
                attachedDetalleCompraList.add(detalleCompraListDetalleCompraToAttach);
            }
            producto.setDetalleCompraList(attachedDetalleCompraList);
            List<Devolucion> attachedDevolucionList = new ArrayList<Devolucion>();
            for (Devolucion devolucionListDevolucionToAttach : producto.getDevolucionList()) {
                devolucionListDevolucionToAttach = em.getReference(devolucionListDevolucionToAttach.getClass(), devolucionListDevolucionToAttach.getDevolucionPK());
                attachedDevolucionList.add(devolucionListDevolucionToAttach);
            }
            producto.setDevolucionList(attachedDevolucionList);
            List<DetalleVenta> attachedDetalleVentaList = new ArrayList<DetalleVenta>();
            for (DetalleVenta detalleVentaListDetalleVentaToAttach : producto.getDetalleVentaList()) {
                detalleVentaListDetalleVentaToAttach = em.getReference(detalleVentaListDetalleVentaToAttach.getClass(), detalleVentaListDetalleVentaToAttach.getDetalleVentaPK());
                attachedDetalleVentaList.add(detalleVentaListDetalleVentaToAttach);
            }
            producto.setDetalleVentaList(attachedDetalleVentaList);
            em.persist(producto);
            if (idcategoriaFK != null) {
                idcategoriaFK.getProductoList().add(producto);
                idcategoriaFK = em.merge(idcategoriaFK);
            }
            if (idloteFK != null) {
                idloteFK.getProductoList().add(producto);
                idloteFK = em.merge(idloteFK);
            }
            for (DetalleCompra detalleCompraListDetalleCompra : producto.getDetalleCompraList()) {
                Producto oldProductoOfDetalleCompraListDetalleCompra = detalleCompraListDetalleCompra.getProducto();
                detalleCompraListDetalleCompra.setProducto(producto);
                detalleCompraListDetalleCompra = em.merge(detalleCompraListDetalleCompra);
                if (oldProductoOfDetalleCompraListDetalleCompra != null) {
                    oldProductoOfDetalleCompraListDetalleCompra.getDetalleCompraList().remove(detalleCompraListDetalleCompra);
                    oldProductoOfDetalleCompraListDetalleCompra = em.merge(oldProductoOfDetalleCompraListDetalleCompra);
                }
            }
            for (Devolucion devolucionListDevolucion : producto.getDevolucionList()) {
                Producto oldProductoOfDevolucionListDevolucion = devolucionListDevolucion.getProducto();
                devolucionListDevolucion.setProducto(producto);
                devolucionListDevolucion = em.merge(devolucionListDevolucion);
                if (oldProductoOfDevolucionListDevolucion != null) {
                    oldProductoOfDevolucionListDevolucion.getDevolucionList().remove(devolucionListDevolucion);
                    oldProductoOfDevolucionListDevolucion = em.merge(oldProductoOfDevolucionListDevolucion);
                }
            }
            for (DetalleVenta detalleVentaListDetalleVenta : producto.getDetalleVentaList()) {
                Producto oldProductoOfDetalleVentaListDetalleVenta = detalleVentaListDetalleVenta.getProducto();
                detalleVentaListDetalleVenta.setProducto(producto);
                detalleVentaListDetalleVenta = em.merge(detalleVentaListDetalleVenta);
                if (oldProductoOfDetalleVentaListDetalleVenta != null) {
                    oldProductoOfDetalleVentaListDetalleVenta.getDetalleVentaList().remove(detalleVentaListDetalleVenta);
                    oldProductoOfDetalleVentaListDetalleVenta = em.merge(oldProductoOfDetalleVentaListDetalleVenta);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducto(producto.getIdProducto()) != null) {
                throw new PreexistingEntityException("Producto " + producto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Categoria idcategoriaFKOld = persistentProducto.getIdcategoriaFK();
            Categoria idcategoriaFKNew = producto.getIdcategoriaFK();
            Lote idloteFKOld = persistentProducto.getIdloteFK();
            Lote idloteFKNew = producto.getIdloteFK();
            List<DetalleCompra> detalleCompraListOld = persistentProducto.getDetalleCompraList();
            List<DetalleCompra> detalleCompraListNew = producto.getDetalleCompraList();
            List<Devolucion> devolucionListOld = persistentProducto.getDevolucionList();
            List<Devolucion> devolucionListNew = producto.getDevolucionList();
            List<DetalleVenta> detalleVentaListOld = persistentProducto.getDetalleVentaList();
            List<DetalleVenta> detalleVentaListNew = producto.getDetalleVentaList();
            List<String> illegalOrphanMessages = null;
            for (DetalleCompra detalleCompraListOldDetalleCompra : detalleCompraListOld) {
                if (!detalleCompraListNew.contains(detalleCompraListOldDetalleCompra)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleCompra " + detalleCompraListOldDetalleCompra + " since its producto field is not nullable.");
                }
            }
            for (Devolucion devolucionListOldDevolucion : devolucionListOld) {
                if (!devolucionListNew.contains(devolucionListOldDevolucion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Devolucion " + devolucionListOldDevolucion + " since its producto field is not nullable.");
                }
            }
            for (DetalleVenta detalleVentaListOldDetalleVenta : detalleVentaListOld) {
                if (!detalleVentaListNew.contains(detalleVentaListOldDetalleVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleVenta " + detalleVentaListOldDetalleVenta + " since its producto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idcategoriaFKNew != null) {
                idcategoriaFKNew = em.getReference(idcategoriaFKNew.getClass(), idcategoriaFKNew.getIdCategoria());
                producto.setIdcategoriaFK(idcategoriaFKNew);
            }
            if (idloteFKNew != null) {
                idloteFKNew = em.getReference(idloteFKNew.getClass(), idloteFKNew.getIdLote());
                producto.setIdloteFK(idloteFKNew);
            }
            List<DetalleCompra> attachedDetalleCompraListNew = new ArrayList<DetalleCompra>();
            for (DetalleCompra detalleCompraListNewDetalleCompraToAttach : detalleCompraListNew) {
                detalleCompraListNewDetalleCompraToAttach = em.getReference(detalleCompraListNewDetalleCompraToAttach.getClass(), detalleCompraListNewDetalleCompraToAttach.getDetalleCompraPK());
                attachedDetalleCompraListNew.add(detalleCompraListNewDetalleCompraToAttach);
            }
            detalleCompraListNew = attachedDetalleCompraListNew;
            producto.setDetalleCompraList(detalleCompraListNew);
            List<Devolucion> attachedDevolucionListNew = new ArrayList<Devolucion>();
            for (Devolucion devolucionListNewDevolucionToAttach : devolucionListNew) {
                devolucionListNewDevolucionToAttach = em.getReference(devolucionListNewDevolucionToAttach.getClass(), devolucionListNewDevolucionToAttach.getDevolucionPK());
                attachedDevolucionListNew.add(devolucionListNewDevolucionToAttach);
            }
            devolucionListNew = attachedDevolucionListNew;
            producto.setDevolucionList(devolucionListNew);
            List<DetalleVenta> attachedDetalleVentaListNew = new ArrayList<DetalleVenta>();
            for (DetalleVenta detalleVentaListNewDetalleVentaToAttach : detalleVentaListNew) {
                detalleVentaListNewDetalleVentaToAttach = em.getReference(detalleVentaListNewDetalleVentaToAttach.getClass(), detalleVentaListNewDetalleVentaToAttach.getDetalleVentaPK());
                attachedDetalleVentaListNew.add(detalleVentaListNewDetalleVentaToAttach);
            }
            detalleVentaListNew = attachedDetalleVentaListNew;
            producto.setDetalleVentaList(detalleVentaListNew);
            producto = em.merge(producto);
            if (idcategoriaFKOld != null && !idcategoriaFKOld.equals(idcategoriaFKNew)) {
                idcategoriaFKOld.getProductoList().remove(producto);
                idcategoriaFKOld = em.merge(idcategoriaFKOld);
            }
            if (idcategoriaFKNew != null && !idcategoriaFKNew.equals(idcategoriaFKOld)) {
                idcategoriaFKNew.getProductoList().add(producto);
                idcategoriaFKNew = em.merge(idcategoriaFKNew);
            }
            if (idloteFKOld != null && !idloteFKOld.equals(idloteFKNew)) {
                idloteFKOld.getProductoList().remove(producto);
                idloteFKOld = em.merge(idloteFKOld);
            }
            if (idloteFKNew != null && !idloteFKNew.equals(idloteFKOld)) {
                idloteFKNew.getProductoList().add(producto);
                idloteFKNew = em.merge(idloteFKNew);
            }
            for (DetalleCompra detalleCompraListNewDetalleCompra : detalleCompraListNew) {
                if (!detalleCompraListOld.contains(detalleCompraListNewDetalleCompra)) {
                    Producto oldProductoOfDetalleCompraListNewDetalleCompra = detalleCompraListNewDetalleCompra.getProducto();
                    detalleCompraListNewDetalleCompra.setProducto(producto);
                    detalleCompraListNewDetalleCompra = em.merge(detalleCompraListNewDetalleCompra);
                    if (oldProductoOfDetalleCompraListNewDetalleCompra != null && !oldProductoOfDetalleCompraListNewDetalleCompra.equals(producto)) {
                        oldProductoOfDetalleCompraListNewDetalleCompra.getDetalleCompraList().remove(detalleCompraListNewDetalleCompra);
                        oldProductoOfDetalleCompraListNewDetalleCompra = em.merge(oldProductoOfDetalleCompraListNewDetalleCompra);
                    }
                }
            }
            for (Devolucion devolucionListNewDevolucion : devolucionListNew) {
                if (!devolucionListOld.contains(devolucionListNewDevolucion)) {
                    Producto oldProductoOfDevolucionListNewDevolucion = devolucionListNewDevolucion.getProducto();
                    devolucionListNewDevolucion.setProducto(producto);
                    devolucionListNewDevolucion = em.merge(devolucionListNewDevolucion);
                    if (oldProductoOfDevolucionListNewDevolucion != null && !oldProductoOfDevolucionListNewDevolucion.equals(producto)) {
                        oldProductoOfDevolucionListNewDevolucion.getDevolucionList().remove(devolucionListNewDevolucion);
                        oldProductoOfDevolucionListNewDevolucion = em.merge(oldProductoOfDevolucionListNewDevolucion);
                    }
                }
            }
            for (DetalleVenta detalleVentaListNewDetalleVenta : detalleVentaListNew) {
                if (!detalleVentaListOld.contains(detalleVentaListNewDetalleVenta)) {
                    Producto oldProductoOfDetalleVentaListNewDetalleVenta = detalleVentaListNewDetalleVenta.getProducto();
                    detalleVentaListNewDetalleVenta.setProducto(producto);
                    detalleVentaListNewDetalleVenta = em.merge(detalleVentaListNewDetalleVenta);
                    if (oldProductoOfDetalleVentaListNewDetalleVenta != null && !oldProductoOfDetalleVentaListNewDetalleVenta.equals(producto)) {
                        oldProductoOfDetalleVentaListNewDetalleVenta.getDetalleVentaList().remove(detalleVentaListNewDetalleVenta);
                        oldProductoOfDetalleVentaListNewDetalleVenta = em.merge(oldProductoOfDetalleVentaListNewDetalleVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<DetalleCompra> detalleCompraListOrphanCheck = producto.getDetalleCompraList();
            for (DetalleCompra detalleCompraListOrphanCheckDetalleCompra : detalleCompraListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DetalleCompra " + detalleCompraListOrphanCheckDetalleCompra + " in its detalleCompraList field has a non-nullable producto field.");
            }
            List<Devolucion> devolucionListOrphanCheck = producto.getDevolucionList();
            for (Devolucion devolucionListOrphanCheckDevolucion : devolucionListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the Devolucion " + devolucionListOrphanCheckDevolucion + " in its devolucionList field has a non-nullable producto field.");
            }
            List<DetalleVenta> detalleVentaListOrphanCheck = producto.getDetalleVentaList();
            for (DetalleVenta detalleVentaListOrphanCheckDetalleVenta : detalleVentaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producto (" + producto + ") cannot be destroyed since the DetalleVenta " + detalleVentaListOrphanCheckDetalleVenta + " in its detalleVentaList field has a non-nullable producto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Categoria idcategoriaFK = producto.getIdcategoriaFK();
            if (idcategoriaFK != null) {
                idcategoriaFK.getProductoList().remove(producto);
                idcategoriaFK = em.merge(idcategoriaFK);
            }
            Lote idloteFK = producto.getIdloteFK();
            if (idloteFK != null) {
                idloteFK.getProductoList().remove(producto);
                idloteFK = em.merge(idloteFK);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
