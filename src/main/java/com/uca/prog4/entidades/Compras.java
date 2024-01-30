/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uca.prog4.entidades;

import com.uca.prog4.controladores.util.JsfUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Locale;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Belén
 */
@Entity
@Table(name = "COMPRAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compras.findAll", query = "SELECT c FROM Compras c"),
    @NamedQuery(name = "Compras.findByCompra", query = "SELECT c FROM Compras c WHERE c.compra = :compra"),
    @NamedQuery(name = "Compras.findByFecha", query = "SELECT c FROM Compras c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "Compras.findByCantidad", query = "SELECT c FROM Compras c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Compras.findByPrecioCosto", query = "SELECT c FROM Compras c WHERE c.precioCosto = :precioCosto")})
public class Compras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPRA")
    private Integer compra;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Column(name = "PRECIO_COSTO")
    private BigDecimal precioCosto;
    @JoinColumn(name = "EMPLEADO", referencedColumnName = "EMPLEADO")
    @ManyToOne
    private Empleados empleado;
    @JoinColumn(name = "PRODUCTO", referencedColumnName = "PRODUCTO")
    @ManyToOne
    private Productos producto;
    @JoinColumn(name = "PROVEEDOR", referencedColumnName = "PROVEEDOR")
    @ManyToOne
    private Proveedores proveedor;

    public Compras() {
    }

    public Compras(Integer compra) {
        this.compra = compra;
    }

    public Integer getCompra() {
        return compra;
    }

    public void setCompra(Integer compra) {
        this.compra = compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }
    
    public String getCantidadFormateado() {
        return JsfUtil.formatearGuaranies(this.cantidad, Locale.GERMANY);
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioCosto() {
        return precioCosto;
    }
    
    public String getPrecioCostoFormateado() {
        return JsfUtil.formatearGuaranies(this.precioCosto, Locale.GERMANY);
    }

    public void setPrecioCosto(BigDecimal precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Empleados getEmpleado() {
        return empleado;
    }
    
    public String getNombreEmpleado() {
        return empleado.getNombre() + ", " + empleado.getApellido();
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Productos getProducto() {
        return producto;
    }
    
    public String getNombreProducto() {
        return producto.getNombre();
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }
    
    public String getNombreProveedor() {
        return proveedor.getNombre();
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compra != null ? compra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compras)) {
            return false;
        }
        Compras other = (Compras) object;
        if ((this.compra == null && other.compra != null) || (this.compra != null && !this.compra.equals(other.compra))) {
            return false;
        }
        return true;
    }   

    @Override
    public String toString() {
        return "com.uca.prog4.entidades.Compras[ compra=" + compra + " ]";
    }
    
}
