/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.genesis.modelo.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ruben
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdPedido", query = "SELECT p FROM Pedido p WHERE p.idPedido = :idPedido")
    , @NamedQuery(name = "Pedido.findByDescripcion", query = "SELECT p FROM Pedido p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pedido.findByCedulaCliente", query = "SELECT p FROM Pedido p WHERE p.cedulaCliente = :cedulaCliente")
    , @NamedQuery(name = "Pedido.findByFecha", query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Pedido.findByCalificacionServicio", query = "SELECT p FROM Pedido p WHERE p.calificacionServicio = :calificacionServicio")
    , @NamedQuery(name = "Pedido.findByObservacionServicio", query = "SELECT p FROM Pedido p WHERE p.observacionServicio = :observacionServicio")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPedido")
    private Integer idPedido;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cedulaCliente")
    private BigInteger cedulaCliente;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 25)
    @Column(name = "calificacionServicio")
    private String calificacionServicio;
    @Size(max = 80)
    @Column(name = "observacionServicio")
    private String observacionServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<Factura> facturaList;
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoPedido idEstado;
    @JoinColumn(name = "idMesa", referencedColumnName = "idMesa")
    @ManyToOne(fetch = FetchType.LAZY)
    private Mesa idMesa;
    @JoinColumn(name = "cedulaCapitan", referencedColumnName = "cedula")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario cedulaCapitan;

    public Pedido() {
    }

    public Pedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(BigInteger cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCalificacionServicio() {
        return calificacionServicio;
    }

    public void setCalificacionServicio(String calificacionServicio) {
        this.calificacionServicio = calificacionServicio;
    }

    public String getObservacionServicio() {
        return observacionServicio;
    }

    public void setObservacionServicio(String observacionServicio) {
        this.observacionServicio = observacionServicio;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    public EstadoPedido getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoPedido idEstado) {
        this.idEstado = idEstado;
    }

    public Mesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Mesa idMesa) {
        this.idMesa = idMesa;
    }

    public Usuario getCedulaCapitan() {
        return cedulaCapitan;
    }

    public void setCedulaCapitan(Usuario cedulaCapitan) {
        this.cedulaCapitan = cedulaCapitan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPedido != null ? idPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Codigo pedido" + idPedido + ", Cedula cliente " +cedulaCliente;
    }
    
}
