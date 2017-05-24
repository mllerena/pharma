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
import org.pharmaceutical.model.ejb.facades.MProductFacade;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MProduct;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class MProductView implements Serializable { 
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MProductFacade mProductFacade;
	
	@Inject
	private MLocatorFacade mLocatorFacade;
	
	private MProduct mProduct;
	
	private List<MProduct> dataTable;
	
	@PostConstruct
	public void initialize(){
		System.out.println("initialize MLocatorView: "+mProduct);
		
		List<MLocator> listFilter = new ArrayList<MLocator> ();
		
		MLocator mlocator = mLocatorFacade.find("4");
		listFilter.add(mlocator);
		
		mlocator = mLocatorFacade.find("10");
		listFilter.add(mlocator);
		
		mlocator = mLocatorFacade.find("11");
		listFilter.add(mlocator);
		
		dataTable = mProductFacade.findByMLocatorId(listFilter); 
	}
	
	public MProduct getmProduct() {
		return mProduct;
	}

	public void setmProduct(MProduct mProduct) {
		this.mProduct = mProduct;
	}

	public List<MProduct> getDataTable() {
		return dataTable;
	}

	public void setDataTable(List<MProduct> dataTable) {
		this.dataTable = dataTable;
	}
	
	public void view(MProduct mProduct) {
		
		
		System.out.println("view bean MProduct" + getmProduct());
		
		Map<String,Object> options = new HashMap<String, Object>();
        options.put("modal", true);
        options.put("draggable", false);
        options.put("resizable", false);
        options.put("contentHeight", 600);
        options.put("contentWidth", 860);
        
        
        RequestContext.getCurrentInstance().openDialog("pages/view/m/mProduct",options,null); 
        
        //preRenderView();
        
        
    } 
	
	public void add(){
		
		System.out.println("add clocationview: "+getmProduct());
		
		if( getmProduct() == null ){
			JsfUtils.getCurrentContext().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Debe seleccionar un registro.", null));
			return;
		}
		
		
		
		RequestContext.getCurrentInstance().closeDialog(mProduct); 
		
		
	}
	

}
