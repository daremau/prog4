package com.uca.prog4.entidades;

import com.uca.prog4.entidades.Ajustes;
import com.uca.prog4.entidades.Categorias;
import com.uca.prog4.entidades.Compras;
import com.uca.prog4.entidades.Marcas;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-13T17:16:02")
@StaticMetamodel(Productos.class)
public class Productos_ { 

    public static volatile SingularAttribute<Productos, Date> fechaAdquisicion;
    public static volatile SingularAttribute<Productos, BigDecimal> existencia;
    public static volatile SingularAttribute<Productos, Marcas> marca;
    public static volatile CollectionAttribute<Productos, Compras> comprasCollection;
    public static volatile SingularAttribute<Productos, Categorias> categoria;
    public static volatile SingularAttribute<Productos, Integer> producto;
    public static volatile SingularAttribute<Productos, BigDecimal> precioVenta;
    public static volatile CollectionAttribute<Productos, Ajustes> ajustesCollection;
    public static volatile SingularAttribute<Productos, String> nombre;
    public static volatile SingularAttribute<Productos, BigDecimal> precioCosto;
    public static volatile SingularAttribute<Productos, Character> garantia;

}