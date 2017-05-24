package org.pharmaceutical.model.listeners;

import java.util.Date;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.pharmaceutical.model.ejb.services.AdPackageService;
import org.pharmaceutical.model.entities.AbstractEntity;
import org.pharmaceutical.model.entities.AbstractEntityModel;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.utils.SecurityUtils;

public class EntityModelListener {
	
	@EJB
	private SecurityUtils security;
	
	@EJB
	private AdPackageService packageService;

	@PrePersist
    public void prePersist(AbstractEntityModel e){
		e.setAdClientId(security.getAdUser().getAdClientId());
		e.setAdOrgId(security.getAdUser().getAdOrgId());
		e.setId(packageService.nextSequence(e));
		e.setCreated(new Date());
		e.setCreatedby(security.getCurrentUser());
		e.setUpdated(new Date());
		e.setUpdatedby(security.getCurrentUser());
		e.setIsactive(YesNo.SI);
		
    }
	
	@PreUpdate
	public void preUpdate(AbstractEntityModel e){
		e.setUpdated(new Date());
		e.setUpdatedby(security.getCurrentUser());
	}

}
