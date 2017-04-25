/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "estadosMesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoMesa.findAll", query = "SELECT e FROM EstadoMesa e")
    , @NamedQuery(name = "EstadoMesa.findByIdEstado", query = "SELECT e FROM EstadoMesa e WHERE e.idEstado = :idEstado")
    , @NamedQuery(name = "EstadoMesa.findByNombre", query = "SELECT e FROM EstadoMesa e WHERE e.nombre = :nombre")})
public class EstadoMesa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "idEstado")
    private Integer idEstado;
    @NotNull(message = "Este campo es obligatorio")
    @Size(min = 1, max = 45, message = "Este campo debe estar entre 1 y 45 carácteres")

    @Column(name = "nombre")
    private String nombre;
    @NotNull(message = "Este campo es obligatorio")
    @OneToMany(mappedBy = "idEstados", fetch = FetchType.LAZY)
    private List<Mesa> mesaList;

    public EstadoMesa() {
    }

    public EstadoMesa(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Mesa> getMesaList() {
        return mesaList;
    }

    public void setMesaList(List<Mesa> mesaList) {
        this.mesaList = mesaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoMesa)) {
            return false;
        }
        EstadoMesa other = (EstadoMesa) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + nombre;
    }

}
