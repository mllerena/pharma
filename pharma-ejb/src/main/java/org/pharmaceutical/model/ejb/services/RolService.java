package org.pharmaceutical.model.ejb.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.ejb.facades.RolFacade;


//@Stateless
public class RolService {   

    private static final Logger LOGGER = Logger.getLogger(RolService.class.getName());
    @EJB
    RolFacade rolFacade;

    public RolService() {
    }

    public List<Rol> findAll() {
        List<Rol> result = null;
        try {
            result = rolFacade.findAll();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Rol findByRol(String rol) {
    	Rol result = null;
        try {
            result = rolFacade.findByRol(rol);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, null, e);
        }
        return result;
    }
    
}
