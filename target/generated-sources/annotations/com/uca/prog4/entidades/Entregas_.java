package com.uca.prog4.entidades;

import com.uca.prog4.entidades.Areas;
import com.uca.prog4.entidades.Productos;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-12T01:30:36")
@StaticMetamodel(Entregas.class)
public class Entregas_ { 

    public static volatile SingularAttribute<Entregas, Areas> area;
    public static volatile SingularAttribute<Entregas, Date> fecha;
    public static volatile SingularAttribute<Entregas, Integer> entrega;
    public static volatile SingularAttribute<Entregas, BigDecimal> cantidad;
    public static volatile SingularAttribute<Entregas, Productos> producto;
    public static volatile SingularAttribute<Entregas, String> nombre;
    public static volatile SingularAttribute<Entregas, BigDecimal> precioCosto;

}