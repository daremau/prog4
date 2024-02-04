/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uca.prog4.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author Belén
 */
@Entity
@Table(name = "PROVEEDORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p"),
    @NamedQuery(name = "Proveedores.findByProveedor", query = "SELECT p FROM Proveedores p WHERE p.proveedor = :proveedor"),
    @NamedQuery(name = "Proveedores.findByNombre", query = "SELECT p FROM Proveedores p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proveedores.findByDireccion", query = "SELECT p FROM Proveedores p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Proveedores.findByTelefono", query = "SELECT p FROM Proveedores p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Proveedores.findByEmail", query = "SELECT p FROM Proveedores p WHERE p.email = :email"),
    @NamedQuery(name = "Proveedores.findByFechaInicio", query = "SELECT p FROM Proveedores p WHERE p.fechaInicio = :fechaInicio")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROVEEDOR")
    private Integer proveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TELEFONO")
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @OneToMany(mappedBy = "proveedor")
    private Collection<Compras> comprasCollection;
    @JoinColumn(name = "PAIS", referencedColumnName = "PAIS")
    @ManyToOne(optional = false)
    private Paises pais;

    public Proveedores() {
    }

    public Proveedores(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public Proveedores(Integer proveedor, String nombre, String direccion, String telefono, String email) {
        this.proveedor = proveedor;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @XmlTransient
    public Collection<Compras> getComprasCollection() {
        return comprasCollection;
    }

    public void setComprasCollection(Collection<Compras> comprasCollection) {
        this.comprasCollection = comprasCollection;
    }

    public Paises getPais() {
        return pais;
    }
    
    public String getNombrePais() {
        return pais.getNombre();
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proveedor != null ? proveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.proveedor == null && other.proveedor != null) || (this.proveedor != null && !this.proveedor.equals(other.proveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}
