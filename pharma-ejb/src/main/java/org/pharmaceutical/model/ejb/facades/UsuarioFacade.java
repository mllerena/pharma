package org.pharmaceutical.model.ejb.facades;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.pharmaceutical.model.entities.AbstractEntity;
import org.pharmaceutical.model.entities.Usuario; 
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.exceptions.ExecuteRollbackException;
import org.pharmaceutical.model.exceptions.ExistException;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> { 

    private static final Logger LOGGER = Logger.getLogger(UsuarioFacade.class.getName());
    
    @PersistenceContext(unitName = "pharmaceutical-pu")
    private EntityManager em; 

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public List<Usuario> find(Usuario filter) {
    	
    	System.out.println("filter: "+filter);
    	
    	List<Usuario> result = null;
    	
    	StringBuilder sql = new StringBuilder(); 
    	sql.append("SELECT u FROM Usuario u ");
    	sql.append("WHERE ");
    	sql.append("CAST ( u.id AS text ) like :id ");
    	sql.append("AND ");
    	sql.append("u.usuario like :usuario ");
    	sql.append("AND ");
    	sql.append("u.nombre like :nombre ");
    	sql.append("AND ");
    	sql.append("u.apellido like :apellido ");
    	sql.append("AND ");
    	sql.append("u.correo like :correo ");
    	sql.append("AND ");
    	sql.append("COALESCE(u.telefonoFijo,'') like :telefonoFijo ");
    	sql.append("AND ");
    	sql.append("COALESCE(u.telefonoMovil,'') like :telefonoMovil ");
    	sql.append("AND ");
    	sql.append("u.estado = :estado");
    	
    	System.out.println(getClass().getSimpleName()+ ": "+sql);
    	
        try {
            
        	
        	Query query = em.createQuery(sql.toString());
        	
        	query.setParameter("id", filter.getId() != null ? "%"+filter.getId()+"%" : "%%");
        	query.setParameter("usuario", filter.getUsuario() != null ? "%"+filter.getUsuario()+"%" : "%%");
        	query.setParameter("nombre", filter.getNombre() != null ? "%"+filter.getNombre()+"%" : "%%");
        	query.setParameter("apellido", filter.getApellido() != null ? "%"+filter.getApellido()+"%" : "%%");
        	query.setParameter("correo", filter.getCorreo() != null ? "%"+filter.getCorreo()+"%" : "%%");
        	query.setParameter("telefonoFijo", filter.getTelefonoFijo()!= null ? "%"+filter.getTelefonoFijo()+"%" : "%%");
        	query.setParameter("telefonoMovil", filter.getTelefonoMovil() != null ? "%"+filter.getTelefonoMovil()+"%" : "%%");
        	query.setParameter("estado", filter.getEstado() );
        	
            result = query.getResultList();
            
        } catch (Exception e) {
        	LOGGER.severe("<< ERROR al cargar el SERVICIO - find>>".concat(e.getMessage()));
        }
        return result;
        
    }
    
    public List<Usuario> findByEstado(Estado estado) {
    	
    	List<Usuario> result = null;
    	
        try {
            Query query = em.createNamedQuery("Usuario.findByEstado");
            query.setParameter("estado", estado);
            
            result = query.getResultList();
            
        } catch (Exception e) {
        	LOGGER.severe("<< ERROR al cargar el SERVICIO - findByEstado>>".concat(e.getMessage()));
        }
        return result;
    }
    
    
    public Usuario findByUsuario(String usuario) {
        List<Usuario> result = null;
        try {
            Query query = em.createNamedQuery("Usuario.findByUsuario");
            query.setParameter("usuario", usuario);
            query.setParameter("estado", Estado.ACTIVO);
            result = query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("<< ERROR al cargar el SERVICIO - findByUsuario>>".concat(e.getMessage()));
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }
    
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void almacenar(Usuario usuario) throws ExistException, ExecuteRollbackException {
        try {
            validarExistencia(usuario);
            this.create(usuario);
        } catch (ExistException e) {
            throw new ExistException(e);
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void actualizar(Usuario usuario) throws ExistException, ExecuteRollbackException {
        try {
            validarExistenciaActualizar(usuario);
            this.edit(usuario);
        } catch (ExistException e) {
            throw new ExistException(e);
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void eliminar(Usuario usuario) throws ExecuteRollbackException {
        try {
            this.remove(usuario);
        } catch (Exception e) {
            throw new ExecuteRollbackException(e);
        }
    }

    // =============================================================
    // METODOS VALIDACIONES 
    // =============================================================
    public void validarExistencia(Usuario usuario) throws ExistException {
        try {
            Usuario temp = findByUsuario(usuario.getUsuario());
            if (temp != null) {
                throw new ExistException();
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }

    public void validarExistenciaActualizar(Usuario usuario) throws ExistException {
        try {
        	Usuario usuarioWithNotChange = find(usuario.getId());
            if (!usuarioWithNotChange.getUsuario().trim().equals(usuario.getUsuario().trim())) {
                validarExistencia(usuario);
            }
        } catch (ExistException e) {
            throw new ExistException(e);
        }
    }
}
