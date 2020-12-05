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
public class DetalleLotePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_producto_FK")
    private int idproductoFK;
    @Basic(optional = false)
    @Column(name = "id_lote_FK")
    private int idloteFK;

    public DetalleLotePK() {
    }

    public DetalleLotePK(int idproductoFK, int idloteFK) {
        this.idproductoFK = idproductoFK;
        this.idloteFK = idloteFK;
    }

    public int getIdproductoFK() {
        return idproductoFK;
    }

    public void setIdproductoFK(int idproductoFK) {
        this.idproductoFK = idproductoFK;
    }

    public int getIdloteFK() {
        return idloteFK;
    }

    public void setIdloteFK(int idloteFK) {
        this.idloteFK = idloteFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproductoFK;
        hash += (int) idloteFK;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleLotePK)) {
            return false;
        }
        DetalleLotePK other = (DetalleLotePK) object;
        if (this.idproductoFK != other.idproductoFK) {
            return false;
        }
        if (this.idloteFK != other.idloteFK) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.DetalleLotePK[ idproductoFK=" + idproductoFK + ", idloteFK=" + idloteFK + " ]";
    }
    
}
