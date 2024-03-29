/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uca.prog4.entidades;

import com.uca.prog4.controladores.util.JsfUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collection;
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
@Table(name = "PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByProducto", query = "SELECT p FROM Productos p WHERE p.producto = :producto"),
    @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Productos.findByPrecioCosto", query = "SELECT p FROM Productos p WHERE p.precioCosto = :precioCosto"),
    @NamedQuery(name = "Productos.findByPrecioVenta", query = "SELECT p FROM Productos p WHERE p.precioVenta = :precioVenta"),
    @NamedQuery(name = "Productos.findByFechaAdquisicion", query = "SELECT p FROM Productos p WHERE p.fechaAdquisicion = :fechaAdquisicion"),
    @NamedQuery(name = "Productos.findByGarantia", query = "SELECT p FROM Productos p WHERE p.garantia = :garantia"),
    @NamedQuery(name = "Productos.findByExistencia", query = "SELECT p FROM Productos p WHERE p.existencia = :existencia")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTO")
    private Integer producto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO_COSTO")
    private BigDecimal precioCosto;
    @Column(name = "PRECIO_VENTA")
    private BigDecimal precioVenta;
    @Column(name = "FECHA_ADQUISICION")
    @Temporal(TemporalType.DATE)
    private Date fechaAdquisicion;
    @Column(name = "GARANTIA")
    private Character garantia;
    @Column(name = "EXISTENCIA")
    private BigDecimal existencia;
    @JoinColumn(name = "CATEGORIA", referencedColumnName = "CATEGORIA")
    @ManyToOne
    private Categorias categoria;
    @JoinColumn(name = "MARCA", referencedColumnName = "MARCA")
    @ManyToOne
    private Marcas marca;
    @OneToMany(mappedBy = "producto")
    private Collection<Compras> comprasCollection;
    @OneToMany(mappedBy = "producto")
    private Collection<Ajustes> ajustesCollection;
    @OneToMany(mappedBy = "producto")
    private Collection<Entregas> entregasCollection;

    public Productos() {
    }

    public Productos(Integer producto) {
        this.producto = producto;
    }

    public Productos(Integer producto, String nombre) {
        this.producto = producto;
        this.nombre = nombre;
    }

    public Integer getProducto() {
        return producto;
    }

    public void setProducto(Integer producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioCosto() {
        return precioCosto;
    }
    
    public String getPrecioCostoFormateado() {
        if (precioCosto != null) {
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
            simbolos.setDecimalSeparator(',');
            simbolos.setGroupingSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#,##0.00", simbolos);
            return formateador.format(precioCosto);
        } else {
            return "";
        }
    }

    public void setPrecioCosto(BigDecimal precioCosto) {
        this.precioCosto = precioCosto;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }
    
    public String getPrecioVentaFormateado() {
        if (precioVenta != null) {
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
            simbolos.setDecimalSeparator(',');
            simbolos.setGroupingSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#,##0.00", simbolos);
            return formateador.format(precioVenta);
        } else {
            return "";
        }
    }
    

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public Character getGarantia() {
        return garantia;
    }
    
    public String getGarantiaFormateado() {
        switch (Character.toUpperCase(garantia)) {
            case 'S':
                return "Si";
            case 'N':
                return "No";
            default:
                return "";
        }
    }

    public void setGarantia(Character garantia) {
        this.garantia = garantia;
    }

    public BigDecimal getExistencia() {
        return existencia;
    }
    
    public String getExistenciaFormateado() {
        if (existencia != null) {
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
            simbolos.setDecimalSeparator(',');
            simbolos.setGroupingSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#,##0.00", simbolos);
            return formateador.format(existencia);
        } else {
            return "";
        }
    }

    public void setExistencia(BigDecimal existencia) {
        this.existencia = existencia;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public String getNombreCategoria() {
        return categoria.getNombre();
    }
    
    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public Marcas getMarca() {
        return marca;
    }
    
    public String getNombreMarca() {
        return marca.getNombre();
    }

    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    @XmlTransient
    public Collection<Compras> getComprasCollection() {
        return comprasCollection;
    }

    public void setComprasCollection(Collection<Compras> comprasCollection) {
        this.comprasCollection = comprasCollection;
    }

    @XmlTransient
    public Collection<Ajustes> getAjustesCollection() {
        return ajustesCollection;
    }

    public void setAjustesCollection(Collection<Ajustes> ajustesCollection) {
        this.ajustesCollection = ajustesCollection;
    }
    
    @XmlTransient
    public Collection<Entregas> getEntregasCollection() {
        return entregasCollection;
    }

    public void setEntregasCollection(Collection<Entregas> entregasCollection) {
        this.entregasCollection = entregasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (producto != null ? producto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.producto == null && other.producto != null) || (this.producto != null && !this.producto.equals(other.producto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
     
}
