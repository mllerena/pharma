package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.AdRoleFacade;
import org.pharmaceutical.model.ejb.facades.AdUserFacade;
import org.pharmaceutical.model.ejb.facades.AdUserRolesFacade;
import org.pharmaceutical.model.ejb.facades.CBpGroupFacade;
import org.pharmaceutical.model.ejb.facades.CBpartnerFacade;
import org.pharmaceutical.model.ejb.facades.CBpartnerLocationFacade;
import org.pharmaceutical.model.ejb.facades.CCountryFacade;
import org.pharmaceutical.model.ejb.facades.CGreetingFacade;
import org.pharmaceutical.model.ejb.facades.MaSectionFacade;
import org.pharmaceutical.model.ejb.services.RolService;
import org.pharmaceutical.model.ejb.services.UsuarioRolService;
import org.pharmaceutical.model.ejb.services.UsuarioService;
import org.pharmaceutical.model.entities.AdRole;
import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.AdUserRoles;
import org.pharmaceutical.model.entities.CBpGroup;
import org.pharmaceutical.model.entities.CBpartner;
import org.pharmaceutical.model.entities.CBpartnerLocation;
import org.pharmaceutical.model.entities.CCountry;
import org.pharmaceutical.model.entities.CGreeting;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MaSection;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.utils.StringsUtils;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class MaSectionController extends AbstractController<MaSection,MaSection> 
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaSectionFacade maSectionFacade;

	public MaSectionController() { 
		super(MaSectionController.class);
	}
	
	@PostConstruct
	public void initialize(){
		filterEntity = new MaSection();
		//filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaSection();
		
	}

	@Override
	public List<MaSection> loadDataTable(MaSection filter) {
		return maSectionFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaSection();
		System.out.println("create MaSection currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
		//detalleUsuariosRoles.load();
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaSection save(MaSection item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maSectionFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Área guardada correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaSection item) {
		// TODO Auto-generated method stub
		
		try {
			maSectionFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Área eliminado correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaSection item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}  
	

}
