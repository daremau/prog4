/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uca.prog4.clases;

import com.uca.prog4.entidades.Ajustes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Belén
 */
@Stateless
public class AjustesFacade extends AbstractFacade<Ajustes> {

    @PersistenceContext(unitName = "com.uca_prog4_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AjustesFacade() {
        super(Ajustes.class);
    }
    
}
