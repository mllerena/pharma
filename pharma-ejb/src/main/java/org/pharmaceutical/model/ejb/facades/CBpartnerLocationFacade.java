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
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.AdUserRoles;
import org.pharmaceutical.model.entities.CBpartner;
import org.pharmaceutical.model.entities.CBpartnerLocation;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;

/**
 *
 * @author mllerena
 */
@Stateless
public class CBpartnerLocationFacade extends AbstractFacade<CBpartnerLocation> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;
    
    @Inject
    private CLocationFacade cLocationFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CBpartnerLocationFacade() {
        super(CBpartnerLocation.class);
    }
    
    public List<CBpartnerLocation> findByCBpartnerId(CBpartner cBpartner) { 
        List<CBpartnerLocation> result = null;
        try {
            Query query = em.createNamedQuery("CBpartnerLocation.findByCBpartnerId");
            query.setParameter("cBpartnerId", cBpartner); 
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList();
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(CBpartnerLocation cBpartnerLocation, CBpartner cBpartner) throws ExecuteRollbackException {
        try {
        	
        	if( cBpartnerLocation == null){
        		throw new ProcessOperationException("El parámetro cBpartnerLocation no puede ser null.");
        	}
        	
        	if( cBpartner == null){
        		throw new ProcessOperationException("El parámetro cBpartner no puede ser null.");
        	}
        	
        	if( cBpartner.getId() == null){
        		throw new ProcessOperationException("El tercero no esta guardado, no existe en la base de datos.");
        	}
        	
        	
        	if( cBpartnerLocation.getId() == null ){
        		//usuarioRolFacade.almacenar(usuarioRol);
        		
        		cLocationFacade.create(cBpartnerLocation.getCLocationId());
        		
        		cBpartnerLocation.setCBpartnerId(cBpartner);
                this.create(cBpartnerLocation);
                
        	}else{
        		//usuarioRolFacade.actualizar(usuarioRol);
        		
        		//validarExistenciaActualizar(adUserRoles);
                this.edit(cBpartnerLocation);
        	}
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        /*}catch (ExistException e) {
        	throw new ExecuteRollbackException("La dirección "+ cBpartnerLocation.getName() +" ya ha sido asignado anteriormente.");*/
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(List<CBpartnerLocation> cBpartnerLocationList, CBpartner cBpartner) throws ExecuteRollbackException {
        try {
        	if( cBpartnerLocationList == null){
        		throw new ProcessOperationException("El parámetro cBpartnerLocationList no puede ser null.");
        	}
        	
        	if( cBpartner == null){
        		throw new ProcessOperationException("El parámetro cBpartner no puede ser null.");
        	}
        	
        	if( cBpartner.getId() == null){
        		throw new ProcessOperationException("El tercero no esta guardado, no existe en la base de datos.");
        	}
        	
        	for (CBpartnerLocation cBpartnerLocation : cBpartnerLocationList) {
				this.save(cBpartnerLocation, cBpartner);
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
    public void delete(CBpartnerLocation cBpartnerLocation) throws ExecuteRollbackException {
        try {
        	if( cBpartnerLocation == null ){
        		throw new ProcessOperationException("El parámetro cBpartnerLocation no puede ser null.");
        	}
        	
        	cBpartnerLocation.setIsactive(YesNo.NO);
        	
        	//validarExistenciaActualizar(adUserRoles);
            this.edit(cBpartnerLocation); 
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        }catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al borrar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(List<CBpartnerLocation> cBpartnerLocationList) throws ExecuteRollbackException {
        try {
        	if( cBpartnerLocationList == null){
        		throw new ProcessOperationException("El parámetro cBpartnerLocationList no puede ser null.");
        	}
        	
        	for (CBpartnerLocation cBpartnerLocation : cBpartnerLocationList) {
				this.delete(cBpartnerLocation); 
			}
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar los registros!");
        }
    }
    
    
}
