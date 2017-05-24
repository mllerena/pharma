/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MProduct;
import org.pharmaceutical.model.entities.MaSequence;
import org.pharmaceutical.model.entities.MaSequenceproduct;
import org.pharmaceutical.model.enums.YesNo;

/**
 *
 * @author mllerena
 */
@Stateless
public class MProductFacade extends AbstractFacade<MProduct> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MProductFacade() {
        super(MProduct.class);
    }
    
    
    public List<MProduct> findByMLocatorId(List<MLocator> listEntity) { 
        List<MProduct> result = null;  
        try {
            Query query = em.createNamedQuery("MProduct.findByMLocatorId");
            query.setParameter("mLocatorId", listEntity);    
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    
    
}
