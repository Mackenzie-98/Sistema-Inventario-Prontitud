/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author garun
 */
@Entity
@Table(name = "Detalle_Compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCompra.findAll", query = "SELECT d FROM DetalleCompra d")
    , @NamedQuery(name = "DetalleCompra.findByIdproductoFK", query = "SELECT d FROM DetalleCompra d WHERE d.detalleCompraPK.idproductoFK = :idproductoFK")
    , @NamedQuery(name = "DetalleCompra.findByIdfacturaFK", query = "SELECT d FROM DetalleCompra d WHERE d.detalleCompraPK.idfacturaFK = :idfacturaFK")
    , @NamedQuery(name = "DetalleCompra.findByCantidad", query = "SELECT d FROM DetalleCompra d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleCompra.findByPrecioUnitario", query = "SELECT d FROM DetalleCompra d WHERE d.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "DetalleCompra.findByDescuento", query = "SELECT d FROM DetalleCompra d WHERE d.descuento = :descuento")})
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCompraPK detalleCompraPK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "precio_unitario")
    private long precioUnitario;
    @Column(name = "descuento")
    private Long descuento;
    @JoinColumn(name = "id_factura_FK", referencedColumnName = "id_factura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FacturaCompra facturaCompra;
    @JoinColumn(name = "id_producto_FK", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public DetalleCompra() {
    }

    public DetalleCompra(DetalleCompraPK detalleCompraPK) {
        this.detalleCompraPK = detalleCompraPK;
    }

    public DetalleCompra(DetalleCompraPK detalleCompraPK, int cantidad, long precioUnitario) {
        this.detalleCompraPK = detalleCompraPK;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetalleCompra(int idproductoFK, int idfacturaFK) {
        this.detalleCompraPK = new DetalleCompraPK(idproductoFK, idfacturaFK);
    }

    public DetalleCompraPK getDetalleCompraPK() {
        return detalleCompraPK;
    }

    public void setDetalleCompraPK(DetalleCompraPK detalleCompraPK) {
        this.detalleCompraPK = detalleCompraPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(long precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Long getDescuento() {
        return descuento;
    }

    public void setDescuento(Long descuento) {
        this.descuento = descuento;
    }

    public FacturaCompra getFacturaCompra() {
        return facturaCompra;
    }

    public void setFacturaCompra(FacturaCompra facturaCompra) {
        this.facturaCompra = facturaCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCompraPK != null ? detalleCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.detalleCompraPK == null && other.detalleCompraPK != null) || (this.detalleCompraPK != null && !this.detalleCompraPK.equals(other.detalleCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetalleCompra[ detalleCompraPK=" + detalleCompraPK + " ]";
    }
    
}
