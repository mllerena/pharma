package org.pharmaceutical.model.ejb.facades;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol; 
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;

@Stateless 
public class UsuarioRolFacade extends AbstractFacade<UsuarioRol> { 

    private static final Logger LOGGER = Logger.getLogger(UsuarioRolFacade.class.getName());
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioRolFacade() {
        super(UsuarioRol.class);
    }
    
    
    
    public UsuarioRol findByUsuarioAndRol(Usuario usuario,Rol rol) {
        List<UsuarioRol> result = null;
        try {
            Query query = em.createNamedQuery("UsuarioRol.findByUsuarioAndRol");
            query.setParameter("usuario", usuario);
            query.setParameter("rol", rol);
            query.setParameter("estado", Estado.ACTIVO);
            result = query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("<< ERROR al cargar el SERVICIO - findByUsuario>>".concat(e.getMessage()));
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }

    public List<UsuarioRol> findByUsuario(Usuario usuario) {
        List<UsuarioRol> result = null;
        try {
            Query query = em.createNamedQuery("UsuarioRol.findByUsuario");
            query.setParameter("usuario", usuario);
            query.setParameter("estado", Estado.ACTIVO);
            result = query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("<< ERROR al cargar el SERVICIO - findByUsuario>>".concat(e.getMessage()));
        }
        return result.isEmpty() || result == null ? null : result;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void almacenar(UsuarioRol usuarioRol) throws ExistException, ExecuteRollbackException {
        try {
        	validarExistencia(usuarioRol);
            this.create(usuarioRol);
        }catch (ExistException e) {
                throw new ExistException(e); 
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(UsuarioRol usuarioRol) throws ExistException, ExecuteRollbackException {
        try {
        	validarExistenciaActualizar(usuarioRol);
            this.edit(usuarioRol);
        }catch (ExistException e) {
            throw new ExistException(e); 
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(UsuarioRol usuarioRol) throws ExecuteRollbackException {
        try {
            this.remove(usuarioRol);
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }
    
    public void validarExistencia(UsuarioRol usuarioRol) throws ExistException {
        try {
            UsuarioRol temp = findByUsuarioAndRol(usuarioRol.getUsuario(),usuarioRol.getRol());
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
    public void validarExistenciaActualizar(UsuarioRol usuarioRol) throws ExistException {
        try {
        	UsuarioRol usuarioWithNotChange = find(usuarioRol.getId());
            if (usuarioWithNotChange.getRol().getId().intValue() !=  usuarioRol.getRol().getId().intValue() ) {
                validarExistencia(usuarioRol);
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
    
}
