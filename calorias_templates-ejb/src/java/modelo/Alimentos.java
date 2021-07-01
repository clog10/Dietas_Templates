/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Carlos Loaeza
 */
@Entity
@Table(name = "ALIMENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alimentos.findAll", query = "SELECT a FROM Alimentos a"),
    @NamedQuery(name = "Alimentos.findByIdalimento", query = "SELECT a FROM Alimentos a WHERE a.idalimento = :idalimento"),
    @NamedQuery(name = "Alimentos.findByNombre", query = "SELECT a FROM Alimentos a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Alimentos.findByRacion", query = "SELECT a FROM Alimentos a WHERE a.racion = :racion"),
    @NamedQuery(name = "Alimentos.findByUnidad", query = "SELECT a FROM Alimentos a WHERE a.unidad = :unidad")})
public class Alimentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDALIMENTO")
    private Integer idalimento;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RACION")
    private Double racion;
    @Size(max = 50)
    @Column(name = "UNIDAD")
    private String unidad;
    @JoinColumn(name = "GRUPOALIMENTOS", referencedColumnName = "IDGRUPO")
    @ManyToOne
    private Grupoalimentos grupoalimentos;

    public Alimentos() {
    }

    public Alimentos(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public Integer getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(Integer idalimento) {
        this.idalimento = idalimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getRacion() {
        return racion;
    }

    public void setRacion(Double racion) {
        this.racion = racion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public Grupoalimentos getGrupoalimentos() {
        return grupoalimentos;
    }

    public void setGrupoalimentos(Grupoalimentos grupoalimentos) {
        this.grupoalimentos = grupoalimentos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalimento != null ? idalimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alimentos)) {
            return false;
        }
        Alimentos other = (Alimentos) object;
        if ((this.idalimento == null && other.idalimento != null) || (this.idalimento != null && !this.idalimento.equals(other.idalimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Alimentos[ idalimento=" + idalimento + " ]";
    }
    
}
