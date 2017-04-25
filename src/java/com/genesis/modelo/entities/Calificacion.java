/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "calificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdcalificacion", query = "SELECT c FROM Calificacion c WHERE c.idcalificacion = :idcalificacion")
    , @NamedQuery(name = "Calificacion.findByDescripcion", query = "SELECT c FROM Calificacion c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Calificacion.findByFecha", query = "SELECT c FROM Calificacion c WHERE c.fecha = :fecha")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "idcalificacion")
    private Integer idcalificacion;
    @NotNull(message = "Este campo es obligatorio")
    @Size(min = 1, max = 45, message = "Este campo debe estar entre 1 y 45 carácteres")
    
    @Column(name = "descripcion")
    private String descripcion;
    @NotNull(message = "Este campo es obligatorio")
    @Size(min = 1, max = 45, message = "Este campo debe estar entre 1 y 45 carácteres")
    
    @Column(name = "fecha")
    private String fecha;
    @NotNull(message = "Este campo es obligatorio")
    @JoinColumn(name = "cedulaMesero", referencedColumnName = "cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario cedulaMesero;

    public Calificacion() {
    }

    public Calificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public Integer getIdcalificacion() {
        return idcalificacion;
    }

    public void setIdcalificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Usuario getCedulaMesero() {
        return cedulaMesero;
    }

    public void setCedulaMesero(Usuario cedulaMesero) {
        this.cedulaMesero = cedulaMesero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalificacion != null ? idcalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idcalificacion == null && other.idcalificacion != null) || (this.idcalificacion != null && !this.idcalificacion.equals(other.idcalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.genesis.modelo.entities.Calificacion[ idcalificacion=" + idcalificacion + " ]";
    }
    
}
