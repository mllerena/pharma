/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.ejb.services.AdPackageService;
import org.pharmaceutical.model.entities.MaWorkrequirement;
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
public class MaWorkrequirementFacade extends AbstractFacade<MaWorkrequirement> {
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

    public MaWorkrequirementFacade() {
        super(MaWorkrequirement.class);
    }
    
    public List<MaWorkrequirement> find(MaWorkrequirement filter) {

		System.out.println("filter: " + filter);

		List<MaWorkrequirement> result = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT e FROM MaWorkrequirement e ");
		sql.append("WHERE ");
		sql.append("e.maWorkrequirementId like :id ");
		sql.append("AND ");
		sql.append("e.name like :name ");
		sql.append("AND ");
		sql.append("e.isactive = :isactive ");
		
		
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
			query.setParameter("name", filter.getName() != null ? "%"+ filter.getName() + "%" : "%%");
			query.setParameter("isactive", filter.getIsactive());
			
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
    
    public MaWorkrequirement findByName(String name) {
        List<MaWorkrequirement> result = null;
        try {
            Query query = em.createNamedQuery("MaWorkrequirement.findByName"); 
            query.setParameter("name", name);  
            query.setParameter("isactive", YesNo.SI); 
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
    
    public MaWorkrequirement findByTaskId(Long taskId) {
        List<MaWorkrequirement> result = null;
        try {
            Query query = em.createNamedQuery("MaWorkrequirement.findByTaskId"); 
            query.setParameter("taskId", taskId);  
            query.setParameter("isactive", YesNo.SI); 
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MaWorkrequirement entity) throws ExecuteRollbackException {
        try {
        	
        	
        	if( entity.getId() == null ){
        		
        		String documentno = packageService.sequence("doc_workrequirement", security.getAdUser().getAdClientId().getAdClientId() );  
        		entity.setDocumentno(documentno);
        		entity.setClosed(YesNo.NO);
        		
        		
        		
        		String lot = "";
        		Date vigencia = new Date();
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        		lot = lot + sdf.format(vigencia);
        		String secuenciaLot = packageService.sequence("lot", security.getAdUser().getAdClientId().getAdClientId() );
        		
        		
        		int cont = 0;
        		String seqZero = "";
        		int tamanio = 4 - secuenciaLot.length();
        		while(cont < tamanio){
        			seqZero = seqZero + "0"; 
        			cont++;
        		}
        		
        		lot = lot + seqZero + secuenciaLot; 
        		
        		entity.setLot(lot); 
        		
        		
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
        	throw new ExecuteRollbackException("La máquina "+ entity.getName() +" ya existe.");
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(MaWorkrequirement entity) throws ExecuteRollbackException {
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
    public void validarExistencia(MaWorkrequirement entity) throws ExistException {
        try {
        	MaWorkrequirement temp = findByName(entity.getName());
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }

    public void validarExistenciaActualizar(MaWorkrequirement entity) throws ExistException {
        try {
        	MaWorkrequirement entityWithNotChange = find(entity.getId());
            if (!entityWithNotChange.getName().trim().equals(entity.getName().trim())) {
                validarExistencia(entity);  
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
}
