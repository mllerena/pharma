package org.pharmaceutical.view.controllers;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;

import org.pharmaceutical.model.ejb.facades.AbstractFacade;
import org.pharmaceutical.view.utils.JsfUtils;

public abstract class AbstractController<F,E> {  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Class<?> childClass;
	
	private boolean enabledBack;

	private boolean enabledViewFilter;
	private boolean enabledViewDetail;
	
	private boolean enabledRefresh;

	private boolean enabledCreate;

	private boolean enabledEdit;

	private boolean enabledSave;

	private boolean enabledDelete;

	private boolean enabledCancel;

	private boolean enabledProcess;

	private boolean enabledGenerate;
	
	protected F filterEntity;
	protected E currentEntity;
	
	protected List<E> dataTable;
	
	public AbstractController(Class<?> childClass) {
		this.childClass = childClass;
		System.out.println("AbstractController");
	}


	@PostConstruct
	protected void init() {

		setEnabledBack(true); 
		setEnabledViewFilter(true);
		setEnabledViewDetail(false);

		System.out.println("initialize AbstractController: "
				+ isEnabledViewFilter());

	}
	
	public String getSimpleName(){
		System.out.println("childClass.getSimpleName(): "+childClass.getSimpleName());
		return childClass.getSimpleName();
	}
	
	

	public boolean isEnabledBack() {
		return enabledBack;
	}


	public void setEnabledBack(boolean enabledBack) {
		this.enabledBack = enabledBack;
	}


	public boolean isEnabledViewFilter() {
		return enabledViewFilter;
	}

	public void setEnabledViewFilter(boolean enabledViewFilter) {
		this.enabledViewFilter = enabledViewFilter;
	}

	public boolean isEnabledViewDetail() {
		return enabledViewDetail;
	}

	public void setEnabledViewDetail(boolean enabledViewDetail) {
		this.enabledViewDetail = enabledViewDetail;
	}

	public F getFilterEntity() {
		return filterEntity;
	}

	public void setFilterEntity(F filterEntity) {
		this.filterEntity = filterEntity;
	}

	public E getCurrentEntity() {
		return currentEntity;
	}

	public void setCurrentEntity(E currentEntity) {
		this.currentEntity = currentEntity;
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

	public boolean isEnabledEdit() {
		return enabledEdit;
	}

	public void setEnabledEdit(boolean enabledEdit) {
		this.enabledEdit = enabledEdit;
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

	public boolean isEnabledProcess() {
		return enabledProcess;
	}

	public void setEnabledProcess(boolean enabledProcess) {
		this.enabledProcess = enabledProcess;
	}

	public boolean isEnabledGenerate() {
		return enabledGenerate;
	}

	public void setEnabledGenerate(boolean enabledGenerate) {
		this.enabledGenerate = enabledGenerate;
	}
	
	public List<E> getDataTable() {
		return dataTable;
	}


	public void setDataTable(List<E> dataTable) {
		this.dataTable = dataTable;
	}
	
	public abstract List<E> loadDataTable(F filter);
	
	public int getRowCountTotal(){
		return getDataTable() != null ? getDataTable().size() : 0;
	}


	public final void buscar() {
		dataTable = loadDataTable(filterEntity);
		if (dataTable !=null && !dataTable.isEmpty())
		System.out.println("BUSCADO dataTable: "+dataTable.size());
		
	}

	public final void actionCreate(ActionEvent action) {
		System.out.println("actionCreate: " + action);
		setEnabledViewFilter(false);
		setEnabledViewDetail(true);
		create();
		
		
	}
	
	public void create(){
		throw new UnsupportedOperationException();
	}
	
	public final void actionEdit(ActionEvent action) {
		System.out.println("actionEdit: " + action);
		
		if( getCurrentEntity() == null ){
			JsfUtils.getCurrentContext().addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_WARN, "Debe seleccionar un registro.", null));
			return;
		}
		
		setEnabledViewFilter(false);
		setEnabledViewDetail(true);
		
		edit();
		
		//
		
	}
	
	public void edit(){
		throw new UnsupportedOperationException();
	}

	public final void actionBack(ActionEvent action) {
		System.out.println("actionBack: " + action);
		setEnabledViewFilter(true);
		setEnabledViewDetail(false);
		setCurrentEntity(null);	
		back();
		buscar();
		
	}
	
	public void back(){
		throw new UnsupportedOperationException();
	}
	
	public final void actionDelete(ActionEvent action) {
		System.out.println("actionDelete cabecera: " + getCurrentEntity());
		delete(getCurrentEntity());
		actionBack(action);
	}

	protected void delete(E item) {
		throw new UnsupportedOperationException();
	}

	public final void actionSave(ActionEvent action) { 
		System.out.println("actionSave cabecera " + getCurrentEntity());
		// save(getSelectItems());

		E newItem = save(this.getCurrentEntity());

	}

	protected E save(E item) {
		return item;
	}

	public final void actionCancel(ActionEvent action) {
		System.out.println("actionCancel cabecera: " + getCurrentEntity());
		cancel(this.getCurrentEntity());
	}

	protected void cancel(E item) {
		throw new UnsupportedOperationException();
	}

	public final void actionProcess(ActionEvent action) {
		System.out.println("actionProcess cabecera: " + getCurrentEntity());
		process(getCurrentEntity());
	}

	protected void process(E item) {
		throw new UnsupportedOperationException();
	}

	public final void actionGenerate(ActionEvent action) {
		System.out.println("actionGenerate cabecera: " + getCurrentEntity());
		generate(getCurrentEntity());
	}

	protected void generate(E item) {
		throw new UnsupportedOperationException();
	}
	
	

}
