package com.uca.prog4.entidades;

import com.uca.prog4.entidades.Empleados;
import com.uca.prog4.entidades.Productos;
import com.uca.prog4.entidades.Proveedores;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-12T01:30:36")
=======
<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-09T19:23:24")
=======
@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-10T17:32:34")
>>>>>>> rama-mathias
>>>>>>> rama-belen
@StaticMetamodel(Compras.class)
public class Compras_ { 

    public static volatile SingularAttribute<Compras, Integer> compra;
    public static volatile SingularAttribute<Compras, Date> fecha;
    public static volatile SingularAttribute<Compras, Empleados> empleado;
    public static volatile SingularAttribute<Compras, Proveedores> proveedor;
    public static volatile SingularAttribute<Compras, BigDecimal> cantidad;
    public static volatile SingularAttribute<Compras, Productos> producto;
    public static volatile SingularAttribute<Compras, BigDecimal> precioCosto;

}