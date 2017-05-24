package org.pharmaceutical.model.ejb.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.NoResultException;

import org.pharmaceutical.model.entities.AbstractEntity;
import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;
import org.pharmaceutical.model.ejb.facades.AdRoleFacade;
import org.pharmaceutical.model.ejb.facades.AdUserFacade;
import org.pharmaceutical.model.ejb.facades.AdUserRolesFacade;
import org.pharmaceutical.model.ejb.facades.RolFacade;
import org.pharmaceutical.model.ejb.facades.UsuarioFacade;
//import sico.utils.MessagesUtils;
import org.pharmaceutical.model.ejb.facades.UsuarioRolFacade;
import org.pharmaceutical.model.utils.StringsUtils;


@Stateless
public class AdUsersService {   

    private static final Logger LOGGER = Logger.getLogger(AdUsersService.class.getName());
    
    @EJB
    AdUserFacade adUserFacade;
    
    @EJB
    AdRoleFacade adRoleFacade;
    
    @EJB
    AdUserRolesFacade adUserRolesFacade;

    public AdUsersService() {
    }
    
/*    public List<AdUser> findAll() {
        List<AdUser> result = null;
        try {
            result = adUserFacade.findAll();  
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    public List<AdUser> find(AdUser filter) {
        List<AdUser> result = null;
        try {
            result = adUserFacade.find(filter);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }

    
    public AdUser findById( String id ) {
    	AdUser result = null;
        try {
            result = adUserFacade.find(id);
        } catch (NoResultException e) {
        	LOGGER.log(Level.SEVERE, null, e);
        }catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Usuario findByUsuario(String usuario) {
        Usuario result = null;
        try {
            result = usuarioFacade.findByUsuario(usuario);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(Usuario usuario, String pass1, String pass2) throws ExecuteRollbackException {
        try {
        	if( usuario == null ){
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
        	
        	usuario.setClave(pass1.trim());
        	
        	if( usuario.getId() == null ){
        		usuarioFacade.almacenar(usuario);
        	}else{
        		usuarioFacade.actualizar(usuario);
        	}
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } 
        catch (ExistException e) {
        	throw new ExecuteRollbackException("El usuario "+ usuario.getUsuario() +" ya existe.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(Usuario usuario) throws ExecuteRollbackException {
        try {
        	if( usuario == null ){
        		throw new ProcessOperationException("El par�metro usuario no puede ser null.");
        	}
        	
        	usuario.setEstado(Estado.INACTIVO);
        	
            usuarioFacade.actualizar(usuario);
            
        } catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            throw new ExecuteRollbackException("Error al borrar el registro!");
        }
    }*/
    
    

}
