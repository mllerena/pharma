package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.jbpm.services.api.model.ProcessInstanceDesc;
import org.jbpm.services.api.model.UserTaskInstanceDesc;
import org.jbpm.services.task.commands.ClaimTaskCommand;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.jbpm.services.task.commands.ReleaseTaskCommand;
import org.jbpm.services.task.commands.StartTaskCommand;
import org.kie.api.task.model.TaskSummary;
import org.pharmaceutical.bpm.entities.UserTaskInstanceDescFilter;
import org.pharmaceutical.bpm.utils.StartupBean;
import org.pharmaceutical.model.utils.SecurityUtils;
import org.pharmaceutical.view.beans.Tab;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.controllers.TemplateController;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class TaskSummaryController extends AbstractController<UserTaskInstanceDescFilter,TaskSummary> 
implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
    private UserTaskService userTaskService; 
	
	@Inject
    private RuntimeDataService runtimeDataService;
	
	@Inject 
	private SecurityUtils securityUtils;
	
	private UserTaskInstanceDesc taskSelected;
	
	private ProcessInstanceDesc processTaskSelected;
	
	Map<String, Object> inputValues;
	Map<String, Object> outputValues;

	public TaskSummaryController() {
		super(TaskSummaryController.class);  
	} 
	

	@PostConstruct
	public void initialize(){ 
		
		filterEntity = new  UserTaskInstanceDescFilter();
		//filterEntity.setEstado(Estado.ACTIVO); 
		
		//filterEntity.setIsactive(YesNo.SI);
		
		taskSelected = new UserTaskInstanceDescFilter(); 
		
		
		/*
		 * indica las opciones de pantalla segun el id de la tarea
		 * */
		taskMenu = new HashMap<String,Tab>();
		Tab t = new Tab(null,"Plan producción", "/pages/productionMgt/setup/processPlan/content.xhtml", "MaProcessplanController",true,null);
		taskMenu.put("DefinirPlanProduccion", t); 
		
		t = new Tab(null,"Orden de fabricación", "/pages/productionMgt/transactions/workRequirement/content.xhtml", "MaWorkrequirementController",true,null);
		taskMenu.put("IngresarOrdenesFabricacion", t);
		
		t = new Tab(null,"Parte de trabajo", "/pages/productionMgt/transactions/workEffort/content.xhtml", "MProductionController",true,null);
		taskMenu.put("ProcesarEsfuerzoTrabajo", t);  
		
		
		
		
		
		
		
		buscar();
		
	}

	@Override
	public List<TaskSummary> loadDataTable(UserTaskInstanceDescFilter filter) {
		
		return runtimeDataService.getTasksAssignedAsPotentialOwner(securityUtils.getCurrentUser(), null);   
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		//currentEntity = new ProcessInstanceDesc();
		System.out.println("create ProcessInstanceDesc currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
		taskSelected = runtimeDataService.getTaskById(currentEntity.getId());
		processTaskSelected = runtimeDataService.getProcessInstanceById(taskSelected.getProcessInstanceId()); 
		
		inputValues = userTaskService.getTaskInputContentByTaskId(currentEntity.getId());
		outputValues = userTaskService.getTaskOutputContentByTaskId(currentEntity.getId()); 
		
		
		System.out.println("inputValues: "+inputValues);
		
		System.out.println("outputValues: "+outputValues); 
		
		
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected TaskSummary save(TaskSummary item) { 
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		
				 
		return item;
	}
	
	@Override
	protected void delete(TaskSummary item) {
		// TODO Auto-generated method stub
		
		/*try {
			ProcessInstanceDescFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Proceso eliminado correctamente.", null);*/
		
	}
	
	
	public void claimTask() {
		
		System.out.println("claimTask item: "+currentEntity); 
		
		String message;
        
        try {
        	
            CompositeCommand compositeCommand = new CompositeCommand(new ClaimTaskCommand(currentEntity.getId(), securityUtils.getCurrentUser())); 
            
            userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
            
            message = "Se tomo la tarea " + currentEntity.getName() + ".<br></br>";
            message = message + "Proceso: "+ processTaskSelected.getProcessName() +" con código: " +processTaskSelected.getId() + "." ; 
            
            JsfUtils.messageInfo(null, message, null);
            
            taskSelected = runtimeDataService.getTaskById(currentEntity.getId());
            
            System.out.println("claimTask taskSelected after process: "+taskSelected.getStatus()); 
            
        } catch (Exception e) {
            //message = "Unable to start the business process.";
            JsfUtils.messageError(null, e.getMessage(), null);
			
        }
		
	}
	
	public void releaseTask() {
		
		System.out.println("releaseTask item: "+currentEntity);  
		
		String message;
        
        try {
        	
            CompositeCommand compositeCommand = new CompositeCommand(new ReleaseTaskCommand(currentEntity.getId(), securityUtils.getCurrentUser())); 
            
            userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
            
            message = "Se liberó la tarea " + currentEntity.getName() + ".<br></br>"; 
            message = message +"Proceso: "+ processTaskSelected.getProcessName() +" con código: " +processTaskSelected.getId() + "." ; 
            
            JsfUtils.messageInfo(null, message, null);
            
            taskSelected = runtimeDataService.getTaskById(currentEntity.getId());
            
        } catch (Exception e) {
            //message = "Unable to start the business process.";
            JsfUtils.messageError(null, e.getMessage(), null);
			
        }
		
	}
	
	public void startTask() { 
		// TODO Auto-generated method stub
					
		//proceso de iniciar tarea
		
		System.out.println("startTask item: "+currentEntity); 
		
		String message;
        
        try {
        	
            CompositeCommand compositeCommand = new CompositeCommand(new StartTaskCommand(currentEntity.getId(), securityUtils.getCurrentUser())); 
            
            userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
            
            message = "Se inicio la tarea " + currentEntity.getName() + ".<br></br>";
            message = message +"Proceso: "+ processTaskSelected.getProcessName() +" con código: " +processTaskSelected.getId() + "." ; 
            
            JsfUtils.messageInfo(null, message, null);
            
            taskSelected = runtimeDataService.getTaskById(currentEntity.getId());
            
        } catch (Exception e) {
            //message = "Unable to start the business process.";
            JsfUtils.messageError(null, e.getMessage(), null);
			
        }
		
		
	}
	
	public void completeTask() {
		
		System.out.println("completeTask item: "+currentEntity); 
		
		String message;
        
        try {
        	
        	Map<String,Object> data = new HashMap<String,Object>();
        	
            CompositeCommand compositeCommand = new CompositeCommand(new CompleteTaskCommand(currentEntity.getId(), securityUtils.getCurrentUser(),data));  
            
            userTaskService.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);
            
            message = "Se completó la tarea " + currentEntity.getName() + ".<br></br>";
            message = message +"Proceso: "+ processTaskSelected.getProcessName() +" con código: " +processTaskSelected.getId() + "." ; 
            
            JsfUtils.messageInfo(null, message, null);
            
            taskSelected = runtimeDataService.getTaskById(currentEntity.getId());
            
        } catch (Exception e) {
            //message = "Unable to start the business process.";
            JsfUtils.messageError(null, e.getMessage(), null);
			
        }
        
	}


	@Override
	protected void cancel(TaskSummary item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}


	public UserTaskInstanceDesc getTaskSelected() {
		return taskSelected;
	}


	public void setTaskSelected(UserTaskInstanceDesc taskSelected) {
		this.taskSelected = taskSelected;
	}


	public ProcessInstanceDesc getProcessTaskSelected() {
		return processTaskSelected;
	}


	public void setProcessTaskSelected(ProcessInstanceDesc processTaskSelected) {
		this.processTaskSelected = processTaskSelected;
	}
	
	public String getNameProcessInstance(Long processInstanceId){
		ProcessInstanceDesc pr =  runtimeDataService.getProcessInstanceById(processInstanceId);
		return pr.getProcessName();
	}
	
	
	@Inject 
	private TemplateController template;
	
	private Map<String,Tab> taskMenu;
	
	public void startTaskOpenTab() {
		
		System.out.println("startTaskOpenTab taskSelected: "+taskSelected);
 
		/*
		 * obtiene la opcion de pantalla segun el id de la tarea
		 * */
		String taskName = (String) inputValues.get("TaskName");
		
		String groupId = (String) inputValues.get("GroupId");
		
		Tab tabToOpen = null;
		
		if( !groupId.equals("Operador")){
			tabToOpen = taskMenu.get(taskName);
		}else{
			tabToOpen = new Tab(null,"Parte trabajo", "/pages/productionMgt/transactions/workEffort/content.xhtml", "MProductionController",true,null);
		}
		
		if ( tabToOpen != null){
			try {
				
				
				if( taskSelected.getStatus().equals("Reserved") ){
					startTask();
				}
				
				
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("taskSelected", taskSelected);	
				
				template.removeTab();
				
				template.openTab(tabToOpen.getView(), tabToOpen.getTitle(), tabToOpen.getBean(),tabToOpen.isClosable(),params);      
				
				System.out.println("se debio ejecutar el tab");
				
				JsfUtils.update("tvTabs"); 
				
				
				
				//remove(index) 
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	
	}
	
	public String descripcionEstado(String value){
		
		
		if( value.equals("Ready") ){
			return "Lista";
		}else if( value.equals("Reserved") ){
			return "Reservada";
		}if( value.equals("InProgress") ){
			return "En progreso";
		}
		
		return "";
	}
	

}
