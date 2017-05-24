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

import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.entities.MaPcTest;
import org.pharmaceutical.model.entities.MaPcTest;
import org.pharmaceutical.model.entities.MaPeriodicControl;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;

/**
 *
 * @author mllerena
 */
@Stateless
public class MaPcTestFacade extends AbstractFacade<MaPcTest> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaPcTestFacade() {
        super(MaPcTest.class);
    }
    
    public List<MaPcTest> findByMaPeriodicControlId(MaPeriodicControl entity) { 
        List<MaPcTest> result = null; 
        try {
            Query query = em.createNamedQuery("MaPcTest.findByMaPeriodicControlId");
            query.setParameter("maPeriodicControlId", entity);   
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList(); 
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MaPcTest entity) throws ExecuteRollbackException {
        try {
        	
        	if( entity == null){
        		throw new ProcessOperationException("El parámetro MaPcTest no puede ser null.");
        	}
        	
        	if( entity.getMaPeriodicControlId() == null){
        		throw new ProcessOperationException("getMaPeriodicControlId no esta guardado, no existe en la base de datos.");  
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
        	throw new ExecuteRollbackException("La dirección "+ MaPcTest.getName() +" ya ha sido asignado anteriormente.");*/
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(List<MaPcTest> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro entityList no puede ser null.");
        	}
        	
        	for (MaPcTest entity : entityList) {
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
    public void delete(MaPcTest entity) throws ExecuteRollbackException {
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
    public void delete(List<MaPcTest> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro MaPcTestList no puede ser null.");
        	}
        	
        	for (MaPcTest entity : entityList) {
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
