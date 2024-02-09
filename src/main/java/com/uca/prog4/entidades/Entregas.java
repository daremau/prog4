/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uca.prog4.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Belén
 */
@Entity
@Table(name = "ENTREGAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entregas.findAll", query = "SELECT e FROM Entregas e"),
    @NamedQuery(name = "Entregas.findByEntrega", query = "SELECT e FROM Entregas e WHERE e.entrega = :entrega"),
    @NamedQuery(name = "Entregas.findByFecha", query = "SELECT e FROM Entregas e WHERE e.fecha = :fecha"),
    @NamedQuery(name = "Entregas.findByArea", query = "SELECT e FROM Entregas e WHERE e.area = :area"),
    @NamedQuery(name = "Entregas.findByNombre", query = "SELECT e FROM Entregas e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Entregas.findByCantidad", query = "SELECT e FROM Entregas e WHERE e.cantidad = :cantidad"),
    @NamedQuery(name = "Entregas.findByPrecioCosto", query = "SELECT e FROM Entregas e WHERE e.precioCosto = :precioCosto")})
public class Entregas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENTREGA")
    private Integer entrega;
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "AREA", referencedColumnName = "AREA")
    @ManyToOne
    private Areas area;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Column(name = "PRECIO_COSTO")
    private BigDecimal precioCosto;
    @JoinColumn(name = "PRODUCTO", referencedColumnName = "PRODUCTO")
    @ManyToOne
    private Productos producto;

    public Entregas() {
    }

    public Entregas(Integer entrega) {
        this.entrega = entrega;
    }

    public Entregas(Integer entrega, String nombre) {
        this.entrega = entrega;
        this.nombre = nombre;
    }

    public Integer getEntrega() {
        return entrega;
    }

    public void setEntrega(Integer entrega) {
        this.entrega = entrega;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Areas getArea() {
        return area;
    }
    
    public String getNombreArea() {
        return area.getNombre();
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }
    
    public String getCantidadFormateado() {
        if (cantidad != null) {
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols(Locale.getDefault());
            simbolos.setDecimalSeparator(',');
            simbolos.setGroupingSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#,##0.00", simbolos);
            return formateador.format(cantidad);
        } else {
            return "";
        }
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
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
    
    public Productos getProducto() {
        return producto;
    }
    
    public String getNombreProducto() {
        return producto.getNombre();
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entrega != null ? entrega.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregas)) {
            return false;
        }
        Entregas other = (Entregas) object;
        if ((this.entrega == null && other.entrega != null) || (this.entrega != null && !this.entrega.equals(other.entrega))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.prog4.entidades.Entregas[ entrega=" + entrega + " ]";
    }
    
}
