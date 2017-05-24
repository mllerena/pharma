package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

import org.drools.core.reteoo.compiled.SetNodeReferenceHandler;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.jbpm.services.api.model.ProcessInstanceDesc;
import org.jbpm.services.api.model.UserTaskInstanceDesc;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.pharmaceutical.bpm.utils.StartupBean;
import org.pharmaceutical.model.ejb.facades.MaProcessFacade;
import org.pharmaceutical.model.ejb.facades.MaProcessplanFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineTypeFacade;
import org.pharmaceutical.model.ejb.facades.MaMaintOperationFacade;
import org.pharmaceutical.model.ejb.facades.MaMaintPeriodicityFacade;
import org.pharmaceutical.model.ejb.facades.MaSequenceFacade;
import org.pharmaceutical.model.ejb.facades.MaProcessplanFacade;
import org.pharmaceutical.model.ejb.facades.MaProcessplanVersionFacade;
import org.pharmaceutical.model.ejb.facades.MaSequenceproductFacade;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MProduct;
import org.pharmaceutical.model.entities.MaMachine; 
import org.pharmaceutical.model.entities.MaMaintenance;
import org.pharmaceutical.model.entities.MaProcess;
import org.pharmaceutical.model.entities.MaProcessplan; 
import org.pharmaceutical.model.entities.MaMachineType;
import org.pharmaceutical.model.entities.MaMaintOperation;
import org.pharmaceutical.model.entities.MaMaintPeriodicity;
import org.pharmaceutical.model.entities.MaSequence;
import org.pharmaceutical.model.entities.MaProcessplan;
import org.pharmaceutical.model.entities.MaProcessplanVersion;
import org.pharmaceutical.model.entities.MaSequence;
import org.pharmaceutical.model.entities.MaSequenceproduct;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.MaintType;
import org.pharmaceutical.model.enums.PeriodicityType;
import org.pharmaceutical.model.enums.ProductionType;
import org.pharmaceutical.model.enums.ShiftType;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.utils.SecurityUtils;
import org.pharmaceutical.view.beans.Tab;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.controllers.TemplateController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class MaProcessplanController extends AbstractController<MaProcessplan,MaProcessplan>  
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaProcessplanFacade maProcessplanFacade;
	
	@Inject
	private MaProcessplanVersionFacade maProcessplanVersionFacade;
	
	@Inject
	private MaSequenceFacade maSequenceFacade;
	
	@Inject
	private MaSequenceproductFacade maSequenceproductFacade;
	
	@Inject
	private MaProcessFacade maProcessFacade;
	
	@Inject 
	private TemplateController template;
	
	@Inject
    private UserTaskService userTaskService; 
	
	
	@Inject
    private RuntimeDataService runtimeDataService;
	
	private UserTaskInstanceDesc taskActive;
	
	private ProcessInstanceDesc processTaskActive;
	
	@Inject 
	private SecurityUtils securityUtils;
	
	
	public MaProcessplanController() { 
		super(MaProcessplanController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaProcessplan();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI); 
		currentEntity = new MaProcessplan();
		
		//carga por bpm
		Tab tab = template.getTabByBean(getSimpleName());
		if( tab != null && tab.getParams() != null)
		if(tab.getParams().containsKey("taskSelected")){
			
			UserTaskInstanceDesc t = (UserTaskInstanceDesc) tab.getParams().get("taskSelected");
			taskActive = runtimeDataService.getTaskById(t.getTaskId());
			
			processTaskActive = runtimeDataService.getProcessInstanceById(taskActive.getProcessInstanceId());  
			
			//Existe plan para esta tarea de bpm?
			MaProcessplan processPlan = maProcessplanFacade.findByTaskId(taskActive.getTaskId());
			
			setEnabledBack(false);  
			setEnabledViewFilter(false);
			setEnabledViewDetail(true);
			
			if(processPlan == null ){	
				create();	
			}else{
				currentEntity = processPlan;
				edit();
			}
			
			  
			
			
			
			System.out.println("en constructor de process plan y se ejecuto para que alga directo en nuevo");
			
		}
		
		
	}

	@Override
	public List<MaProcessplan> loadDataTable(MaProcessplan filter) {
		return maProcessplanFacade.find(filter);  
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaProcessplan();
		if( taskActive != null){
			currentEntity.setTaskId(taskActive.getTaskId()); 
		}
		System.out.println("create MaProcessplan currentEntity: "+currentEntity);
		detalleVersion.load();
		detalleVersion.init();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		detalleVersion.load();
		detalleVersion.init();
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaProcessplan save(MaProcessplan item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maProcessplanFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Plan producción guardada correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaProcessplan item) {
		// TODO Auto-generated method stub
		
		try {
			maProcessplanFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Plan producción eliminada correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaProcessplan item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	
	
	/*
	 * Detalle costo maquina
	 * 
	 */
	private DataList<MaProcessplanVersion> detalleVersion = new DataList<MaProcessplanVersion>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<MaProcessplanVersion> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaProcessplanVersion>();
			}
			return maProcessplanVersionFacade.findByMaProcessplanId(currentEntity);
		}
		
		public MaProcessplanVersion create(){ 
			MaProcessplanVersion pl = new MaProcessplanVersion();
			pl.setMaProcessplanId(currentEntity); 
			return pl;
		}

		protected void delete(List<MaProcessplanVersion> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maProcessplanVersionFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Versión(es) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaProcessplanVersion save(MaProcessplanVersion item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maProcessplanVersionFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Versión guardado correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaProcessplanVersion> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maProcessplanVersionFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Versiónes guardadas correctamente.", null); 
			
		}
		
		@Override
		protected void select(List<MaProcessplanVersion> items) {
			// TODO Auto-generated method stub
			detalleSecuencia.load(); 
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlSecuencia");
			JsfUtils.update(foundComponent.getClientId());
		}

		@Override
		protected void unSelect() {
			// TODO Auto-generated method stub
			
			detalleSecuencia.load(); 
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlSecuencia");
			JsfUtils.update(foundComponent.getClientId());
			
		}

		
		
		
	};
	
	public DataList<MaProcessplanVersion> getDetalleVersion() { 
		return detalleVersion;
	} 
	
	
	/*
	 * Detalle secuencia 
	 * 
	 */
	private DataList<MaSequence> detalleSecuencia = new DataList<MaSequence>() { 
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<MaSequence> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaSequence>();
			}
			return maSequenceFacade.findByMaProcessplanVersionId(getDetalleVersion().getActiveItem());    
		}
		
		public MaSequence create(){ 
			MaSequence pl = new MaSequence();
			pl.setMaProcessplanVersionId(getDetalleVersion().getActiveItem());
			return pl;
		}

		protected void delete(List<MaSequence> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maSequenceFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Secuencia(s) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaSequence save(MaSequence item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maSequenceFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Secuencia guardado correctamente.", null); 
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaSequence> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maSequenceFacade.save(items);    
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Secuencias guardados correctamente.", null); 
			
		}
		
		@Override
		protected void select(List<MaSequence> items) {
			// TODO Auto-generated method stub
			detalleIOProducto.load(); 
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlIOProducto");
			JsfUtils.update(foundComponent.getClientId());
		}

		@Override
		protected void unSelect() {
			// TODO Auto-generated method stub
			
			detalleIOProducto.load(); 
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlIOProducto");
			JsfUtils.update(foundComponent.getClientId());
			
		}
		
		
		
		
		
		
	};
	
	public DataList<MaSequence> getDetalleSecuencia() {  
		return detalleSecuencia; 
	} 
	
	
	/*
	 * Detalle secuencia 
	 * 
	 */
	private DataList<MaSequenceproduct> detalleIOProducto = new DataList<MaSequenceproduct>() { 
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<MaSequenceproduct> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null &&  getDetalleVersion() == null &&  getDetalleSecuencia() == null ) {
				return new ArrayList<MaSequenceproduct>();
			}
			return maSequenceproductFacade.findByMaSequenceId(getDetalleSecuencia().getActiveItem());     
		}
		
		public MaSequenceproduct create(){ 
			MaSequenceproduct pl = new MaSequenceproduct();
			//pl.setMaProcessplanVersionId(getDetalleVersion().getActiveItem());
			pl.setMaSequenceId(getDetalleSecuencia().getActiveItem()); 
			return pl;
		}

		protected void delete(List<MaSequenceproduct> items) {
			
			try {
				maSequenceproductFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Producto(s) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaSequenceproduct save(MaSequenceproduct item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maSequenceproductFacade.save(item); 
				
				if( item.getProductiontype() == ProductionType.PRODUCT_PRODUCTION_POSITIVE){
					getCurrentEntity().setSecondaryunit(item.getMProductId().getName());
					
					UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"itUnidadProcesoEdit");
					JsfUtils.update(foundComponent.getClientId());
				}
				
				
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Producto guardado correctamente.", null); 
			
			
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaSequenceproduct> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maSequenceproductFacade.save(items);    
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Productos guardados correctamente.", null); 
			
		}
		
	};
	
	public DataList<MaSequenceproduct> getDetalleIOProducto() {  
		return detalleIOProducto; 
	} 
	
	
	public List<MaProcess> completeProcess(String query) {

		System.out.println("query: " + query);

		List<MaProcess> all = maProcessFacade.findAll();  
		List<MaProcess> filtered = new ArrayList<MaProcess>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaProcess item = all.get(i); 
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	
	/*public List<MaMachineType> completeMachineType(String query) {

		System.out.println("query: " + query);

		List<MaMachineType> all = maMachineTypeFacade.findAll(); 
		List<MaMachineType> filtered = new ArrayList<MaMachineType>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaMachineType item = all.get(i); 
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<MaMaintOperation> completeMaintenanceOperation(String query) {

		System.out.println("query: " + query);

		List<MaMaintOperation> all = maMaintOperationFacade.findAll();  
		List<MaMaintOperation> filtered = new ArrayList<MaMaintOperation>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaMaintOperation item = all.get(i); 
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}
		return filtered; 
	}*/
	
	public CostUOM[] getListCostUOM(){
		return CostUOM.values();  
	}  
	
	public MaintType[] getListMaintType(){
		return MaintType.values();   
	}  
	
	public PeriodicityType[] getListPeriodicityType(){
		return PeriodicityType.values();    
	}
	
	public ShiftType[] getListShiftType(){
		return ShiftType.values();     
	}  
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}  
	
	public ProductionType[] getListProductionType(){
		return ProductionType.values();       
	}  
	
	public void returnLocation(SelectEvent event) {
		MProduct mProductId = (MProduct) event.getObject();
		getDetalleIOProducto().getActiveItem().setMProductId(mProductId); 

		System.out.println("returnLocation mProductId: " + mProductId);  
	}
	
	public void resetComponentCost(){
		if(getDetalleIOProducto() == null)
			return ;
		if(getDetalleIOProducto().getActiveItem() == null)
			return ;
		getDetalleIOProducto().getActiveItem().setComponentcost(null); 
	}

	public boolean isActiveComponentCost() {
		if(getDetalleIOProducto() == null)
			return false;
		if(getDetalleIOProducto().getActiveItem() == null)
			return false;
		if(getDetalleIOProducto().getActiveItem().getProductiontype() == null)
			return false;
		return getDetalleIOProducto().getActiveItem().getProductiontype() == ProductionType.PRODUCT_PRODUCTION_POSITIVE ? true : false;
	}

	public UserTaskInstanceDesc getTaskActive() {
		return taskActive;
	}

	public void setTaskActive(UserTaskInstanceDesc taskActive) {
		this.taskActive = taskActive;
	}
	
	public ProcessInstanceDesc getProcessTaskActive() {
		return processTaskActive;
	}

	public void setProcessTaskActive(ProcessInstanceDesc processTaskActive) {
		this.processTaskActive = processTaskActive;
	}

	public void completeTask() {
		
		System.out.println("completeTask process plan item: "+taskActive); 
		
		String message;
        
        try {
        	
        	
        	if( currentEntity == null ){
        		JsfUtils.messageWarning(null, "El plan de producción no se ha generado", null);
        		return;
        	}else if( currentEntity.getId() == null ){
        		JsfUtils.messageWarning(null, "El plan de producción no se ha generado", null);
        		return; 
        	}
        	
        	
        	
        	Map<String,Object> data = new HashMap<String,Object>();
        	data.put("processPlanId", currentEntity.getId() );
        	
            CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(taskActive.getTaskId() , securityUtils.getCurrentUser(),data));  
            
            userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand); 
            
            message = "Se completó la tarea " + taskActive.getName() + ".<br></br>"; 
            message = message + "Proceso: "+ processTaskActive.getProcessName() +" con código: " +processTaskActive.getId() + "." ; 
            
            JsfUtils.messageInfo(null, message, null);
            
            
            /*
             * <f:attribute name="view" value="/pages/productionMgt/transactions/task/content.xhtml"></f:attribute>
								<f:attribute name="title" value="Detalle de actividades"></f:attribute>
								<f:attribute name="bean" value="#{taskSummaryController.simpleName}"></f:attribute> 
             */
            
            
            //cierro tab
            template.removeTab();
            //abro tab de actividades            
            template.openTab("/pages/productionMgt/transactions/task/content.xhtml", "Detalle de actividades", "TaskSummaryController" , true , null);
            
            
        } catch (Exception e) {
            //message = "Unable to start the business process.";
            JsfUtils.messageError(null, e.getMessage(), null);
			
        }
        
	}

	
	

}
