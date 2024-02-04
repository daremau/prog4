package com.uca.prog4.entidades;

import com.uca.prog4.entidades.Productos;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-01-31T18:55:39")
@StaticMetamodel(Marcas.class)
public class Marcas_ { 

    public static volatile SingularAttribute<Marcas, Integer> marca;
    public static volatile CollectionAttribute<Marcas, Productos> productosCollection;
    public static volatile SingularAttribute<Marcas, String> nombre;

}