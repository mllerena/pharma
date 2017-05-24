package org.pharmaceutical.model.ejb.facades;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.enums.Estado;

@Stateless
public class RolFacade extends AbstractFacade<Rol> { 

	private static final Logger LOGGER = Logger.getLogger(RolFacade.class
			.getName());
 
	@PersistenceContext(unitName = "pharmaceutical-pu")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public RolFacade() {
		super(Rol.class);
	}
	
	public Rol findByRol(String rol) {
        List<Rol> result = null;
        try {
            Query query = em.createNamedQuery("Rol.findByNombre");
            query.setParameter("nombre", rol);
            query.setParameter("estado", Estado.ACTIVO);
            result = query.getResultList();
        } catch (Exception e) {
            LOGGER.severe("<< ERROR al cargar el SERVICIO - findByRol>>".concat(e.getMessage()));
        }
        return result.isEmpty() || result == null ? null : result.get(0);
    }


}
