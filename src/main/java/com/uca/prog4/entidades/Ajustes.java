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
@Table(name = "AJUSTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ajustes.findAll", query = "SELECT a FROM Ajustes a"),
    @NamedQuery(name = "Ajustes.findByAjuste", query = "SELECT a FROM Ajustes a WHERE a.ajuste = :ajuste"),
    @NamedQuery(name = "Ajustes.findByFecha", query = "SELECT a FROM Ajustes a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Ajustes.findByTipoAjuste", query = "SELECT a FROM Ajustes a WHERE a.tipoAjuste = :tipoAjuste"),
    @NamedQuery(name = "Ajustes.findByCantidad", query = "SELECT a FROM Ajustes a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "Ajustes.findByPrecioCosto", query = "SELECT a FROM Ajustes a WHERE a.precioCosto = :precioCosto")})
public class Ajustes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AJUSTE")
    private Integer ajuste;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "TIPO_AJUSTE")
    private Character tipoAjuste;
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

    public Ajustes() {
    }

    public Ajustes(Integer ajuste) {
        this.ajuste = ajuste;
    }

    public Integer getAjuste() {
        return ajuste;
    }

    public void setAjuste(Integer ajuste) {
        this.ajuste = ajuste;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getTipoAjuste() {
        return tipoAjuste;
    }
    
    public String getTipoAjusteFormateado() {
        switch (Character.toUpperCase(tipoAjuste)) {
            case 'S':
                return "Suma";
            case 'R': 
                return "Resta";
            default:
                return "";
        }
    }

    public void setTipoAjuste(Character tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ajuste != null ? ajuste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ajustes)) {
            return false;
        }
        Ajustes other = (Ajustes) object;
        if ((this.ajuste == null && other.ajuste != null) || (this.ajuste != null && !this.ajuste.equals(other.ajuste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uca.prog4.entidades.Ajustes[ ajuste=" + ajuste + " ]";
    }
    
}
