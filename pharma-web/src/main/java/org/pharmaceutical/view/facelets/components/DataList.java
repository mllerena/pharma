package org.pharmaceutical.view.facelets.components;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.pharmaceutical.model.entities.AbstractEntity;
import org.pharmaceutical.model.entities.AbstractEntityModel;
import org.pharmaceutical.model.entities.UsuarioRol;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

public abstract class DataList<E extends AbstractEntityModel> {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	private boolean enabledRefresh;

	private boolean enabledCreate;

	private boolean enabledEdit;

	private boolean enabledSave;

	private boolean enabledDelete;

	private boolean enabledCancel;

	private boolean enabledProcess;

	private boolean enabledGenerate;

	protected List<E> dataTable;

	protected List<E> selectItems;

	protected E activeItem;
	
	protected List<E> modifiedItems;

	public DataList() {
		init();
	}

	public void init() {
		setEnabledCreate(true);
		setEnabledEdit(false);
		setEnabledSave(false);
		setEnabledDelete(false);
		setEnabledCancel(false); 
		setSelectItems(new ArrayList<E>());
		setModifiedItems(new ArrayList<E>());
		System.out.println("initialize DataList: ");
		initialize();
	}
	
	protected abstract void initialize();

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

	public List<E> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<E> selectItems) {
		this.selectItems = selectItems;
	}

	public E getActiveItem() {
		return activeItem;
	}

	public void setActiveItem(E activeItem) {
		this.activeItem = activeItem;
	}
	
	public List<E> getModifiedItems() {
		return modifiedItems;
	}

	public void setModifiedItems(List<E> modifiedItems) {
		this.modifiedItems = modifiedItems;
	}

	public void put(E dataReg, List<E> items) {
		// lista actual de registros
		List<E> col = items;
		// buscar el registro a insertar
		int posicion = col.indexOf(dataReg);
		// (ltw) si no se encuentra el elemento, se lo agrega
		if (posicion == -1) {
			col.add(dataReg);
		} else {
			col.set(posicion, dataReg);
		}
	}

	public DataList<E> load() {
		
		setDataTable(loadDataList());
		return this;
	}

	public DataList<E> clear() {
		setDataTable(new ArrayList<E>());
		setSelectItems(new ArrayList<E>());
		setModifiedItems(new ArrayList<E>());
		return this;
	}

	public abstract List<E> loadDataList();
	
	public int getRowCountTotal(){
		return getDataTable() != null ? getDataTable().size() : 0;
	}
	
	public int getRowSelectCountTotal(){
		return getSelectItems() != null ? getSelectItems().size() : 0;
	}
	
	public int getRowModifiedCountTotal(){
		return getModifiedItems() != null ? getModifiedItems().size() : 0;
	}

	public void onCellEdit(E row, String listId){
		
		System.out.println("onCellEdit entity : " + row);
		
		row.setChange(true);
		put(row,getDataTable());
		
		if( modifiedItems == null){
			modifiedItems = new ArrayList<E>();
		}
		
		put(row,getModifiedItems());
		
		setEnabledSave(true);
		setEnabledCancel(true); 
		
		String js =  "onCellEditEvent"+listId+"();"; 
		
		JsfUtils.executeJS(js);	

	}

	public void onRowEditCancel(E row) {
		System.out.println("onRowEditCancel : "+row); 
	}

	public void onRowSelect() {

		System.out.println("onRowSelect items: " + getSelectItems());

		if (getSelectItems() != null && getSelectItems().size() == 1) {
			setActiveItem(getSelectItems().get(0));
			
			/*getActiveItem().setChange(true);
			put(getActiveItem());*/
			
			setEnabledEdit(true);
			setEnabledCancel(true);
			setEnabledProcess(true);
		} else {
			setActiveItem(null);
			setEnabledEdit(false);
			setEnabledCancel(false);
			setEnabledProcess(false);
		}

		if (getSelectItems() != null && getSelectItems().size() >= 1) {
			setEnabledDelete(true);
			setEnabledCancel(true);
		} else {
			setEnabledDelete(false);
			setEnabledCancel(false);
		}
		
		select(getSelectItems()); 

	}
	
	protected void select(List<E> items) {
		return;   
	}

	public void onRowUnselect() {

		System.out.println("onRowUnselect items: " + getSelectItems());

		if (getSelectItems() != null && getSelectItems().size() == 1) {
			setActiveItem(getSelectItems().get(0));
			setEnabledEdit(true);
			setEnabledCancel(true);
			setEnabledProcess(true);
		}

		if (getSelectItems() != null && getSelectItems().size() == 0) {
			setActiveItem(null);
			setEnabledEdit(false);
			setEnabledCancel(false);
			setEnabledProcess(false);
		}

		if (getSelectItems() != null && getSelectItems().size() >= 1) {
			setEnabledDelete(true);
			setEnabledCancel(true);
		} else {
			setEnabledDelete(false);
			setEnabledCancel(false);
		}
		
		unSelect();

	}
	
	protected void unSelect() {
		return;   
	}

	public final void actionCreate(ActionEvent action) {
		System.out.println("actionCreate datalist: " + action);
		setActiveItem(create());
		init();
		clear();
		load();
		
	}

	protected E create() {
		throw new UnsupportedOperationException();
	}

	public final void actionEdit(ActionEvent action) {
		System.out.println("actionEdit datalist: " + getSelectItems());
		edit(activeItem);
	}

	protected E edit(E item) {
		return item;
	}

	public final void actionDelete(String modal) { 
		System.out.println("actionDelete datalist: " + getSelectItems());
		delete(getSelectItems());
		init();
		clear();
		load();
		
		JsfUtils.executeJS("PF('wvEdit_" + modal+  "').hide();");
		
	}
	
	public final void actionDelete(ActionEvent action) { 
		System.out.println("actionDelete datalist: " + getSelectItems());
		delete(getSelectItems());
		init();
		clear();
		load();
		
	}

	protected void delete(List<E> items) {
		throw new UnsupportedOperationException();
	}

	public final void actionSave(String modal) { 
		System.out.println("actionSave activeItem: " + this.activeItem);
		// save(getSelectItems());

		E newItem = save(this.activeItem);

		/*
		 * if (newItem.getId() != null) { // definirlo como seleccionado
		 * put(newItem); setActiveItem(newItem); }
		 */

		init();
		clear();
		load();
		
		JsfUtils.executeJS("PF('wvEdit_" + modal+  "').hide();");
		
		
	}

	protected E save(E item) {
		return item;
	}
	
	public final void actionMultiSave(ActionEvent action) {
		System.out.println("actionMultiSave datalist: " + getModifiedItems());
		multiSave(getModifiedItems());
		init();
		clear();
		load();
	}

	protected void multiSave(List<E> items) {
		throw new UnsupportedOperationException();
	}

	public final void actionCancel(String modal) { 
		System.out.println("actionCancel datalist: " + getSelectItems());
		cancel();
		init();
		clear();
		load();
		
		JsfUtils.executeJS("PF('wvEdit_" + modal+  "').hide();");
	}

	protected void cancel() {
		throw new UnsupportedOperationException();
	}

	public final void actionProcess(ActionEvent action) {
		System.out.println("actionProcess datalist: " + getSelectItems());
		process(getSelectItems());
		init();
		clear();
		load();
		
		
	}

	protected void process(List<E> items) {
		throw new UnsupportedOperationException();
	}

	public final void actionGenerate(ActionEvent action) {
		System.out.println("actionGenerate datalist: " + getSelectItems());
		generate(getSelectItems());
		init();
		clear();
		load();
	}

	protected void generate(List<E> items) {
		throw new UnsupportedOperationException();
	}

}
