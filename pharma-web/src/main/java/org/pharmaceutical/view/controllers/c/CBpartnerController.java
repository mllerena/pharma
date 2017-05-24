package org.pharmaceutical.view.controllers.c;

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
public class CBpartnerController extends AbstractController<CBpartner,CBpartner> 
		implements Serializable { 
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CBpartnerFacade cBpartnerFacade;
	
	@Inject
	private CGreetingFacade cGreetingFacade;
	
	@Inject
	private CBpGroupFacade cBpGroupFacade;
	
	@Inject
	private CCountryFacade cCountryFacade;
	
	
	@Inject 
	private CBpartnerLocationFacade cBpartnerLocationFacade;

	public CBpartnerController() { 
		super(CBpartnerController.class);
	}
	
	@PostConstruct
	public void initialize(){
		filterEntity = new CBpartner();
		//filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new CBpartner();
		
	}

	@Override
	public List<CBpartner> loadDataTable(CBpartner filter) {
		return cBpartnerFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new CBpartner();
		currentEntity.setIstaxexempt(YesNo.NO);
		currentEntity.setIsvendor(YesNo.NO);
		currentEntity.setIscustomer(YesNo.NO);
		currentEntity.setIsemployee(YesNo.NO);
		currentEntity.setIssalesrep(YesNo.NO);
		System.out.println("create CBpartner currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
		detalleDirecciones.load(); 
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		detalleDirecciones.clear();
	}
	
	@Override
	protected CBpartner save(CBpartner item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		System.out.println("save item.getIscustomer(): "+item.getIscustomer()); 
		
		
		
		try {
			
			cBpartnerFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Tercero guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(CBpartner item) {
		// TODO Auto-generated method stub
		
		try {
			cBpartnerFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Tercero eliminado correctamente.", null);
		
	}

	

	@Override
	protected void cancel(CBpartner item) {
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}



	private DataList<CBpartnerLocation> detalleDirecciones = new DataList<CBpartnerLocation>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<CBpartnerLocation> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<CBpartnerLocation>();
			}
			return cBpartnerLocationFacade.findByCBpartnerId(currentEntity); 
		}
		
		public CBpartnerLocation create(){
			CBpartnerLocation pl = new CBpartnerLocation();
			pl.setCLocationId(new CLocation());
			pl.setIsbillto(YesNo.SI);
			pl.setIspayfrom(YesNo.SI);
			pl.setIsremitto(YesNo.SI);
			pl.setIsshipto(YesNo.SI);
			pl.setIstaxlocation(YesNo.NO);
			pl.setCBpartnerId(currentEntity);
			return pl;
		}

		protected void delete(List<CBpartnerLocation> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				cBpartnerLocationFacade.delete(items); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Dirección(es) elimanada(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected CBpartnerLocation save(CBpartnerLocation item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				cBpartnerLocationFacade.save(item,currentEntity); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Dirección guardada correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<CBpartnerLocation> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				cBpartnerLocationFacade.save(items,currentEntity); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Direcciones guardadas correctamente.", null);
			
		}
		
		
		
		
		
		
	};
	
	
	
	public DataList<CBpartnerLocation> getDetalleDirecciones() {
		return detalleDirecciones;
	}
	
	
	public List<CGreeting> completeGreeting(String query) {

		System.out.println("query: " + query);

		List<CGreeting> allCGreeting = cGreetingFacade.findAll();
		List<CGreeting> filteredCGreeting = new ArrayList<CGreeting>();

		if (allCGreeting != null && !allCGreeting.isEmpty())
			for (int i = 0; i < allCGreeting.size(); i++) {
				CGreeting rol = allCGreeting.get(i);
				if (rol.getName().toUpperCase().contains(query.toUpperCase())) {
					filteredCGreeting.add(rol);
				}
			}

		return filteredCGreeting;
	}
	
	public List<CBpGroup> completeBpGroup(String query) {

		System.out.println("query: " + query);

		List<CBpGroup> allCBpGroup = cBpGroupFacade.findAll();
		List<CBpGroup> filteredCBpGroup = new ArrayList<CBpGroup>();

		if (allCBpGroup != null && !allCBpGroup.isEmpty())
			for (int i = 0; i < allCBpGroup.size(); i++) {
				CBpGroup rol = allCBpGroup.get(i);
				if (rol.getName().toUpperCase().contains(query.toUpperCase())) {
					filteredCBpGroup.add(rol);
				}
			}

		return filteredCBpGroup;
	}
	
	public List<CCountry> completeCountry(String query) {

		System.out.println("query: " + query);

		List<CCountry> all = cCountryFacade.findAll();
		List<CCountry> filtered = new ArrayList<CCountry>();

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				CCountry cCountry = all.get(i);
				if (cCountry.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(cCountry); 
				}
			}

		return filtered;
	}
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}  
	

}
