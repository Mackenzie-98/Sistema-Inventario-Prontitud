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
@Table(name = "Detalle_Lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleLote.findAll", query = "SELECT d FROM DetalleLote d")
    , @NamedQuery(name = "DetalleLote.findByIdproductoFK", query = "SELECT d FROM DetalleLote d WHERE d.detalleLotePK.idproductoFK = :idproductoFK")
    , @NamedQuery(name = "DetalleLote.findByIdloteFK", query = "SELECT d FROM DetalleLote d WHERE d.detalleLotePK.idloteFK = :idloteFK")
    , @NamedQuery(name = "DetalleLote.findByCantidad", query = "SELECT d FROM DetalleLote d WHERE d.cantidad = :cantidad")})
public class DetalleLote implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleLotePK detalleLotePK;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "id_lote_FK", referencedColumnName = "id_lote", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Lote lote;
    @JoinColumn(name = "id_producto_FK", referencedColumnName = "id_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public DetalleLote() {
    }

    public DetalleLote(DetalleLotePK detalleLotePK) {
        this.detalleLotePK = detalleLotePK;
    }

    public DetalleLote(DetalleLotePK detalleLotePK, String cantidad) {
        this.detalleLotePK = detalleLotePK;
        this.cantidad = cantidad;
    }

    public DetalleLote(int idproductoFK, int idloteFK) {
        this.detalleLotePK = new DetalleLotePK(idproductoFK, idloteFK);
    }

    public DetalleLotePK getDetalleLotePK() {
        return detalleLotePK;
    }

    public void setDetalleLotePK(DetalleLotePK detalleLotePK) {
        this.detalleLotePK = detalleLotePK;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
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
        hash += (detalleLotePK != null ? detalleLotePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleLote)) {
            return false;
        }
        DetalleLote other = (DetalleLote) object;
        if ((this.detalleLotePK == null && other.detalleLotePK != null) || (this.detalleLotePK != null && !this.detalleLotePK.equals(other.detalleLotePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetalleLote[ detalleLotePK=" + detalleLotePK + " ]";
    }
    
}
