package org.pharmaceutical.view.controllers.m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.CCountryFacade;
import org.pharmaceutical.model.ejb.facades.MLocatorFacade;
import org.pharmaceutical.model.entities.CCountry;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class MLocatorView implements Serializable { 
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MLocatorFacade mLocatorFacade; 
	
	private MLocator mLocator;
	
	private List<MLocator> dataTable;
	
	@PostConstruct
	public void initialize(){
		System.out.println("initialize MLocatorView: "+mLocator);
		dataTable = mLocatorFacade.findAll(); 
	}
	
	
	
	
	public List<MLocator> getDataTable() {
		return dataTable;
	}




	public void setDataTable(List<MLocator> dataTable) {
		this.dataTable = dataTable;
	}




	public MLocator getmLocator() {
		return mLocator;
	}

	public void setmLocator(MLocator mLocator) {
		this.mLocator = mLocator;
	}
	
	public void view(MLocator mLocator) {
		
		
		
		System.out.println("view bean mLocator" + getmLocator());
		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 350);
        options.put("contentWidth", 740);
        
        
        RequestContext.getCurrentInstance().openDialog("pages/view/m/mLocator",options,null);
        
        //preRenderView();
        
        
    } 
	
	public void add(){
		
		System.out.println("add clocationview: "+getmLocator());
		
		if( getmLocator() == null ){
			JsfUtils.getCurrentContext().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Debe seleccionar un registro.", null));
			return;
		}
		
		RequestContext.getCurrentInstance().closeDialog(mLocator);
		
		
	}
	

}
