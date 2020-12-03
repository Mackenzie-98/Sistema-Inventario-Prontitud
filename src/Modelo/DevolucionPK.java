/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author garun
 */
@Embeddable
public class DevolucionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_factura")
    private int idFactura;
    @Basic(optional = false)
    @Column(name = "id_producto")
    private int idProducto;

    public DevolucionPK() {
    }

    public DevolucionPK(int idFactura, int idProducto) {
        this.idFactura = idFactura;
        this.idProducto = idProducto;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFactura;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DevolucionPK)) {
            return false;
        }
        DevolucionPK other = (DevolucionPK) object;
        if (this.idFactura != other.idFactura) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DevolucionPK[ idFactura=" + idFactura + ", idProducto=" + idProducto + " ]";
    }
    
}
