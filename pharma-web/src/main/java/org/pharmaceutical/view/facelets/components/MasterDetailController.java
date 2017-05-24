package org.pharmaceutical.view.facelets.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;
import javax.persistence.EntityManager;

import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.view.utils.JsfUtils;


public abstract class MasterDetailController <E> implements Serializable{
	 
	
	private E selectedEntityEdit;
	
	private E selectedEntityLink;
	
	
	private boolean enabledRefresh;
	
	private boolean enabledCreate;
	
	private boolean enabledSave;
	
	private boolean enabledDelete;
	
	private boolean enabledCancel;
	
	
	private List<E> list;
	

	private Class<E> entityClass;
	
	private Object[] parametrosLoadList;
	
	


	public MasterDetailController() {
	
	}
	

    public MasterDetailController(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

	@PostConstruct
	public void init(){
		//setSelectedEnt(new );
		System.out.println("inicialize MasterDetailController: "+entityClass.getSimpleName());
		
		
		setEnabledRefresh(true);
		setEnabledCreate(true);
		setEnabledSave(false);
		setEnabledDelete(false);
		setEnabledCancel(false);
		
	}
	
	public Object[] getParametrosLoadList() {
		return parametrosLoadList;
	}


	public void setParametrosLoadList(Object[] parametrosLoadList) {
		this.parametrosLoadList = parametrosLoadList;
	}
	
	public boolean isEnabledRefresh() {
		return enabledRefresh;
	}


	public void setEnabledRefresh(boolean enabledRefresh) {
		this.enabledRefresh = enabledRefresh;
	}


	public boolean isEnabledCreate() {
		return enabledCreate;
	}

	public void setEnabledCreate(boolean enabledCreate) {
		this.enabledCreate = enabledCreate;
	}

	public boolean isEnabledSave() {
		return enabledSave;
	}

	public void setEnabledSave(boolean enabledSave) {
		this.enabledSave = enabledSave;
	}

	public boolean isEnabledDelete() {
		return enabledDelete;
	}

	public void setEnabledDelete(boolean enabledDelete) {
		this.enabledDelete = enabledDelete;
	}

	public boolean isEnabledCancel() {
		return enabledCancel;
	}

	public void setEnabledCancel(boolean enabledCancel) {
		this.enabledCancel = enabledCancel;
	}

	public List<E> getList() {
		return list;
	}
	
	public void setList(List<E> list) {
		this.list = list;
	}
	
	
	
	public E getSelectedEntityEdit() {
		return selectedEntityEdit;
	}


	public void setSelectedEntityEdit(E selectedEntityEdit) {
		this.selectedEntityEdit = selectedEntityEdit;
	}


	public E getSelectedEntityLink() {
		return selectedEntityLink;
	}


	public void setSelectedEntityLink(E selectedEntityLink) {
		this.selectedEntityLink = selectedEntityLink;
	}
	
	public String updateSelection(String id, String updateSelection){
		
		String root = "@parent:@parent:@parent:tvMasterDetail_"+ id+":@parent";
		
		String result = "";
		
		if (updateSelection != null && !updateSelection.isEmpty()){
			
			int i = updateSelection.indexOf(" ");
			
			if ( i > -1 ){
				StringTokenizer st = new StringTokenizer(updateSelection," ");
				while ( st.hasMoreElements() ){
					String updateComponent  = (String) st.nextElement();
					result += root + updateComponent;
					
					if ( st.hasMoreElements()){
						result += " ";
					}
					
				}
			}else{
				result += root + updateSelection;
			}
			
			
		}
		
		System.out.println("result updateSelection: "+result);
		
		return result;
		
	}


	public abstract void loadList(Object ... parametros);

	public abstract void reset();
	
	public abstract boolean validate();
	
	public abstract void save();
	
	public void delete(){
		delete(getSelectedEntityEdit());
	}
	
	//Button delete, listener
	public abstract void delete(E entity);
	
	//Button edit, listener
	public abstract void selected(E entity);
	
	//If selectionMode is true, listener
	public abstract void selectedLinked();
	
	
	public void create() {
		
		System.out.println("create");
		
		//setUpdateEntity(true);
		setEnabledCreate(false);
		setEnabledSave(true);
		setEnabledDelete(false);
		setEnabledCancel(true);
		
		reset();
		
	}
	
	public void cancel() {
		
		System.out.println("back");
		
		setEnabledCreate(true);
		setEnabledSave(false);
		setEnabledDelete(false);
		setEnabledCancel(false);
		
		reset();
		
	}


	
	

}
