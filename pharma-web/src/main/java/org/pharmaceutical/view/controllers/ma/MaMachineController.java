package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

import org.drools.core.reteoo.compiled.SetNodeReferenceHandler;
import org.pharmaceutical.model.ejb.facades.MaMachineCostFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineTypeFacade;
import org.pharmaceutical.model.ejb.facades.MaMaintOperationFacade;
import org.pharmaceutical.model.ejb.facades.MaMaintPeriodicityFacade;
import org.pharmaceutical.model.ejb.facades.MaMaintenanceFacade;
import org.pharmaceutical.model.entities.MaMachine; 
import org.pharmaceutical.model.entities.MaMachineCost;
import org.pharmaceutical.model.entities.MaMachineType;
import org.pharmaceutical.model.entities.MaMaintOperation;
import org.pharmaceutical.model.entities.MaMaintPeriodicity;
import org.pharmaceutical.model.entities.MaMaintenance;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.MaintType;
import org.pharmaceutical.model.enums.PeriodicityType;
import org.pharmaceutical.model.enums.ShiftType;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.component.dialog.Dialog;

@ManagedBean
@ViewScoped
public class MaMachineController extends AbstractController<MaMachine,MaMachine> 
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaMachineFacade maMachineFacade;
	
	@Inject
	private MaMachineTypeFacade maMachineTypeFacade; 
	
	
	@Inject
	private MaMachineCostFacade maMachineCostFacade;
	
	@Inject
	private MaMaintenanceFacade maMaintenanceFacade;
	
	@Inject
	private MaMaintOperationFacade maMaintOperationFacade;
	
	@Inject
	private MaMaintPeriodicityFacade maMaintPeriodicityFacade;

	public MaMachineController() { 
		super(MaMachineController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaMachine();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI); 
		currentEntity = new MaMachine();
		
	}

	@Override
	public List<MaMachine> loadDataTable(MaMachine filter) {
		return maMachineFacade.find(filter);  
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaMachine();
		System.out.println("create MaMachine currentEntity: "+currentEntity);
		detalleCostoMaquina.clear();
		detalleCostoMaquina.init();
		detalleMantenimiento.clear(); 
		detalleMantenimiento.init();
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		detalleCostoMaquina.load();
		detalleCostoMaquina.init();
		detalleMantenimiento.load();
		detalleMantenimiento.init();
		
		
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaMachine save(MaMachine item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maMachineFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Máquina guardada correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaMachine item) {
		// TODO Auto-generated method stub
		
		try {
			maMachineFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Máquina eliminada correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaMachine item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	
	
	/*
	 * Detalle costo maquina
	 * 
	 */
	private DataList<MaMachineCost> detalleCostoMaquina = new DataList<MaMachineCost>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<MaMachineCost> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaMachineCost>();
			}
			return maMachineCostFacade.findByMaMachineId(currentEntity);  
		}
		
		public MaMachineCost create(){ 
			MaMachineCost pl = new MaMachineCost();
			pl.setMaMachineId(currentEntity); 
			pl.setCostuom(null); 
			return pl;
		}

		protected void delete(List<MaMachineCost> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maMachineCostFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Costo(s) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaMachineCost save(MaMachineCost item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maMachineCostFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Costo guardado correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaMachineCost> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maMachineCostFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Costos guardados correctamente.", null); 
			
		}

		
		
		
	};
	
	public DataList<MaMachineCost> getDetalleCostoMaquina() { 
		return detalleCostoMaquina;
	} 
	
	
	/*
	 * Detalle MANTENIMIENTO 
	 * 
	 */
	private DataList<MaMaintenance> detalleMantenimiento = new DataList<MaMaintenance>() { 
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<MaMaintenance> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaMaintenance>();
			}
			return maMaintenanceFacade.findByMaMachineId(currentEntity);  
		}
		
		public MaMaintenance create(){ 
			MaMaintenance pl = new MaMaintenance();
			pl.setMaMachineId(currentEntity); 
			pl.setMaintenanceType(null); 
			return pl;
		}

		protected void delete(List<MaMaintenance> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maMaintenanceFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Mantenimiento(s) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaMaintenance save(MaMaintenance item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maMaintenanceFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Mantenimiento guardado correctamente.", null); 
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaMaintenance> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maMaintenanceFacade.save(items);    
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Mantenimientos guardados correctamente.", null); 
			
		}

		@Override
		protected void process(List<MaMaintenance> items) {
			// TODO Auto-generated method stub
			detallePeriodicidad.load(); 
			System.out.println("detalle process cantidad: "+detallePeriodicidad.getRowCountTotal());
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlPeriodicidad");
			System.out.println("foundComponent comp: "+ foundComponent );
			System.out.println("component found "+foundComponent.getId()+" client: "+foundComponent.getClientId());
			JsfUtils.update(foundComponent.getClientId());
			
		}

		@Override
		protected void select(List<MaMaintenance> items) {
			// TODO Auto-generated method stub
			detallePeriodicidad.load(); 
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlPeriodicidad");
			JsfUtils.update(foundComponent.getClientId());
		}

		@Override
		protected void unSelect() {
			// TODO Auto-generated method stub
			
			detallePeriodicidad.load(); 
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlPeriodicidad");
			JsfUtils.update(foundComponent.getClientId());
			
		}
		
		
		
		
		
		
	};
	
	public DataList<MaMaintenance> getDetalleMantenimiento() {  
		return detalleMantenimiento; 
	} 
	
	
	/*
	 * Detalle periodicidad 
	 * 
	 */ 
	private DataList<MaMaintPeriodicity> detallePeriodicidad = new DataList<MaMaintPeriodicity>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
			//setEnabledCreate(false);
		}

		@Override
		public List<MaMaintPeriodicity> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaMaintPeriodicity>(); 
			}
			return maMaintPeriodicityFacade.findByMaMaintenanceId(getDetalleMantenimiento().getActiveItem());   
		}
		
		public MaMaintPeriodicity create(){ 
			MaMaintPeriodicity pl = new MaMaintPeriodicity();
			pl.setMaMaintenanceId(getDetalleMantenimiento().getActiveItem()); 
			pl.setExcludeweekend(YesNo.NO); 
			pl.setPeriodicityType(null);
			pl.setShift(null); 
			return pl;
		}

		protected void delete(List<MaMaintPeriodicity> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maMaintPeriodicityFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Periodicidad(es) elimanada(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaMaintPeriodicity save(MaMaintPeriodicity item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maMaintPeriodicityFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Periodicidad guardado correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaMaintPeriodicity> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maMaintPeriodicityFacade.save(items);    
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Periodicidades guardadas correctamente.", null); 
			
		}		
		
		
	};
	
	public DataList<MaMaintPeriodicity> getDetallePeriodicidad() {  
		return detallePeriodicidad; 
	} 
	
	
	
	public List<MaMachineType> completeMachineType(String query) {

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
	}
	
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

}
