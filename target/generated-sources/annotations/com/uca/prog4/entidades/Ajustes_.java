package com.uca.prog4.entidades;

import com.uca.prog4.entidades.Empleados;
import com.uca.prog4.entidades.Productos;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-31T18:55:39")
@StaticMetamodel(Ajustes.class)
public class Ajustes_ { 

    public static volatile SingularAttribute<Ajustes, Date> fecha;
    public static volatile SingularAttribute<Ajustes, Empleados> empleado;
    public static volatile SingularAttribute<Ajustes, Integer> ajuste;
    public static volatile SingularAttribute<Ajustes, Character> tipoAjuste;
    public static volatile SingularAttribute<Ajustes, BigDecimal> cantidad;
    public static volatile SingularAttribute<Ajustes, Productos> producto;
    public static volatile SingularAttribute<Ajustes, BigDecimal> precioCosto;

}