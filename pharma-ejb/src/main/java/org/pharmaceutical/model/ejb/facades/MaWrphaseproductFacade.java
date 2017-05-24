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

import org.pharmaceutical.model.entities.MaSequence;
import org.pharmaceutical.model.entities.MaWorkrequirement;
import org.pharmaceutical.model.entities.MaWrphase;
import org.pharmaceutical.model.entities.MaWrphaseproduct;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;

/**
 *
 * @author mllerena
 */
@Stateless
public class MaWrphaseproductFacade extends AbstractFacade<MaWrphaseproduct> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaWrphaseproductFacade() {
        super(MaWrphaseproduct.class);
    }
    
    public List<MaWrphaseproduct> findByMaWrphaseId(MaWrphase entity) {  
        List<MaWrphaseproduct> result = null; 
        try {
            Query query = em.createNamedQuery("MaWrphaseproduct.findByMaWrphaseId");
            query.setParameter("maWrphaseId", entity);     
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    public List<MaWrphaseproduct> findByMaWorkrequirementId(MaWorkrequirement entity) {  
        List<MaWrphaseproduct> result = null; 
        try {
            Query query = em.createNamedQuery("MaWrphaseproduct.findByMaWorkrequirementId"); 
            query.setParameter("maWorkrequirementId", entity);     
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MaWrphaseproduct entity) throws ExecuteRollbackException {
        try {
        	
        	if( entity == null){
        		throw new ProcessOperationException("El parámetro MaWrphaseproduct no puede ser null.");
        	}
        	
        	if( entity.getMaWrphaseId() == null){
        		throw new ProcessOperationException("getMaWrphaseId no esta guardado, no existe en la base de datos."); 
        	}
        	
        	
        	if( entity.getId() == null ){
        		
        		//entity.setValue(entity.getName());
        		
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
        	throw new ExecuteRollbackException("La dirección "+ MaWrphaseproduct.getName() +" ya ha sido asignado anteriormente.");*/
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(List<MaWrphaseproduct> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro entityList no puede ser null.");
        	}
        	
        	for (MaWrphaseproduct entity : entityList) {
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
    public void delete(MaWrphaseproduct entity) throws ExecuteRollbackException {
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
    public void delete(List<MaWrphaseproduct> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro MaWrphaseproductList no puede ser null.");
        	}
        	
        	for (MaWrphaseproduct entity : entityList) {
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
