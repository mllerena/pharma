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

import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.CBpartner;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;
import org.pharmaceutical.model.utils.DateUtils;
import org.pharmaceutical.model.utils.StringsUtils;

/**
 *
 * @author mllerena
 */
@Stateless
public class CBpartnerFacade extends AbstractFacade<CBpartner> {
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CBpartnerFacade() {
        super(CBpartner.class);
    }
    
    public List<CBpartner> find(CBpartner filter) {

		System.out.println("filter: " + filter);

		List<CBpartner> result = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT p FROM CBpartner p ");
		sql.append("WHERE ");
		sql.append("p.cBpartnerId like :id ");
		sql.append("AND ");
		sql.append("p.name like :name ");
		sql.append("AND ");
		sql.append("COALESCE(p.description,'') like :description ");
		sql.append("AND ");
		sql.append("p.isactive = :isactive ");
		
		
		if (filter.getFromDate() != null){
			sql.append("AND ");
			sql.append("p.created >= :startDate ");
		}
		
		if (filter.getToDate() != null){
			sql.append("AND ");
			sql.append("p.created <= :endDate ");	
		}
		

		System.out.println(getClass().getSimpleName() + ": " + sql);

		try {

			Query query = em.createQuery(sql.toString());
			
			//Query query = em. createNativeQuery(sql.toString());

			query.setParameter("id",filter.getId() != null ? "%" + filter.getId() + "%" : "%%");
			query.setParameter("name", filter.getName() != null ? "%"+ filter.getName() + "%" : "%%");
			query.setParameter("description", filter.getDescription()!= null ? "%"+ filter.getDescription() + "%" : "%%");
			
			System.out.println("CBpartnerFacade filter.getIsactive(): "+filter.getIsactive());
			
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
	
	public CBpartner findByName(String name) {
        List<CBpartner> result = null;
        try {
            Query query = em.createNamedQuery("CBpartner.findByName");
            query.setParameter("name", name); 
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(CBpartner cBpartner) throws ExecuteRollbackException {
        try {
        	
        	
        	if( cBpartner.getId() == null ){
        		
        		validarExistencia(cBpartner);
        		cBpartner.setValue(cBpartner.getName());
        		
        		cBpartner.setIssummary(YesNo.NO);
        		cBpartner.setIsonetime(YesNo.NO);
        		
        		cBpartner.setIsprospect(YesNo.SI);
        		
        		cBpartner.setShowpriceinorder(YesNo.SI);
        		
                this.create(cBpartner);
        	}else{
        		validarExistenciaActualizar(cBpartner);
                this.edit(cBpartner);
                System.out.println("facade partner save ");
        	}
        	
            
        }/*catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } */
        catch (ExistException e) {
        	throw new ExecuteRollbackException("El tercero "+ cBpartner.getName() +" ya existe.");
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(CBpartner cBpartner) throws ExecuteRollbackException {
        try {
        	if( cBpartner == null ){
        		throw new ProcessOperationException("El parámetro cBpartner no puede ser null.");
        	}
        	
        	cBpartner.setIsactive(YesNo.NO);
            
            validarExistenciaActualizar(cBpartner);
            this.edit(cBpartner);
            
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
    public void validarExistencia(CBpartner cBpartner) throws ExistException {
        try {
        	CBpartner temp = findByName(cBpartner.getName());
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }

    public void validarExistenciaActualizar(CBpartner cBpartner) throws ExistException {
        try {
        	CBpartner usuarioWithNotChange = find(cBpartner.getId());
            if (!usuarioWithNotChange.getName().trim().equals(cBpartner.getName().trim())) {
                validarExistencia(cBpartner);
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
}
