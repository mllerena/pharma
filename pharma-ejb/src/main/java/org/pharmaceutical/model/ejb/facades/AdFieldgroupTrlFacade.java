/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.pharmaceutical.model.entities.AdFieldgroupTrl;

/**
 *
 * @author mllerena
 */
@Stateless
public class AdFieldgroupTrlFacade extends AbstractFacade<AdFieldgroupTrl> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdFieldgroupTrlFacade() {
        super(AdFieldgroupTrl.class);
    }
    
}
