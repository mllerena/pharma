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

import org.pharmaceutical.model.entities.MaCostcenter;
import org.pharmaceutical.model.entities.MaCostcenterEmployee;
import org.pharmaceutical.model.entities.MaCostcenterVersion;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;

/**
 *
 * @author mllerena
 */
@Stateless
public class MaCostcenterEmployeeFacade extends AbstractFacade<MaCostcenterEmployee> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaCostcenterEmployeeFacade() {
        super(MaCostcenterEmployee.class);
    }
    
    public List<MaCostcenterEmployee> findByMaCostcenterVersionId(MaCostcenterVersion entity) { 
        List<MaCostcenterEmployee> result = null; 
        try {
            Query query = em.createNamedQuery("MaCostcenterEmployee.findByMaCostcenterVersionId");
            query.setParameter("maCostcenterVersionId", entity);   
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList();  
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MaCostcenterEmployee entity) throws ExecuteRollbackException {
        try {
        	
        	if( entity == null){
        		throw new ProcessOperationException("El parámetro MaCostcenterEmployee no puede ser null.");
        	}
        	
        	if( entity.getMaCostcenterVersionId() == null){
        		throw new ProcessOperationException("getMaCostcenterVersionId no esta guardado, no existe en la base de datos."); 
        	}
        	
        	
        	if( entity.getId() == null ){
        		
                this.create(entity);  
                
        	}else{
        		//usuarioRolFacade.actualizar(usuarioRol);
        		
        		//validarExistenciaActualizar(adUserRoles);
                this.edit(entity); 
        	}
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        /*}catch (ExistException e) {
        	throw new ExecuteRollbackException("La dirección "+ MaCostcenterEmployee.getName() +" ya ha sido asignado anteriormente.");*/
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(List<MaCostcenterEmployee> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro entityList no puede ser null.");
        	}
        	
        	for (MaCostcenterEmployee entity : entityList) {
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
    public void delete(MaCostcenterEmployee entity) throws ExecuteRollbackException {
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
    public void delete(List<MaCostcenterEmployee> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro MaCostcenterEmployeeList no puede ser null.");
        	}
        	
        	for (MaCostcenterEmployee entity : entityList) {
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
