package org.pharmaceutical.view.controllers.c;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.CCountryFacade;
import org.pharmaceutical.model.entities.CCountry;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class CLocationView implements Serializable { 
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CCountryFacade cCountryFacade; 
	
	private CLocation cLocation;
	
	@PostConstruct
	public void initialize(){
		System.out.println("initialize CLocationView: "+cLocation);
		cLocation = new CLocation();
		
	}
	
	public CLocation getcLocation() {
		return cLocation;
	}

	public void setcLocation(CLocation cLocation) {
		this.cLocation = cLocation;
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
	
	public void view(CLocation cLocation) {
		
		/*if(cLocation == null){
			setcLocation(new CLocation()); 
		}else{
			setcLocation(cLocation);	
		}*/
		
		
		
		System.out.println("view bean getcLocation" + getcLocation());
		System.out.println("view bean getcLocation.adress " + getcLocation().getAddress1());
		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 250);
        
        RequestContext.getCurrentInstance().openDialog("pages/view/c/cLocation",options,null);
        
        //preRenderView();
        
        
    } 
	
	public void add(){
		
		System.out.println("add clocationview: "+cLocation);
		
		RequestContext.getCurrentInstance().closeDialog(cLocation);
		
		//JsfUtils.removeManagedBean("cLocationView"); 
		
	}
	

}
