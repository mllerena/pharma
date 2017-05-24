/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import java.util.List;
import java.util.logging.Level;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.entities.AdRole;
import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Stateless
public class AdRoleFacade extends AbstractFacade<AdRole> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdRoleFacade() {
        super(AdRole.class);
    }
    
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED) 
	public AdRole findByName(String name) {
        List<AdRole> result = null;
        try {
            Query query = em.createNamedQuery("AdRole.findByName");
            query.setParameter("name", name);
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
    
    
}
