package org.pharmaceutical.model.ejb.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;
import org.pharmaceutical.model.exceptions.ProcessOperationException;
import org.pharmaceutical.model.ejb.facades.UsuarioRolFacade;
import org.pharmaceutical.model.utils.StringsUtils;


//@Stateless
public class UsuarioRolService {   

    private static final Logger LOGGER = Logger.getLogger(UsuarioRolService.class.getName());
    
    @EJB
    UsuarioRolFacade usuarioRolFacade;

    public UsuarioRolService() {
    }

    // =============================================================
    // METODOS DE OBTENCION DE INFORMACION 
    // =============================================================
    public List<UsuarioRol> findAll() {
        List<UsuarioRol> result = null;
        try {
            result = usuarioRolFacade.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<UsuarioRol> findByUsuario(Usuario usuario) {
        List<UsuarioRol> result = null;
        try {
            result = usuarioRolFacade.findByUsuario(usuario);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(UsuarioRol usuarioRol, Usuario usuario) throws ExecuteRollbackException {
        try {
        	if( usuarioRol == null){
        		throw new ProcessOperationException("El par�metro usuarioRol no puede ser null.");
        	}
        	
        	if( usuario == null){
        		throw new ProcessOperationException("El par�metro usuario no puede ser null.");
        	}
        	
        	if( usuario.getId() == null){
        		throw new ProcessOperationException("El usuario no esta guardado, no existe en la base de datos.");
        	}
        	
        	
        	if( usuarioRol.getId() == null ){
        		usuarioRolFacade.almacenar(usuarioRol);
        	}else{
        		usuarioRolFacade.actualizar(usuarioRol);
        	}
        	
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        }catch (ExistException e) {
        	throw new ExecuteRollbackException("El rol "+ usuarioRol.getRol().getNombre() +" ya ha sido asignado anteriormente.");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            throw new ExecuteRollbackException("Error al guardar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(List<UsuarioRol> usuariosRoles, Usuario usuario) throws ExecuteRollbackException {
        try {
        	if( usuariosRoles == null){
        		throw new ProcessOperationException("El par�metro usuarioRol no puede ser null.");
        	}
        	
        	if( usuario == null){
        		throw new ProcessOperationException("El par�metro usuario no puede ser null.");
        	}
        	
        	if( usuario.getId() == null){
        		throw new ProcessOperationException("El usuario no esta guardado, no existe en la base de datos.");
        	}
        	
        	for (UsuarioRol usuarioRol : usuariosRoles) {
				this.save(usuarioRol, usuario);
			}
        	
        }catch (ExecuteRollbackException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            throw new ExecuteRollbackException("Error al guardar los registros!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(UsuarioRol usuarioRol) throws ExecuteRollbackException {
        try {
        	if( usuarioRol == null ){
        		throw new ProcessOperationException("El par�metro usuarioRol no puede ser null.");
        	}
        	
        	usuarioRol.setEstado(Estado.INACTIVO);
        	
        	usuarioRolFacade.actualizar(usuarioRol);
            
        }catch (ExecuteRollbackException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        }catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            throw new ExecuteRollbackException("Error al borrar el registro!");
        }
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(List<UsuarioRol> usuariosRoles) throws ExecuteRollbackException {
        try {
        	if( usuariosRoles == null){
        		throw new ProcessOperationException("El par�metro usuarioRol no puede ser null.");
        	}
        	
        	for (UsuarioRol usuarioRol : usuariosRoles) {
				this.delete(usuarioRol);
			}
            
        }catch (ProcessOperationException e) {
        	throw new ExecuteRollbackException(e.getMessage());
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
            throw new ExecuteRollbackException("Error al guardar los registros!");
        }
    }
    
    
    
    
    
    
    /////despues sacar
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void almacenar(UsuarioRol usuarioRol) throws ExistException, ExecuteRollbackException {
        try {
        	usuarioRolFacade.almacenar(usuarioRol);
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(UsuarioRol usuarioRol) throws ExistException, ExecuteRollbackException {
        try {
        	usuarioRolFacade.actualizar(usuarioRol);
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(UsuarioRol usuarioRol) throws ExecuteRollbackException {
        try {
        	usuarioRolFacade.eliminar(usuarioRol);
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }
    
    
    
}
