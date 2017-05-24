package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.pharmaceutical.model.ejb.facades.MaProcessFacade;
import org.pharmaceutical.model.ejb.facades.MaProcessplanFacade;
import org.pharmaceutical.model.ejb.facades.MaSequenceFacade;
import org.pharmaceutical.model.ejb.facades.MaWorkrequirementFacade;
import org.pharmaceutical.model.ejb.facades.MaWrphaseFacade;
import org.pharmaceutical.model.ejb.facades.MaWrphaseproductFacade;
import org.pharmaceutical.model.ejb.services.MaPackageService;
import org.pharmaceutical.model.entities.AdPinstance;
import org.pharmaceutical.model.entities.AdProcess;
import org.pharmaceutical.model.entities.MProduct;
import org.pharmaceutical.model.entities.MaProcess;
import org.pharmaceutical.model.entities.MaProcessplan;
import org.pharmaceutical.model.entities.MaSequence;
import org.pharmaceutical.model.entities.MaWorkrequirement;
import org.pharmaceutical.model.entities.MaWrphase;
import org.pharmaceutical.model.entities.MaWrphaseproduct;
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
public class MaWorkrequirementController extends
		AbstractController<MaWorkrequirement, MaWorkrequirement> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private MaWorkrequirementFacade maWorkrequirementFacade;

	@Inject
	private MaWrphaseFacade maWrphaseFacade;

	@Inject
	private MaWrphaseproductFacade maWrphaseproductFacade;

	@Inject
	private MaProcessFacade maProcessFacade;
	
	@Inject
	private MaSequenceFacade maSequenceFacade;

	@Inject
	private MaProcessplanFacade maProcessplanFacade;

	@Inject
	private MaPackageService maPackageService;

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

	public MaWorkrequirementController() {
		super(MaWorkrequirementController.class);
	}

	@PostConstruct
	public void initialize() {
		filterEntity = new MaWorkrequirement();
		// filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaWorkrequirement();

		// carga por bpm
		Tab tab = template.getTabByBean(getSimpleName());
		if (tab != null && tab.getParams() != null)
			if (tab.getParams().containsKey("taskSelected")) {

				UserTaskInstanceDesc t = (UserTaskInstanceDesc) tab.getParams()
						.get("taskSelected");
				taskActive = runtimeDataService.getTaskById(t.getTaskId());

				processTaskActive = runtimeDataService
						.getProcessInstanceById(taskActive
								.getProcessInstanceId());

				// Existe plan para esta tarea de bpm?
				MaWorkrequirement workrequirement = maWorkrequirementFacade
						.findByTaskId(taskActive.getTaskId());

				setEnabledBack(false);
				setEnabledViewFilter(false);
				setEnabledViewDetail(true);

				if (workrequirement == null) {
					create();
				} else {
					currentEntity = workrequirement;
					edit();
				}

				System.out
						.println("en constructor de process plan y se ejecuto para que alga directo en nuevo");

			}

	}

	@Override
	public List<MaWorkrequirement> loadDataTable(MaWorkrequirement filter) {
		return maWorkrequirementFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaWorkrequirement();
		if (taskActive != null) {
			currentEntity.setTaskId(taskActive.getTaskId());
		}
		System.out.println("create MaWorkrequirement currentEntity: "
				+ currentEntity);
		detalleFases.load();
		detalleFases.init();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		detalleFases.load();
		detalleFases.init();
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

	@Override
	protected MaWorkrequirement save(MaWorkrequirement item) {
		// TODO Auto-generated method stub

		System.out.println("save item: " + item);

		try {

			maWorkrequirementFacade.save(item);

		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}

		JsfUtils.messageInfo(null, "Plan producción guardada correctamente.",
				null);

		return item;
	}

	@Override
	protected void delete(MaWorkrequirement item) {
		// TODO Auto-generated method stub

		try {
			maWorkrequirementFacade.delete(item);
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}

		JsfUtils.messageInfo(null, "Plan producción eliminada correctamente.",
				null);

	}

	@Override
	protected void cancel(MaWorkrequirement item) {
		// TODO Auto-generated method stub
		// cBpartnerFacade.find(currentEntity.getId());
	}

	/*
	 * Detalle fases de fabricaciones
	 */
	private DataList<MaWrphase> detalleFases = new DataList<MaWrphase>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub

		}

		@Override
		public List<MaWrphase> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaWrphase>();
			}
			return maWrphaseFacade.findByMaWorkrequirementId(currentEntity);
		}

		public MaWrphase create() {
			MaWrphase pl = new MaWrphase();
			pl.setMaWorkrequirementId(currentEntity);
			return pl;
		}

		protected void delete(List<MaWrphase> items) {
			System.out.println("BORRO EN BASE: " + items);

			try {
				maWrphaseFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Fase(s) elimanada(s) correctamente.",
					null);

		}

		@Override
		protected MaWrphase save(MaWrphase item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				maWrphaseFacade.save(item);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}

			JsfUtils.messageInfo(null, "Fase guardada correctamente.", null);

			return item;
		}

		protected void cancel() {
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaWrphase> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				maWrphaseFacade.save(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Fases guardadas correctamente.", null);

		}

		@Override
		protected void select(List<MaWrphase> items) {
			// TODO Auto-generated method stub
			detalleIOProducto.load();
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils
					.getCurrentContext().getViewRoot(), "dlIOProductoFases");
			JsfUtils.update(foundComponent.getClientId());
			
			/*foundComponent = JsfUtils.getUIComponentOfId(JsfUtils
					.getCurrentContext().getViewRoot(), "cbWorkReqPhaseClose");
			JsfUtils.update(foundComponent.getClientId());
			*/
			
		}

		@Override
		protected void unSelect() {
			// TODO Auto-generated method stub

			detalleIOProducto.load();
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils
					.getCurrentContext().getViewRoot(), "dlIOProductoFases");
			JsfUtils.update(foundComponent.getClientId());
			
		/*	foundComponent = JsfUtils.getUIComponentOfId(JsfUtils
					.getCurrentContext().getViewRoot(), "cbWorkReqPhaseClose");
			JsfUtils.update(foundComponent.getClientId());*/

		}

	};

	public DataList<MaWrphase> getDetalleFases() {
		return detalleFases;
	}

	/*
	 * Detalle I/O product
	 */
	private DataList<MaWrphaseproduct> detalleIOProducto = new DataList<MaWrphaseproduct>() {

		@Override
		protected void initialize() {
			// TODO Auto-generated method stub

		}

		@Override
		public List<MaWrphaseproduct> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null && getDetalleFases() == null) {
				return new ArrayList<MaWrphaseproduct>();
			}
			return maWrphaseproductFacade.findByMaWrphaseId(getDetalleFases()
					.getActiveItem());
		}

		public MaWrphaseproduct create() {
			MaWrphaseproduct pl = new MaWrphaseproduct();
			pl.setMaWrphaseId(getDetalleFases().getActiveItem());
			return pl;
		}

		protected void delete(List<MaWrphaseproduct> items) {

			try {
				maWrphaseproductFacade.delete(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null,
					"Producto(s) elimanado(s) correctamente.", null);

		}

		@Override
		protected MaWrphaseproduct save(MaWrphaseproduct item) {
			// TODO Auto-generated method stub

			// debe guardar el item
			System.out.println("save item: " + item);

			try {
				maWrphaseproductFacade.save(item);
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
		protected void multiSave(List<MaWrphaseproduct> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: " + items);

			try {
				maWrphaseproductFacade.save(items);
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			JsfUtils.messageInfo(null, "Productos guardados correctamente.",
					null);

		}

	};

	public DataList<MaWrphaseproduct> getDetalleIOProducto() {
		return detalleIOProducto;
	}
	
	
	
	public List<MaSequence> completeSequence(String query) {

		System.out.println("query: " + query);

		List<MaSequence> all = maSequenceFacade.findAll();
		List<MaSequence> filtered = new ArrayList<MaSequence>();

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaSequence item = all.get(i);
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);
				}
			}
		return filtered;
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

	public List<MaProcessplan> completeProcessplan(String query) {

		System.out.println("completeProcessplan query: " + query);

		List<MaProcessplan> all = maProcessplanFacade.findAll();
		List<MaProcessplan> filtered = new ArrayList<MaProcessplan>();

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaProcessplan item = all.get(i);
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);
				}
			}
		return filtered;
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

	public void returnLocation(SelectEvent event) {
		MProduct mProductId = (MProduct) event.getObject();
		getDetalleIOProducto().getActiveItem().setMProductId(mProductId);

		System.out.println("returnLocation mProductId: " + mProductId);
	}

	public void resetComponentCost() {
		if (getDetalleIOProducto() == null)
			return;
		if (getDetalleIOProducto().getActiveItem() == null)
			return;
		getDetalleIOProducto().getActiveItem().setComponentcost(null);
	}

	public boolean isActiveComponentCost() {
		if (getDetalleIOProducto() == null)
			return false;
		if (getDetalleIOProducto().getActiveItem() == null)
			return false;
		if (getDetalleIOProducto().getActiveItem().getProductiontype() == null)
			return false;
		return getDetalleIOProducto().getActiveItem().getProductiontype() == ProductionType.PRODUCT_PRODUCTION_POSITIVE ? true
				: false;
	}

	@Inject
	private AdProcessFacade adProcessFacade;

	@Inject
	private AdPinstanceFacade adPinstanceFacade;

	@Inject
	private SecurityUtils security;

	@Resource
	private UserTransaction userTransaction;

	public void actionWorkRequirementProcess() {
		System.out.println("actionWorkRequirementProcess ");

		if (currentEntity.getMaProcessplanId() == null) {
			JsfUtils.messageError(null,
					"La orden de fabricación no se a guardado.", null);
			return;
		}

		if (currentEntity.getMaProcessplanId().getExplodephases() == YesNo.SI) {

			AdPinstance instance = new AdPinstance();

			try {

				userTransaction.begin();

				AdProcess process = adProcessFacade.find("800103");

				System.out.println("process:  " + process);

				instance.setAdProcessId(process);

				// para este caso debe ir ingresado work requirement
				instance.setRecordId(currentEntity.getId());
				instance.setAdUserId(security.getAdUser());
				instance.setIsprocessing('N');

				adPinstanceFacade.create(instance);

				userTransaction.commit();

				userTransaction.begin();

				maPackageService.workRequirementProcess(instance);

				userTransaction.commit();

			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}

			instance = adPinstanceFacade.find(instance.getId());
			
			detalleFases.load();

			if (instance.getIsprocessing().equals('N')
					&& instance.getResult().intValue() == 1) {
				JsfUtils.messageInfo(null,
						"Se explotó las fases correctamente.", null);
			} else {
				JsfUtils.messageError(null, instance.getErrormsg(), null);
			}

		} else {
			JsfUtils.messageWarning(null, "El plan de producción "
					+ currentEntity.getMaProcessplanId().getName()
					+ ", tiene desactivada la casilla de explotar fases.", null);
		}

	}

	public void actionWorkRequirementClose() {

		System.out.println("actionWorkRequirementClose ");

		if (currentEntity.getMaWorkrequirementId() == null) {
			JsfUtils.messageError(null,
					"La orden de fabricación no se ha guardado.", null);
			return;
		}

		AdPinstance instance = new AdPinstance();

		try {

			userTransaction.begin();

			AdProcess process = adProcessFacade.find("800117");

			System.out.println("process:  " + process);

			instance.setAdProcessId(process);

			// para este caso debe ir ingresado work requirement
			instance.setRecordId(currentEntity.getId());
			instance.setAdUserId(security.getAdUser());
			instance.setIsprocessing('N');

			adPinstanceFacade.create(instance);

			userTransaction.commit();

			userTransaction.begin();

			maPackageService.workRequirementClose(instance);

			userTransaction.commit();

		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}

		instance = adPinstanceFacade.find(instance.getId());

		if (instance.getIsprocessing().equals('N')
				&& instance.getResult().intValue() == 1) {
			JsfUtils.messageInfo(null, "Se cerró la Orden de Fabricación " + currentEntity.getDocumentno() +"/"+ currentEntity.getLot() +" correctamente.",
					null);
		} else {
			JsfUtils.messageError(null, instance.getErrormsg(), null);
		}

	}
	
	
	public void actionWorkReqPhaseClose() {

		System.out.println("actionWorkReqPhaseClose ");

		if (getDetalleFases() == null) 
		{
			
			JsfUtils.messageError(null,
					"No existen fases.", null);
			return;
		}
		
		if(getDetalleFases().getActiveItem() == null) {
			JsfUtils.messageError(null,
					"Debe seleccionar la fase.", null);
			return;	
		}

		AdPinstance instance = new AdPinstance();

		try {

			userTransaction.begin();

			AdProcess process = adProcessFacade.find("800118");

			System.out.println("process:  " + process);

			instance.setAdProcessId(process);

			// para este caso debe ir ingresado work requirement
			instance.setRecordId(currentEntity.getId());
			instance.setAdUserId(security.getAdUser());
			instance.setIsprocessing('N');

			adPinstanceFacade.create(instance);

			userTransaction.commit();

			userTransaction.begin();

			maPackageService.workReqPhaseClose(instance); 

			userTransaction.commit();

		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}

		instance = adPinstanceFacade.find(instance.getId());

		if (instance.getIsprocessing().equals('N')
				&& instance.getResult().intValue() == 1) {
			JsfUtils.messageInfo(null, "Se cerró la Fase " + getDetalleFases().getActiveItem().getName() +" correctamente.",
					null);
		} else {
			JsfUtils.messageError(null, instance.getErrormsg(), null);
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

	public void handlerProcessPlan(){
		
		if( getCurrentEntity().getMaProcessplanId() != null ){
			getCurrentEntity().setConversionrate(getCurrentEntity().getMaProcessplanId().getConversionrate());
			getCurrentEntity().setSecondaryunit(getCurrentEntity().getMaProcessplanId().getSecondaryunit());
			getCurrentEntity().setExplodephases(getCurrentEntity().getMaProcessplanId().getExplodephases());
		}
		
	}
	
	public void handlerSequence(){
		
		if( getDetalleFases() != null && getDetalleFases().getActiveItem() != null && getDetalleFases().getActiveItem().getMaSequenceId() != null){  
			getDetalleFases().getActiveItem().setMaProcessId(getDetalleFases().getActiveItem().getMaSequenceId().getMaProcessId()); 
		}
		
		
		
	}
	
	public void completeTask() {

		System.out.println("completeTask work requirement item: " + taskActive);

		String message;

		String flujoId = null;

		List<MaWrphaseproduct> listMaWrphaseproduct = maWrphaseproductFacade
				.findByMaWorkrequirementId(currentEntity);

		System.out.println("completeTask listMaWrphaseproduct: "
				+ listMaWrphaseproduct);

		if (listMaWrphaseproduct != null && !listMaWrphaseproduct.isEmpty()) {
			for (MaWrphaseproduct pr : listMaWrphaseproduct) {
				if (pr.getProductiontype() == ProductionType.PRODUCT_PRODUCTION_POSITIVE) {
					String id = pr.getMProductId().getMProductCategoryId()
							.getMProductCategoryId();

					if (id.equals("1")) {
						flujoId = "Tableta";
					} else if (id.equals("15")) {
						flujoId = "Inyectable";
					}
				}
			}
		}

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
			data.put("flujoId", flujoId);

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
	
	

}
