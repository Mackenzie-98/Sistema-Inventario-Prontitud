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
public class DetalleCompraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_producto_FK")
    private int idproductoFK;
    @Basic(optional = false)
    @Column(name = "id_factura_FK")
    private int idfacturaFK;

    public DetalleCompraPK() {
    }

    public DetalleCompraPK(int idproductoFK, int idfacturaFK) {
        this.idproductoFK = idproductoFK;
        this.idfacturaFK = idfacturaFK;
    }

    public int getIdproductoFK() {
        return idproductoFK;
    }

    public void setIdproductoFK(int idproductoFK) {
        this.idproductoFK = idproductoFK;
    }

    public int getIdfacturaFK() {
        return idfacturaFK;
    }

    public void setIdfacturaFK(int idfacturaFK) {
        this.idfacturaFK = idfacturaFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproductoFK;
        hash += (int) idfacturaFK;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompraPK)) {
            return false;
        }
        DetalleCompraPK other = (DetalleCompraPK) object;
        if (this.idproductoFK != other.idproductoFK) {
            return false;
        }
        if (this.idfacturaFK != other.idfacturaFK) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetalleCompraPK[ idproductoFK=" + idproductoFK + ", idfacturaFK=" + idfacturaFK + " ]";
    }
    
}
