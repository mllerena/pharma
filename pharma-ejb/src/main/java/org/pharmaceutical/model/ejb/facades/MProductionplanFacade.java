/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.entities.MProduction;
import org.pharmaceutical.model.entities.MProductionplan;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;

/**
 *
 * @author mllerena
 */
@Stateless
public class MProductionplanFacade extends AbstractFacade<MProductionplan> { 
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MProductionplanFacade() {
        super(MProductionplan.class); 
    }
    
    public MProductionplan findByMProductionId(MProduction entity) { 
        List<MProductionplan> result = null;
        try {
            Query query = em.createNamedQuery("MProductionplan.findByMProductionId"); 
            query.setParameter("mProductionId", entity);  
            query.setParameter("isactive", YesNo.SI); 
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
    
    public MProductionplan findByMaWrphaseId(String name) { 
        List<MProductionplan> result = null;
        try {
            Query query = em.createNamedQuery("MProductionplan.findByMaWrphaseId"); 
            query.setParameter("name", name);  
            query.setParameter("isactive", YesNo.SI); 
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MProductionplan entity) throws ExecuteRollbackException {
        try {
        	
        	
        	if( entity.getId() == null ){
        		
        		
        		validarExistencia(entity);
        		this.create(entity); 
                
        	}else{
        		validarExistenciaActualizar(entity);
                this.edit(entity);
        	}
        	
            
        }/*catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } */
        catch (ExistException e) {
        	throw new ExecuteRollbackException("La fase de parte de trabajo "+ entity.getMaWrphaseId().getName() +" ya existe."); 
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(MProductionplan entity) throws ExecuteRollbackException {
        try {
        	if( entity == null ){
        		throw new ProcessOperationException("El parámetro entity no puede ser null.");
        	}
        	
        	entity.setIsactive(YesNo.NO);
            
            validarExistenciaActualizar(entity);
            
            this.edit(entity);
            
        } catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al borrar el registro!");
        }
    }
    
   
    // =============================================================
    // METODOS VALIDACIONES 
    // =============================================================
    public void validarExistencia(MProductionplan entity) throws ExistException {
        try {
        	MProductionplan temp = findByMaWrphaseId(entity.getMaWrphaseId().getName()); 
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }

    public void validarExistenciaActualizar(MProductionplan entity) throws ExistException {
        try {
        	MProductionplan entityWithNotChange = find(entity.getId()); 
            if (!entityWithNotChange.getMaWrphaseId().getName().trim().equals(entity.getMaWrphaseId().getName().trim())) {
                validarExistencia(entity);  
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
}
