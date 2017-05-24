/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pharmaceutical.model.ejb.facades;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.Converter;
import javax.persistence.Converts;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import org.pharmaceutical.model.ejb.services.AdPackageService;
import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.enums.Estado;
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
public class AdUserFacade extends AbstractFacade<AdUser> {
	
	@PersistenceContext(unitName = "pharmaceutical-pu")
	private EntityManager em;
	

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public AdUserFacade() {
		super(AdUser.class);
	}
	
	

	public List<AdUser> find(AdUser filter) {

		System.out.println("filter: " + filter);
		

		List<AdUser> result = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT u FROM AdUser u ");
		sql.append("WHERE ");
		sql.append("u.adUserId like :id ");
		sql.append("AND ");
		sql.append("u.username like :username ");
		sql.append("AND ");
		sql.append("COALESCE(u.firstname,'') like :firstname ");
		sql.append("AND ");
		sql.append("COALESCE(u.lastname,'') like :lastname ");
		sql.append("AND ");
		sql.append("COALESCE(u.email,'') like :email ");
		sql.append("AND ");
		sql.append("COALESCE(u.phone,'') like :phone ");
		sql.append("AND ");
		sql.append("COALESCE(u.phone2,'') like :phone2 ");
		sql.append("AND ");
		sql.append("u.isactive = :isactive ");
		
		
		if (filter.getFromDate() != null){
			sql.append("AND ");
			sql.append("u.created >= :startDate ");
		}
		
		if (filter.getToDate() != null){
			sql.append("AND ");
			sql.append("u.created <= :endDate ");	
		}
		

		System.out.println(getClass().getSimpleName() + ": " + sql);

		try {

			Query query = em.createQuery(sql.toString());
			
			//Query query = em. createNativeQuery(sql.toString());

			query.setParameter("id",
					filter.getId() != null ? "%" + filter.getId() + "%" : "%%");
			query.setParameter("username", filter.getUsername() != null ? "%"
					+ filter.getUsername() + "%" : "%%");
			query.setParameter("firstname", filter.getFirstname()!= null ? "%"
					+ filter.getFirstname() + "%" : "%%");
			query.setParameter("lastname", filter.getLastname() != null ? "%"
					+ filter.getLastname() + "%" : "%%");
			query.setParameter("email", filter.getEmail() != null ? "%"
					+ filter.getEmail() + "%" : "%%");
			query.setParameter(
					"phone",
					filter.getPhone() != null ? "%"
							+ filter.getPhone() + "%" : "%%");
			query.setParameter(
					"phone2",
					filter.getPhone2() != null ? "%"
							+ filter.getPhone2() + "%" : "%%");
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
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED) 
	public AdUser findByUsername(String username) {
        List<AdUser> result = null;
        try {
            Query query = em.createNamedQuery("AdUser.findByUsername");
            query.setParameter("username", username);
            query.setParameter("isactive", YesNo.SI);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(AdUser user, String pass1, String pass2) throws ExecuteRollbackException {
        try {
        	if( user == null ){
        		throw new ProcessOperationException("El par�metro usuario no puede ser null.");
        	}
        	
        	if (!StringsUtils.isEmptyTrim(pass1)
    				|| !StringsUtils.isEmptyTrim(pass2)) {
    			// validar pass1
    			if (StringsUtils.isEmptyTrim(pass1)) {
            		throw new ProcessOperationException("La contrase�a est� vac�a.");
    			}
    			// validar pass2
    			if (!StringsUtils.eqTrim_NotNullOrEmpty(pass1, pass2)) {
    				throw new ProcessOperationException("Contrase�a no concuerda.");
    			}
    		}
        	
        	user.setPassword(pass1.trim());
        	
        	if( user.getId() == null ){
        		
        		user.setName(user.getUsername());
        		user.setIslocked(new Character('N'));
        		validarExistencia(user);
                this.create(user);
        	}else{
        		validarExistenciaActualizar(user);
                this.edit(user);
        	}
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } 
        catch (ExistException e) {
        	throw new ExecuteRollbackException("El usuario "+ user.getUsername() +" ya existe.");
        } catch (Exception e) {
        	e.printStackTrace();
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(AdUser user) throws ExecuteRollbackException {
        try {
        	if( user == null ){
        		throw new ProcessOperationException("El parámetro usuario no puede ser null.");
        	}
        	
        	user.setIsactive(YesNo.NO);
            
            validarExistenciaActualizar(user);
            this.edit(user);
            
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
    public void validarExistencia(AdUser user) throws ExistException {
        try {
        	AdUser temp = findByUsername(user.getUsername());
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }

    public void validarExistenciaActualizar(AdUser user) throws ExistException {
        try {
        	AdUser usuarioWithNotChange = find(user.getId());
            if (!usuarioWithNotChange.getUsername().trim().equals(user.getUsername().trim())) {
                validarExistencia(user);
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
    

}
