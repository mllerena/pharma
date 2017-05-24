/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.ejb.services.AdPackageService;
import org.pharmaceutical.model.entities.MaCostcenter;
import org.pharmaceutical.model.entities.MaCostcenterVersion;
import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.entities.MaCostcenterVersion;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;
import org.pharmaceutical.model.utils.SecurityUtils;

/**
 *
 * @author mllerena
 */
@Stateless
public class MaCostcenterVersionFacade extends AbstractFacade<MaCostcenterVersion> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;
    
    @Inject
	private AdPackageService packageService;
    
    @Inject
	private SecurityUtils security;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaCostcenterVersionFacade() {
        super(MaCostcenterVersion.class);
    }
    
    public List<MaCostcenterVersion> findByMaCostcenterId(MaCostcenter entity) { 
        List<MaCostcenterVersion> result = null; 
        try {
            Query query = em.createNamedQuery("MaCostcenterVersion.findByMaCostcenterId");
            query.setParameter("maCostcenterId", entity);   
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList();  
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MaCostcenterVersion entity) throws ExecuteRollbackException {
        try {
        	
        	if( entity == null){
        		throw new ProcessOperationException("El parámetro MaCostcenterVersion no puede ser null.");
        	}
        	
        	if( entity.getMaCostcenterId() == null){
        		throw new ProcessOperationException("getMaCostcenterId no esta guardado, no existe en la base de datos."); 
        	}
        	
        	
        	if( entity.getId() == null ){
        		
        		String documentno = packageService.sequence("doc_costcenter_version", security.getAdUser().getAdClientId().getAdClientId() ); 
        		entity.setDocumentno(documentno);
        		
                this.create(entity);  
                
        	}else{
        		//usuarioRolFacade.actualizar(usuarioRol);
        		
        		//validarExistenciaActualizar(adUserRoles);
                this.edit(entity); 
        	}
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        /*}catch (ExistException e) {
        	throw new ExecuteRollbackException("La dirección "+ MaCostcenterVersion.getName() +" ya ha sido asignado anteriormente.");*/
        } catch (Exception e) {
            e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(List<MaCostcenterVersion> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro entityList no puede ser null.");
        	}
        	
        	for (MaCostcenterVersion entity : entityList) {
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
    public void delete(MaCostcenterVersion entity) throws ExecuteRollbackException {
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
    public void delete(List<MaCostcenterVersion> entityList) throws ExecuteRollbackException {
        try {
        	if( entityList == null){
        		throw new ProcessOperationException("El parámetro MaCostcenterVersionList no puede ser null.");
        	}
        	
        	for (MaCostcenterVersion entity : entityList) {
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
