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
import org.pharmaceutical.model.entities.MProductionline;
import org.pharmaceutical.model.entities.MProductionplan;
import org.pharmaceutical.model.entities.MaWorkrequirement;
import org.pharmaceutical.model.entities.MaWrphase;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;

/**
 *
 * @author mllerena
 */
@Stateless
public class MProductionlineFacade extends AbstractFacade<MProductionline> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MProductionlineFacade() {
        super(MProductionline.class);
    }
    
    public List<MProductionline> findByMProductionplanId(MProductionplan entity) {  
        List<MProductionline> result = null; 
        try {
            Query query = em.createNamedQuery("MProductionline.findByMProductionplanId");
            query.setParameter("mProductionplanId", entity);      
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MProductionline entity) throws ExecuteRollbackException {
        try {
        	
        	if( entity == null){
        		throw new ProcessOperationException("El parámetro MProductionline no puede ser null.");
        	}
        	
        	if( entity.getMProductionplanId() == null){
        		throw new ProcessOperationException("getMProductionplanId no esta guardado, no existe en la base de datos."); 
        	}
        	
        	
        	if( entity.getId() == null ){
        		
        		//entity.setValue(entity.getName());
        		
        		
        		if( entity.getLine() == 0 ){
        			List<MProductionline> listSequence = findByMProductionplanId(entity.getMProductionplanId()); 
            		long secuencia = listSequence.size() + 1;
            		entity.setLine(secuencia);  	
        		}
        		
        		
        		entity.setCUomId(entity.getMProductId().getCUomId()); 
        		//entity.setMProductUomId(entity.getMProductId().getCUomId());  
        		
                this.create(entity);  
                
        	}else{
        		//usuarioRolFacade.actualizar(usuarioRol);
        		
        		//validarExistenciaActualizar(adUserRoles);
                this.edit(entity); 
        	}
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        /*}catch (ExistException e) {
        	throw new ExecuteRollbackException("La dirección "+ MProductionline.getName() +" ya ha sido asignado anteriormente.");*/
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(List<MProductionline> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro entityList no puede ser null.");
        	}
        	
        	for (MProductionline entity : entityList) {
				this.save(entity); 
			}
        	
        }catch (ExecuteRollbackException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar los registros!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(MProductionline entity) throws ExecuteRollbackException {
        try {
        	if( entity == null ){
        		throw new ProcessOperationException("El parámetro entity no puede ser null.");
        	}
        	
        	entity.setIsactive(YesNo.NO);
        	
        	//validarExistenciaActualizar(adUserRoles);
            this.edit(entity);  
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        }catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al borrar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED) 
    public void delete(List<MProductionline> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro MProductionlineList no puede ser null.");
        	}
        	
        	for (MProductionline entity : entityList) {
				this.delete(entity);  
			}
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar los registros!");
        }
    }
    
}
