package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;
import javax.transaction.UserTransaction;

import org.jbpm.services.api.RuntimeDataService;
import org.jbpm.services.api.UserTaskService;
import org.jbpm.services.api.model.ProcessInstanceDesc;
import org.jbpm.services.api.model.UserTaskInstanceDesc;
import org.jbpm.services.task.commands.CompleteTaskCommand;
import org.jbpm.services.task.commands.CompositeCommand;
import org.pharmaceutical.bpm.utils.StartupBean;
import org.pharmaceutical.model.ejb.facades.AdPinstanceFacade;
import org.pharmaceutical.model.ejb.facades.AdProcessFacade;
import org.pharmaceutical.model.ejb.facades.CBpartnerFacade;
import org.pharmaceutical.model.ejb.facades.CSalaryCategoryFacade;
import org.pharmaceutical.model.ejb.facades.MProductionFacade;
import org.pharmaceutical.model.ejb.facades.MProductionlineFacade;
import org.pharmaceutical.model.ejb.facades.MProductionplanFacade;
import org.pharmaceutical.model.ejb.facades.MaCostcenterVersionFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaPlEmployeeFacade;
import org.pharmaceutical.model.ejb.facades.MaPlMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaToolsetFacade;
import org.pharmaceutical.model.ejb.facades.MaToolsetusedFacade;
import org.pharmaceutical.model.ejb.facades.MaWeemployeeFacade;
import org.pharmaceutical.model.ejb.facades.MaWorkrequirementFacade;
import org.pharmaceutical.model.ejb.facades.MaWrphaseFacade;
import org.pharmaceutical.model.ejb.services.MaPackageService;
import org.pharmaceutical.model.entities.AdPinstance;
import org.pharmaceutical.model.entities.AdProcess;
import org.pharmaceutical.model.entities.CBpartner;
import org.pharmaceutical.model.entities.CSalaryCategory;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MProduction;
import org.pharmaceutical.model.entities.MProductionline;
import org.pharmaceutical.model.entities.MProductionplan;
import org.pharmaceutical.model.entities.MaCostcenterVersion;
import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.entities.MaPlEmployee;
import org.pharmaceutical.model.entities.MaPlMachine;
import org.pharmaceutical.model.entities.MaToolset;
import org.pharmaceutical.model.entities.MaToolsetused;
import org.pharmaceutical.model.entities.MaWorkrequirement;
import org.pharmaceutical.model.entities.MaWrphase;
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
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class MProductionController extends
		AbstractController<MProduction, MProduction> implements 
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private MProductionFacade mProductionFacade;

	@Inject
	private MaWeemployeeFacade maWeemployeeFacade;
	
	
	@Inject 
	private MProductionplanFacade mProductionplanFacade; 
	
	
	private MProductionplan mProductionplan;
	
	@Inject 
	private MProductionlineFacade mProductionlineFacade;
	
	@Inject 
	private MaToolsetusedFacade maToolsetusedFacade;
	
	@Inject 
	private MaPlEmployeeFacade maPlEmployeeFacade;
	
	@Inject 
	private MaPlMachineFacade maPlMachineFacade; 
	
	@Inject 
	private MaToolsetFacade maToolsetFacade;
	
	@Inject 
	private CSalaryCategoryFacade cSalaryCategoryFacade;
	
	@Inject 
	private MaMachineFacade maMachineFacade;
	
	
	@Inject
	private MaWorkrequirementFacade maWorkrequirementFacade;
	
	private MaWorkrequirement maWorkrequirement;
	
	@Inject
	private MaWrphaseFacade maWrphaseFacade;
	
	@Inject
	private MaCostcenterVersionFacade maCostcenterVersionFacade; 
	

	@Inject
	private TemplateController template;

	@Inject
	private UserTaskService userTaskService;

	@Inject
	private RuntimeDataService runtimeDataService;

	private UserTaskInstanceDesc taskActive;

	private ProcessInstanceDesc processTaskActive;
	
	@Inject
	private CBpartnerFacade cBpartnerFacade;

	@Inject
	private SecurityUtils securityUtils;
	
	Map<String, Object> inputValues;
	
	private Date endTimeMax;

	public MProductionController() {
		super(MProductionController.class);
	}

	@PostConstruct
	public void initialize() {
		
		
		
		filterEntity = new MProduction();
		// filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MProduction();
		
		mProductionplan = new MProductionplan();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, 10);
		endTimeMax = cal.getTime();
		
		System.out.println("MProductionController endTimeMax: "+endTimeMax);
		

		// carga por bpm
		Tab tab = template.getTabByBean(getSimpleName());
		if (tab != null && tab.getParams() != null)
			if (tab.getParams().containsKey("taskSelected")) {

				UserTaskInstanceDesc t = (UserTaskInstanceDesc) tab.getParams()
						.get("taskSelected");
				taskActive = runtimeDataService.getTaskById(t.getTaskId());
				
				processTaskActive = runtimeDataService.getProcessInstanceById(taskActive.getProcessInstanceId());   
				
				inputValues = userTaskService.getTaskInputContentByTaskId(t.getTaskId());
				
				filterEntity.setTaskId(t.getTaskId()); 
				
				
				System.out.println("MProductionController taskActive: "+taskActive);
				System.out.println("MProductionController inputValues: "+inputValues);
				
				String workRequirementId = (String) inputValues.get("workRequirementId");
				maWorkrequirement = maWorkrequirementFacade.find(workRequirementId);
				
				buscar();
				

			}

	}

	@Override
	public List<MProduction> loadDataTable(MProduction filter) {
		return mProductionFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MProduction();
		if (taskActive != null) {
			currentEntity.setTaskId(taskActive.getTaskId());
		}
		System.out.println("create MProduction currentEntity: "
				+ currentEntity);
		
		mProductionplan = new MProductionplan();
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
		mProductionplan = mProductionplanFacade.findByMProductionId(currentEntity);
		
		if( mProductionplan != null && mProductionplan.getId() != null ){
			detalleProductoFase.load();
			detalleProductoFase.init();
			detalleHerramientaUsada.load();
			detalleHerramientaUsada.init();
			detalleCategoriaEmpleado.load();
			detalleCategoriaEmpleado.init();
			detalleMaquina.load();
			detalleMaquina.init();
		}else{
			mProductionplan = new MProductionplan();
		}
		
		
		
		if( getCurrentEntity().getMovementdate() != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(getCurrentEntity().getMovementdate() ); 
			cal.add(Calendar.HOUR_OF_DAY, 23);
			cal.add(Calendar.MINUTE, 59);
			cal.add(Calendar.SECOND, 59);
			System.out.println("ssetEndTimeMax: "+cal.getTime());
			setEndTimeMax(cal.getTime());
			
		}
		
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

	@Override
	protected MProduction save(MProduction item) {
		// TODO Auto-generated method stub

		System.out.println("save item: " + item);

		try {

			mProductionFacade.save(item);
			
			
			if( item !=null && item.getId() != null && mProductionplan.getMaWrphaseId() != null && mProductionplan.getMaCostcenterVersionId() != null){
				mProductionplan.setMProductionId(item);
				mProductionplanFacade.save(mProductionplan);
				
				detalleProductoFase.load();
				detalleProductoFase.init();
				detalleHerramientaUsada.load();
				detalleHerramientaUsada.init();
				detalleCategoriaEmpleado.load();
				detalleCategoriaEmpleado.init();
				detalleMaquina.load();
				detalleMaquina.init();
				
				UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"tvDetParteFabrica");
				System.out.println("MProduction foundComponent: "+ foundComponent );
				JsfUtils.update(foundComponent.getClientId());	
			}
			
			
			

		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}

		JsfUtils.messageInfo(null, "Parte de trabajo guardado correctamente.",
				null);

		return item;
	}

	@Override
	protected void delete(MProduction item) {
		// TODO Auto-generated method stub

		try {
			mProductionFacade.delete(item);
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}

		JsfUtils.messageInfo(null, "Parte de trabajo eliminado correctamente.", 
				null);

	}

	@Override
	protected void cancel(MProduction item) {
		// TODO Auto-generated method stub
		// cBpartnerFacade.find(currentEntity.getId());
	}
	
	/*
	 * Detalle empleados
	 
	private DataList<MaWeemployee> detalleEmpleados = new DataList<MaWeemployee>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub

		}

		@Override
		public List<MaWeemployee> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaWeemployee>();
			}
			return maWeemployeeFacade.findByMProductionId(currentEntity);
		}

		public MaWeemployee create() {
			MaWeemployee pl = new MaWeemployee();
			pl.setMProductionId(currentEntity);
			return pl;
		}

		protected void delete(List<MaWeemployee> items) {
			System.out.println("BORRO EN BASE: " + items);

			try {
				maWeemployeeFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Empleado(s) elimanado(s) correctamente.",
					null);

		}

		@Override
		protected MaWeemployee save(MaWeemployee item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				maWeemployeeFacade.save(item);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}

			JsfUtils.messageInfo(null, "Empleado guardado correctamente.", null);

			return item;
		}

		protected void cancel() {
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaWeemployee> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				maWeemployeeFacade.save(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Empleado guardados correctamente.", null); 

		}

	};

	public DataList<MaWeemployee> getDetalleEmpleados() {
		return detalleEmpleados;
	}
	*/
	
	
	/*
	 * Detalle Herramienta Usada
	 */
	private DataList<MaToolsetused> detalleHerramientaUsada = new DataList<MaToolsetused>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			setEnabledCreate(false);
		}

		@Override
		public List<MaToolsetused> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null && getmProductionplan() == null) {
				return new ArrayList<MaToolsetused>();
			}
			return maToolsetusedFacade.findByMProductionplanId(getmProductionplan()); 
		}

		public MaToolsetused create() {
			MaToolsetused pl = new MaToolsetused();
			pl.setMProductionplanId(getmProductionplan());
			return pl;
		}

		protected void delete(List<MaToolsetused> items) {

			try {
				maToolsetusedFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null,
					"Herramienta(s) usada(s) elimanada(s) correctamente.", null);

		}

		@Override
		protected MaToolsetused save(MaToolsetused item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				maToolsetusedFacade.save(item);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}

			JsfUtils.messageInfo(null, "Herramienta usada guardas correctamente.", null);

			return item;
		}

		protected void cancel() {
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaToolsetused> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				maToolsetusedFacade.save(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Herramientas usadas guardadas correctamente.",
					null);

		}

	};

	public DataList<MaToolsetused> getDetalleHerramientaUsada() {
		return detalleHerramientaUsada; 
	}
	
	
	/*
	 * Detalle I/O product
	 */
	private DataList<MProductionline> detalleProductoFase = new DataList<MProductionline>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			setEnabledCreate(false);
		}

		@Override
		public List<MProductionline> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null && getmProductionplan() == null) {
				return new ArrayList<MProductionline>();
			}
			return mProductionlineFacade.findByMProductionplanId(getmProductionplan()); 
		}

		public MProductionline create() {
			MProductionline pl = new MProductionline();
			pl.setMProductionplanId(getmProductionplan());
			return pl;
		}

		protected void delete(List<MProductionline> items) {

			try {
				mProductionlineFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null,
					"Producto(s) elimanado(s) correctamente.", null);

		}

		@Override
		protected MProductionline save(MProductionline item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				mProductionlineFacade.save(item);
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
		protected void multiSave(List<MProductionline> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				mProductionlineFacade.save(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Productos guardados correctamente.",
					null);

		}

	};

	public DataList<MProductionline> getDetalleProductoFase() {
		return detalleProductoFase; 
	}
	
	
	/*
	 * Detalle empleado categoria salarial
	 */
	private DataList<MaPlEmployee> detalleCategoriaEmpleado = new DataList<MaPlEmployee>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			setEnabledCreate(false);
		}

		@Override
		public List<MaPlEmployee> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null && getmProductionplan() == null) {
				return new ArrayList<MaPlEmployee>();
			}
			return maPlEmployeeFacade.findByMProductionplanId(getmProductionplan()); 
		}

		public MaPlEmployee create() {
			MaPlEmployee pl = new MaPlEmployee();
			pl.setMProductionplanId(getmProductionplan());
			return pl;
		}

		protected void delete(List<MaPlEmployee> items) {

			try {
				maPlEmployeeFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null,
					"Categoria Salarial/Empleado(s) elimanado(s) correctamente.", null);

		}

		@Override
		protected MaPlEmployee save(MaPlEmployee item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				maPlEmployeeFacade.save(item);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}

			JsfUtils.messageInfo(null, "Categoria Salarial/Empleado guardada correctamente.", null);

			return item;
		}

		protected void cancel() {
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaPlEmployee> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				maPlEmployeeFacade.save(items); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Categoria(s) Salarial/Empleado guardadas correctamente.",
					null);

		}

	};

	public DataList<MaPlEmployee> getDetalleCategoriaEmpleado() {
		return detalleCategoriaEmpleado; 
	}
	
	
	/*
	 * Detalle maquinaria usada
	 */
	private DataList<MaPlMachine> detalleMaquina = new DataList<MaPlMachine>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			setEnabledCreate(false);
		}

		@Override
		public List<MaPlMachine> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null && getmProductionplan() == null) {
				return new ArrayList<MaPlMachine>();
			}
			return maPlMachineFacade.findByMProductionplanId(getmProductionplan()); 
		}

		public MaPlMachine create() {
			MaPlMachine pl = new MaPlMachine();
			pl.setMProductionplanId(getmProductionplan());
			return pl;
		}

		protected void delete(List<MaPlMachine> items) {

			try {
				maPlMachineFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null,
					"Maquinaria(s) usada(s) elimanada(s) correctamente.", null);

		}

		@Override
		protected MaPlMachine save(MaPlMachine item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				maPlMachineFacade.save(item);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}

			JsfUtils.messageInfo(null, "Maquinaria usada guardada correctamente.", null);

			return item;
		}

		protected void cancel() {
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaPlMachine> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				maPlMachineFacade.save(items); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Maquinaria(s) usada(s) guardadas correctamente.",
					null);

		}

	};

	public DataList<MaPlMachine> getDetalleMaquina() {
		return detalleMaquina; 
	}
	
	public void returnLocation(SelectEvent event) {
		MLocator mLocator = (MLocator) event.getObject();
		
		getDetalleProductoFase().getActiveItem().setMLocatorId(mLocator); 

		System.out.println("returnLocation cLocation: " + mLocator);
	}
	

	public CostUOM[] getListCostUOM() {
		return CostUOM.values();
	}

	public MaintType[] getListMaintType() {
		return MaintType.values();
	}

	public PeriodicityType[] getListPeriodicityType() {
		return PeriodicityType.values();
	}

	public ShiftType[] getListShiftType() {
		return ShiftType.values();
	}

	public YesNo[] getListYesNo() {
		return YesNo.values();
	}

	public ProductionType[] getListProductionType() {
		return ProductionType.values();
	}
	
	@Inject
	private AdProcessFacade adProcessFacade;
    
    @Inject
	private AdPinstanceFacade adPinstanceFacade;
    
    @Inject
	private SecurityUtils security;
    
    @Resource
    private UserTransaction userTransaction;
    
    @Inject
	private MaPackageService maPackageService;
    
    
    
    
public void actionWorkEffortValidate() {
		
		System.out.println("actionWorkEffortValidate ");
		
		if( currentEntity.getMProductionId() == null){
			JsfUtils.messageError(null, "El parte de trabajo no ha sido guardado.",null); 
			return;
		}
		
		
			
			AdPinstance instance = new AdPinstance();
			
			try {
				
				userTransaction.begin();
				
				AdProcess process = adProcessFacade.find("800106");
	    		
	    		System.out.println("process:  "+process);
	    		
	    		
	    		instance.setAdProcessId(process);
	    		
	    		//para este caso debe ir ingresado production plan
	    		instance.setRecordId(currentEntity.getMProductionId());   
	    		instance.setAdUserId(security.getAdUser());
	    		instance.setIsprocessing('N'); 
	    		
	    		
	    		adPinstanceFacade.create(instance);
	    		
	    		userTransaction.commit();
	    		
	    		userTransaction.begin();
				
				maPackageService.workEffortValidate(instance); 
				
				userTransaction.commit();
				
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			instance = adPinstanceFacade.find(instance.getId());
			
			
			if(instance.getIsprocessing().equals('N') && instance.getResult().intValue() == 1){
				JsfUtils.messageInfo(null, "Se validó el parte de trabajo correctamente.",null);
			}else{ 
				JsfUtils.messageError(null, instance.getErrormsg() , null);  
			}
			
	}

    
	public void actionCreateStandards() {
		
		System.out.println("CreateStandards ");
		
		if( currentEntity.getMProductionId() == null && getmProductionplan() == null && getmProductionplan().getId() == null  ){
			JsfUtils.messageError(null, "El parte de trabajo o la fase no se a guardado.",null); 
			return;
		}
		
		
			
			AdPinstance instance = new AdPinstance();
			
			try {
				
				userTransaction.begin();
				
				AdProcess process = adProcessFacade.find("800105");
	    		
	    		System.out.println("process:  "+process);
	    		
	    		
	    		instance.setAdProcessId(process);
	    		
	    		//para este caso debe ir ingresado production plan
	    		instance.setRecordId(getmProductionplan().getId());   
	    		instance.setAdUserId(security.getAdUser());
	    		instance.setIsprocessing('N'); 
	    		
	    		
	    		adPinstanceFacade.create(instance);
	    		
	    		userTransaction.commit();
	    		
	    		userTransaction.begin();
				
				maPackageService.createStandards(instance);  
				
				userTransaction.commit();
				
				
				
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			instance = adPinstanceFacade.find(instance.getId());
			
			
			if(instance.getIsprocessing().equals('N') && instance.getResult().intValue() == 1){
				JsfUtils.messageInfo(null, "Se ejecutó el material usado correctamente.",null);
				detalleHerramientaUsada.load();
				detalleProductoFase.load();
				detalleCategoriaEmpleado.load();
				detalleMaquina.load();
				
				
			}else{ 
				JsfUtils.messageError(null, instance.getErrormsg() , null);  
			}
			
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
	
	public MProductionplan getmProductionplan() {
		return mProductionplan;
	}

	public void setmProductionplan(MProductionplan mProductionplan) {
		this.mProductionplan = mProductionplan;
	}

	public List<CBpartner> completeEmpleados(String query) {

		System.out.println("query: " + query);

		List<CBpartner> all = cBpartnerFacade.findAll();  
		List<CBpartner> filtered = new ArrayList<CBpartner>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				CBpartner item = all.get(i); 
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<MaWrphase> completeFases(String query) {

		System.out.println("query: " + query);
		
		System.out.println("completeFases maWorkrequirement: " + maWorkrequirement);
		
		

		List<MaWrphase> all = maWrphaseFacade.findByMaWorkrequirementId(maWorkrequirement);
		List<MaWrphase> filtered = new ArrayList<MaWrphase>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaWrphase item = all.get(i); 
				if (item.getMaProcessId().getName().toUpperCase().contains(query.toUpperCase())) { 
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<MaCostcenterVersion> completeVersionCentroCosto(String query) {

		System.out.println("query: " + query);

		List<MaCostcenterVersion> all = maCostcenterVersionFacade.findAll();
		
		List<MaCostcenterVersion> filtered = new ArrayList<MaCostcenterVersion>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaCostcenterVersion item = all.get(i); 
				if (item.getMaCostcenterId().getName().toUpperCase().contains(query.toUpperCase())) { 
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<MaToolset> completeHerramientas(String query) {

		System.out.println("query: " + query);

		List<MaToolset> all = maToolsetFacade.findAll();
		
		List<MaToolset> filtered = new ArrayList<MaToolset>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaToolset item = all.get(i);  
				if (item.getValue().toUpperCase().contains(query.toUpperCase())) { 
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<CSalaryCategory> completeCategoriasSalariales(String query) {

		System.out.println("query: " + query);

		List<CSalaryCategory> all = cSalaryCategoryFacade.findAll(); 
		
		List<CSalaryCategory> filtered = new ArrayList<CSalaryCategory>();  

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				CSalaryCategory item = all.get(i);   
				if (item.getName().toUpperCase().contains(query.toUpperCase())) { 
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<MaMachine> completeMaquinas(String query) {

		System.out.println("query: " + query);

		List<MaMachine> all = maMachineFacade.findAll();  
		
		List<MaMachine> filtered = new ArrayList<MaMachine>();  

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaMachine item = all.get(i);   
				if (item.getName().toUpperCase().contains(query.toUpperCase())) { 
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	

	public void completeTask() {

		System.out.println("completeTask work requirement item: " + taskActive);

		String message;

		try {

			if (currentEntity == null) {
				JsfUtils.messageWarning(null,
						"La orden de fabricación no se ha generado", null);
				return;
			} else if (currentEntity.getId() == null) {
				JsfUtils.messageWarning(null,
						"La orden de fabricación no se ha generado", null);
				return;
			}

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("workRequirementId", currentEntity.getId());

			CompositeCommand compositeCommand = new CompositeCommand(
					new CompleteTaskCommand(taskActive.getTaskId(),
							securityUtils.getCurrentUser(), data));

			userTaskService
					.execute(StartupBean.DEPLOYMENT_ID, compositeCommand);

			message = "Se completó la tarea " + taskActive.getName()
					+ ".<br></br>";
			message = message + "Proceso: "
					+ processTaskActive.getProcessName() + " con código: "
					+ processTaskActive.getId() + ".";

			JsfUtils.messageInfo(null, message, null);

			/*
			 * <f:attribute name="view"
			 * value="/pages/productionMgt/transactions/task/content.xhtml"
			 * ></f:attribute> <f:attribute name="title"
			 * value="Detalle de actividades"></f:attribute> <f:attribute
			 * name="bean"
			 * value="#{taskSummaryController.simpleName}"></f:attribute>
			 */

			// cierro tab
			template.removeTab();
			// abro tab de actividades
			template.openTab(
					"/pages/productionMgt/transactions/task/content.xhtml",
					"Detalle de actividades", "TaskSummaryController", true,
					null);

		} catch (Exception e) {
			// message = "Unable to start the business process.";
			JsfUtils.messageError(null, e.getMessage(), null);

		}

	}
	
	
	
	public MaWorkrequirement getMaWorkrequirement() {
		return maWorkrequirement;
	}

	public void setMaWorkrequirement(MaWorkrequirement maWorkrequirement) {
		this.maWorkrequirement = maWorkrequirement;
	}
	
	
	
	public Date getEndTimeMax() {
		return endTimeMax;
	}

	public void setEndTimeMax(Date endTimeMax) {
		this.endTimeMax = endTimeMax;
	}

	public void handlerMovementDate(){
		
		/*Date start = getCurrentEntity().getStarttime();
		System.out.println("start: "+start);
		
		
		
		if( start != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(start);
			cal.add(Calendar.HOUR_OF_DAY, 23);
			cal.add(Calendar.MINUTE, 59);
			cal.add(Calendar.SECOND, 59);
			System.out.println("start set: "+cal.getTime());
			setEndTimeMax(cal.getTime());
			
		}*/
		
		getCurrentEntity().setEndtime(null); 
		
		Date movementDate = getCurrentEntity().getMovementdate();
		System.out.println("movementDate: "+movementDate);
		
		
		getCurrentEntity().setStarttime(movementDate);
		
		
		if( movementDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(movementDate);
			cal.add(Calendar.HOUR_OF_DAY, 23);
			cal.add(Calendar.MINUTE, 59);
			cal.add(Calendar.SECOND, 59);
			System.out.println("ssetEndTimeMax: "+cal.getTime());
			setEndTimeMax(cal.getTime());
			
		}
		
		
		
		
	}

}
