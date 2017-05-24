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

import org.pharmaceutical.model.entities.MaToolsetType;
import org.pharmaceutical.model.entities.MaToolsetType;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;
import org.pharmaceutical.model.utils.DateUtils;

/**
 *
 * @author mllerena
 */
@Stateless
public class MaToolsetTypeFacade extends AbstractFacade<MaToolsetType> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaToolsetTypeFacade() {
        super(MaToolsetType.class);
    }
    
    public List<MaToolsetType> find(MaToolsetType filter) {

		System.out.println("filter: " + filter);

		List<MaToolsetType> result = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT e FROM MaToolsetType e ");
		sql.append("WHERE ");
		sql.append("e.maToolsetTypeId like :id ");
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
    
    public MaToolsetType findByName(String name) {
        List<MaToolsetType> result = null;
        try {
            Query query = em.createNamedQuery("MaToolsetType.findByName"); 
            query.setParameter("name", name);  
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MaToolsetType entity) throws ExecuteRollbackException {
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
        	throw new ExecuteRollbackException("La herramienta "+ entity.getName() +" ya existe.");
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(MaToolsetType entity) throws ExecuteRollbackException {
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
    public void validarExistencia(MaToolsetType entity) throws ExistException {
        try {
        	MaToolsetType temp = findByName(entity.getName());
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }

    public void validarExistenciaActualizar(MaToolsetType entity) throws ExistException {
        try {
        	MaToolsetType entityWithNotChange = find(entity.getId());
            if (!entityWithNotChange.getName().trim().equals(entity.getName().trim())) {
                validarExistencia(entity);  
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
}
