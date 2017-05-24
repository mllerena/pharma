package org.pharmaceutical.model.listeners;

import java.util.Date;

import javax.ejb.EJB;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.pharmaceutical.model.entities.AbstractEntity;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.utils.SecurityUtils;


public class AuditEntityListener { 
	
	
	@EJB
	private SecurityUtils security;
	

	@PrePersist
    public void prePersist(AbstractEntity e){
		
		e.setUsuarioIngreso(security.getCurrentUser());
		e.setUsuarioModificacion(security.getCurrentUser());
		e.setFechaCreacion(new Date());
		e.setFechaModificacion(new Date());
		e.setEstado(Estado.ACTIVO);
    }
	
	@PreUpdate
	public void preUpdate(AbstractEntity e){
		e.setUsuarioModificacion(security.getCurrentUser());
    	e.setFechaModificacion(new Date());
    	
	}
	
	
}
