/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.ejb.services.AdPackageService;
import org.pharmaceutical.model.entities.MProduction;
import org.pharmaceutical.model.entities.MProduction;
import org.pharmaceutical.model.entities.MaWeemployee;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;
import org.pharmaceutical.model.utils.DateUtils;
import org.pharmaceutical.model.utils.SecurityUtils;

/**
 *
 * @author mllerena
 */
@Stateless
public class MProductionFacade extends AbstractFacade<MProduction> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;
    
    @Inject
	private AdPackageService packageService;
    
    @Inject
	private SecurityUtils security;
    
    
    @Inject
    private MaWeemployeeFacade maWeemployeeFacade; 

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MProductionFacade() {
        super(MProduction.class);
    }
    
    public List<MProduction> find(MProduction filter) {

		System.out.println("filter: " + filter);

		List<MProduction> result = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT e FROM MProduction e ");
		sql.append("WHERE ");
		sql.append("e.mProductionId like :id ");
		//sql.append("AND ");
		//sql.append("e.name like :name "); 
		sql.append("AND ");
		sql.append("e.isactive = :isactive ");
		
		sql.append("AND ");
		sql.append("e.taskId = :taskId ");
		
		
		if (filter.getFromDate() != null){
			sql.append("AND ");
			sql.append("e.created >= :startDate ");
		}
		
		if (filter.getToDate() != null){
			sql.append("AND ");
			sql.append("e.created <= :endDate "); 	
		}
		
		

		System.out.println(getClass().getSimpleName() + ": " + sql);

		try {
 
			Query query = em.createQuery(sql.toString());
			
			//Query query = em. createNativeQuery(sql.toString());

			query.setParameter("id",filter.getId() != null ? "%" + filter.getId() + "%" : "%%");
			//query.setParameter("name", filter.getName() != null ? "%"+ filter.getName() + "%" : "%%");
			query.setParameter("isactive", filter.getIsactive());
			
			query.setParameter("taskId", filter.getTaskId() ); 
			
			
			
			if( filter.getFromDate() != null) 
			query.setParameter("startDate", DateUtils.convertToDateStartDate( filter.getFromDate() ));
			if( filter.getToDate() != null)
			query.setParameter("endDate", DateUtils.convertToDateEndDate( filter.getToDate()));
			
			result = query.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;

	}
    
    public MProduction findByName(String name) {
        List<MProduction> result = null;
        try {
            Query query = em.createNamedQuery("MProduction.findByName"); 
            query.setParameter("name", name);  
            query.setParameter("isactive", YesNo.SI); 
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
    
    public MProduction findByTaskId(Long taskId) {
        List<MProduction> result = null;
        try {
            Query query = em.createNamedQuery("MProduction.findByTaskId"); 
            query.setParameter("taskId", taskId);  
            query.setParameter("isactive", YesNo.SI); 
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MProduction entity) throws ExecuteRollbackException {
        try {
        	
        	
        	if( entity.getId() == null ){
        		
        		String documentno = packageService.sequence("doc_production", security.getAdUser().getAdClientId().getAdClientId() );  
        		entity.setDocumentno(documentno); 
        		
        		entity.setPosted("N");
        		entity.setIssotrx(YesNo.NO);
        		entity.setProcessed(YesNo.NO);
        		entity.setIscreated(YesNo.NO);
        		
        		entity.setMovementdate(entity.getStarttime());
        		
        		this.create(entity);
                
                
                MaWeemployee pl = new MaWeemployee();
    			pl.setMProductionId(entity);
    			pl.setCBpartnerId(security.getAdUser().getCBpartnerId());  
    			maWeemployeeFacade.save(pl); 
                
        	}else{
                this.edit(entity);
        	}
        	
            
        
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(MProduction entity) throws ExecuteRollbackException {
        try {
        	if( entity == null ){
        		throw new ProcessOperationException("El parámetro entity no puede ser null.");
        	}
        	
        	entity.setIsactive(YesNo.NO);
            
            this.edit(entity);
            
        } catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al borrar el registro!");
        }
    }
    
}
