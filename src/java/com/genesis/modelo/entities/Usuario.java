/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula")
    , @NamedQuery(name = "Usuario.findByPrimerNombre", query = "SELECT u FROM Usuario u WHERE u.primerNombre = :primerNombre")
    , @NamedQuery(name = "Usuario.findBySegundoNombre", query = "SELECT u FROM Usuario u WHERE u.segundoNombre = :segundoNombre")
    , @NamedQuery(name = "Usuario.findByPrimerApellido", query = "SELECT u FROM Usuario u WHERE u.primerApellido = :primerApellido")
    , @NamedQuery(name = "Usuario.findBySegundoApellido", query = "SELECT u FROM Usuario u WHERE u.segundoApellido = :segundoApellido")
    , @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
    , @NamedQuery(name = "Usuario.findByDireccion", query = "SELECT u FROM Usuario u WHERE u.direccion = :direccion")
    , @NamedQuery(name = "Usuario.findByClave", query = "SELECT u FROM Usuario u WHERE u.clave = :clave")
    , @NamedQuery(name = "Usuario.findByArea", query = "SELECT u FROM Usuario u WHERE u.area = :area")
    , @NamedQuery(name = "Usuario.findLogin", query = "SELECT u FROM Usuario u WHERE u.cedula = :ced AND u.clave = :clv")})
public class Usuario implements Serializable {

    @OneToMany(mappedBy = "cedulaMesero", fetch = FetchType.LAZY)
    private List<Calificacion> calificacionList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private Long cedula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "primerNombre")
    private String primerNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "segundoNombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "primerApellido")
    private String primerApellido;
    @Size(max = 15)
    @Column(name = "segundoApellido")
    private String segundoApellido;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 40)
    @Column(name = "correo")
    private String correo;
    @Size(max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 30)
    @Column(name = "clave")
    private String clave;
    @Size(max = 45)
    @Column(name = "area")
    private String area;
    @OneToMany(mappedBy = "cedulaCapitan", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @JoinColumn(name = "tipoDocumento", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tipodocumento tipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedula", fetch = FetchType.LAZY)
    private List<Rolusuario> rolusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cedulaMesero", fetch = FetchType.LAZY)
    private List<Calificacion> calificacionesList;

    public Usuario() {
    }

    public Usuario(Long cedula) {
        this.cedula = cedula;
    }

    public Usuario(Long cedula, String primerNombre, String segundoNombre, String primerApellido) {
        this.cedula = cedula;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
    }

    public List<Calificacion> getCalificacionesList() {
        return calificacionesList;
    }

    public void setCalificacionesList(List<Calificacion> calificacionesList) {
        this.calificacionesList = calificacionesList;
    }
    
    public Long getCedula() {
        return cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Tipodocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Tipodocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @XmlTransient
    public List<Rolusuario> getRolusuarioList() {
        return rolusuarioList;
    }

    public void setRolusuarioList(List<Rolusuario> rolusuarioList) {
        this.rolusuarioList = rolusuarioList;
    }
    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + cedula + ", " +primerNombre+ " " +primerApellido;
    }

    
}
