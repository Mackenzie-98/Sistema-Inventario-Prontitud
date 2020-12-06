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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Factura_Compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCompra.findAll", query = "SELECT f FROM FacturaCompra f")
    , @NamedQuery(name = "FacturaCompra.findByIdFactura", query = "SELECT f FROM FacturaCompra f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "FacturaCompra.findByFecha", query = "SELECT f FROM FacturaCompra f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "FacturaCompra.findByImporte", query = "SELECT f FROM FacturaCompra f WHERE f.importe = :importe")})
public class FacturaCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "importe")
    private Long importe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCompra")
    private List<DetalleCompra> detalleCompraList;
    @JoinColumn(name = "NIT_FK", referencedColumnName = "NIT")
    @ManyToOne(optional = false)
    private Proveedor nitFk;

    public FacturaCompra() {
    }

    public FacturaCompra(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public FacturaCompra(Integer idFactura, Date fecha) {
        this.idFactura = idFactura;
        this.fecha = fecha;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getImporte() {
        return importe;
    }

    public void setImporte(Long importe) {
        this.importe = importe;
    }

    @XmlTransient
    public List<DetalleCompra> getDetalleCompraList() {
        return detalleCompraList;
    }

    public void setDetalleCompraList(List<DetalleCompra> detalleCompraList) {
        this.detalleCompraList = detalleCompraList;
    }

    public Proveedor getNitFk() {
        return nitFk;
    }

    public void setNitFk(Proveedor nitFk) {
        this.nitFk = nitFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCompra)) {
            return false;
        }
        FacturaCompra other = (FacturaCompra) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.FacturaCompra[ idFactura=" + idFactura + " ]";
    }
    
}
