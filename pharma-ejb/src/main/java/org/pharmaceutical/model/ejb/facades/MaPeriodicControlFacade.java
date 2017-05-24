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

import org.pharmaceutical.model.entities.MaPeriodicControl;
import org.pharmaceutical.model.entities.MaPeriodicControl;
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
public class MaPeriodicControlFacade extends AbstractFacade<MaPeriodicControl> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MaPeriodicControlFacade() {
        super(MaPeriodicControl.class);
    }
    
    public List<MaPeriodicControl> find(MaPeriodicControl filter) {

		System.out.println("filter: " + filter);

		List<MaPeriodicControl> result = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT e FROM MaPeriodicControl e ");
		sql.append("WHERE ");
		sql.append("e.maPeriodicControlId like :id ");
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
    
    public MaPeriodicControl findByName(String name) {
        List<MaPeriodicControl> result = null;
        try {
            Query query = em.createNamedQuery("MaPeriodicControl.findByName"); 
            query.setParameter("name", name);  
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList(); 
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(MaPeriodicControl entity) throws ExecuteRollbackException {
        try {
        	
        	
        	if( entity.getId() == null ){
        		
        		validarExistencia(entity);
        		
        		
        		//entity.setValue(entity.getName());
        		
                this.create(entity);
        	}else{
        		validarExistenciaActualizar(entity);
                this.edit(entity);
        	}
        	
            
        }/*catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } */
        catch (ExistException e) {
        	throw new ExecuteRollbackException("El control periodico "+ entity.getName() +" ya existe."); 
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(MaPeriodicControl entity) throws ExecuteRollbackException {
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
    public void validarExistencia(MaPeriodicControl entity) throws ExistException {
        try {
        	MaPeriodicControl temp = findByName(entity.getName());
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }

    public void validarExistenciaActualizar(MaPeriodicControl entity) throws ExistException {
        try {
        	MaPeriodicControl entityWithNotChange = find(entity.getId());
            if (!entityWithNotChange.getName().trim().equals(entity.getName().trim())) {
                validarExistencia(entity);  
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
}
