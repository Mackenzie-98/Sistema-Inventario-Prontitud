/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controladores.FacturaVentaJpaController;
import java.io.Serializable;
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
@Table(name = "Devolucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Devolucion.findAll", query = "SELECT d FROM Devolucion d")
    , @NamedQuery(name = "Devolucion.findByIdFactura", query = "SELECT d FROM Devolucion d WHERE d.devolucionPK.idFactura = :idFactura")
    , @NamedQuery(name = "Devolucion.findByIdProducto", query = "SELECT d FROM Devolucion d WHERE d.devolucionPK.idProducto = :idProducto")
    , @NamedQuery(name = "Devolucion.findByDescripcion", query = "SELECT d FROM Devolucion d WHERE d.descripcion = :descripcion")})
public class Devolucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DevolucionPK devolucionPK;
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FacturaVenta facturaVenta;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public Devolucion() {
    }
    public Devolucion(FacturaVenta factura,Producto producto,String descripcion){
        this.facturaVenta=factura;
        this.producto=producto;
        this.descripcion=descripcion;
    }

    public Devolucion(DevolucionPK devolucionPK) {
        this.devolucionPK = devolucionPK;
    }

    public Devolucion(int idFactura, int idProducto) {
        this.devolucionPK = new DevolucionPK(idFactura, idProducto);
    }
    

    public DevolucionPK getDevolucionPK() {
        return devolucionPK;
    }

    public void setDevolucionPK(DevolucionPK devolucionPK) {
        this.devolucionPK = devolucionPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (devolucionPK != null ? devolucionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Devolucion)) {
            return false;
        }
        Devolucion other = (Devolucion) object;
        if ((this.devolucionPK == null && other.devolucionPK != null) || (this.devolucionPK != null && !this.devolucionPK.equals(other.devolucionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Devolucion[ devolucionPK=" + devolucionPK + " ]";
    }
    
}
