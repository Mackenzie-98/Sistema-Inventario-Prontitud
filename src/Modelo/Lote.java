/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author garun
 */
@Entity
@Table(name = "Lote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lote.findAll", query = "SELECT l FROM Lote l")
    , @NamedQuery(name = "Lote.findByIdLote", query = "SELECT l FROM Lote l WHERE l.idLote = :idLote")
    , @NamedQuery(name = "Lote.findByFechaVencimiento", query = "SELECT l FROM Lote l WHERE l.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Lote.findByLaboratorio", query = "SELECT l FROM Lote l WHERE l.laboratorio = :laboratorio")})
public class Lote implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lote")
    private Integer idLote;
    @Basic(optional = false)
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @Column(name = "laboratorio")
    private String laboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lote")
    private List<DetalleLote> detalleLoteList;

    public Lote() {
    }

    public Lote(Integer idLote) {
        this.idLote = idLote;
    }

    public Lote(Integer idLote, Date fechaVencimiento, String laboratorio) {
        this.idLote = idLote;
        this.fechaVencimiento = fechaVencimiento;
        this.laboratorio = laboratorio;
    }

    public Integer getIdLote() {
        return idLote;
    }
    
    public String getStringFecha(){
        return fechaVencimiento.getDate()+"-"+(fechaVencimiento.getMonth()+1)+"-"+(fechaVencimiento.getYear()+1900);
    }
    
    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    @XmlTransient
    public List<DetalleLote> getDetalleLoteList() {
        return detalleLoteList;
    }

    public void setDetalleLoteList(List<DetalleLote> detalleLoteList) {
        this.detalleLoteList = detalleLoteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLote != null ? idLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lote)) {
            return false;
        }
        Lote other = (Lote) object;
        if ((this.idLote == null && other.idLote != null) || (this.idLote != null && !this.idLote.equals(other.idLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Lote[ idLote=" + idLote + " ]";
    }
    
}
