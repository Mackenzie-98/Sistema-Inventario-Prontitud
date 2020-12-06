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
@Table(name = "Detalle_Venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")
    , @NamedQuery(name = "DetalleVenta.findByIdfacturaFK", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.idfacturaFK = :idfacturaFK")
    , @NamedQuery(name = "DetalleVenta.findByIdproductoFK", query = "SELECT d FROM DetalleVenta d WHERE d.detalleVentaPK.idproductoFK = :idproductoFK")
    , @NamedQuery(name = "DetalleVenta.findByCantidad", query = "SELECT d FROM DetalleVenta d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleVenta.findByPrecioUnitario", query = "SELECT d FROM DetalleVenta d WHERE d.precioUnitario = :precioUnitario")
    , @NamedQuery(name = "DetalleVenta.findByDescuento", query = "SELECT d FROM DetalleVenta d WHERE d.descuento = :descuento")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleVentaPK detalleVentaPK;
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
    private FacturaVenta facturaVenta;
    @JoinColumn(name = "id_producto_FK", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public DetalleVenta() {
    }

    public DetalleVenta(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
    }

    public DetalleVenta(DetalleVentaPK detalleVentaPK, int cantidad, long precioUnitario) {
        this.detalleVentaPK = detalleVentaPK;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetalleVenta(int idfacturaFK, int idproductoFK) {
        this.detalleVentaPK = new DetalleVentaPK(idfacturaFK, idproductoFK);
    }

    public DetalleVentaPK getDetalleVentaPK() {
        return detalleVentaPK;
    }

    public void setDetalleVentaPK(DetalleVentaPK detalleVentaPK) {
        this.detalleVentaPK = detalleVentaPK;
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

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
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
        hash += (detalleVentaPK != null ? detalleVentaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.detalleVentaPK == null && other.detalleVentaPK != null) || (this.detalleVentaPK != null && !this.detalleVentaPK.equals(other.detalleVentaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetalleVenta[ detalleVentaPK=" + detalleVentaPK + " ]";
    }
    
}
