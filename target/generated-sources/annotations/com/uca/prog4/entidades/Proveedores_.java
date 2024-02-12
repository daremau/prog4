package com.uca.prog4.entidades;

import com.uca.prog4.entidades.Compras;
import com.uca.prog4.entidades.Paises;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
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
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile CollectionAttribute<Proveedores, Compras> comprasCollection;
    public static volatile SingularAttribute<Proveedores, Date> fechaInicio;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile SingularAttribute<Proveedores, Integer> proveedor;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> nombre;
    public static volatile SingularAttribute<Proveedores, String> email;
    public static volatile SingularAttribute<Proveedores, Paises> pais;

}