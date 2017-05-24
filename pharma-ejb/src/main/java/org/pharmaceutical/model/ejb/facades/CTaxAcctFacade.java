/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pharmaceutical.model.entities.CTaxAcct;

/**
 *
 * @author mllerena
 */
@Stateless
public class CTaxAcctFacade extends AbstractFacade<CTaxAcct> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CTaxAcctFacade() {
        super(CTaxAcct.class);
    }
    
}
