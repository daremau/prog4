package com.uca.prog4.entidades;

import com.uca.prog4.entidades.Ajustes;
import com.uca.prog4.entidades.Areas;
import com.uca.prog4.entidades.Compras;
import com.uca.prog4.entidades.Paises;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-12T01:30:36")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, Areas> area;
    public static volatile CollectionAttribute<Empleados, Compras> comprasCollection;
    public static volatile SingularAttribute<Empleados, BigDecimal> salario;
    public static volatile SingularAttribute<Empleados, String> direccion;
    public static volatile SingularAttribute<Empleados, String> nombre;
    public static volatile SingularAttribute<Empleados, Paises> pais;
    public static volatile SingularAttribute<Empleados, Date> fechaIngreso;
    public static volatile SingularAttribute<Empleados, Integer> empleado;
    public static volatile SingularAttribute<Empleados, String> apellido;
    public static volatile SingularAttribute<Empleados, Date> fechaSalida;
    public static volatile SingularAttribute<Empleados, String> telefono;
    public static volatile CollectionAttribute<Empleados, Ajustes> ajustesCollection;
    public static volatile SingularAttribute<Empleados, String> email;

}