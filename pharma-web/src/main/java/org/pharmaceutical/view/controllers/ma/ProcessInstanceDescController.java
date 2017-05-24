package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jbpm.services.api.ProcessService;
import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.model.ProcessInstanceDesc;
import org.jbpm.services.api.model.UserTaskInstanceDesc;
import org.kie.internal.query.QueryContext;
import org.pharmaceutical.bpm.entities.ProcessInstanceDescFilter;
import org.pharmaceutical.bpm.utils.StartupBean;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.controllers.TemplateController;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class ProcessInstanceDescController extends AbstractController<ProcessInstanceDescFilter,ProcessInstanceDesc> 
implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
    ProcessService processService;
	
	@Inject
    private RuntimeDataService runtimeDataService;

	public ProcessInstanceDescController() {
		super(ProcessInstanceDescController.class);  
		// TODO Auto-generated constructor stub
	}
	

	@PostConstruct
	public void initialize(){ 
		filterEntity = new ProcessInstanceDescFilter();
		//filterEntity.setEstado(Estado.ACTIVO); 
		
		//filterEntity.setIsactive(YesNo.SI);
		
	}

	@Override
	public List<ProcessInstanceDesc> loadDataTable(ProcessInstanceDescFilter filter) {
		
		List<ProcessInstanceDesc> items = new ArrayList<ProcessInstanceDesc>(); 
		
		Collection<ProcessInstanceDesc> processInstances =  runtimeDataService.getProcessInstances(new QueryContext(0, 100, "status", true));
		
		items.addAll(processInstances);
		
		return items;   
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
		
		System.out.println("edit ProcessInstanceDesc currentEntity: "+currentEntity);
		
		System.out.println("currentEntity.getActiveTasks: "+currentEntity.getActiveTasks());
		
		currentEntity.getActiveTasks(); 
		
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected void generate(ProcessInstanceDesc item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		String message;
        long processInstanceId = -1;
        
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            //params.put("recipient", recipient);
            
            processInstanceId = processService.startProcess(StartupBean.DEPLOYMENT_ID,
                    "org.pharmaceutical.bpm.ProductProduction", params); 
            
            
            ProcessInstanceDesc processInstance = runtimeDataService.getProcessInstanceById(processInstanceId);
            
            
            currentEntity = processInstance;  
            
            System.out.println("currentEntity.getActiveTasks: "+currentEntity.getActiveTasks());
            
            message = "Instancia de proceso: "+ processInstance.getProcessName() +" con código: " + processInstanceId + " iniciado satisfactoriamente." ;
            
            JsfUtils.messageInfo(null, message, null);
            
        } catch (Exception e) {
            //message = "Unable to start the business process.";
            JsfUtils.messageError(null, e.getMessage(), null);
			
        }
		
	}
	
	@Override
	protected void delete(ProcessInstanceDesc item) {
		// TODO Auto-generated method stub
		
		/*try {
			ProcessInstanceDescFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Proceso eliminado correctamente.", null);*/
		
	}

	

	@Override
	protected void cancel(ProcessInstanceDesc item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	
	@Inject
	private TemplateController template;
	
	public void startTask(UserTaskInstanceDesc task) {
		
		System.out.println("startTask task: "+task);
		
		
		/*try {
			template.openTab("/pages/productionMgt/setup/processPlan/content.xhtml", "Plan producción", "MaProcessplanController");
			
			System.out.println("se debio ejecutar el tab");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
	}

}
