package com.uca.prog4.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-05T12:08:23")
@StaticMetamodel(Entregas.class)
public class Entregas_ { 

    public static volatile SingularAttribute<Entregas, Integer> area;
    public static volatile SingularAttribute<Entregas, Date> fecha;
    public static volatile SingularAttribute<Entregas, Integer> entrega;
    public static volatile SingularAttribute<Entregas, BigDecimal> cantidad;
    public static volatile SingularAttribute<Entregas, String> nombre;
    public static volatile SingularAttribute<Entregas, BigDecimal> precioCosto;

}