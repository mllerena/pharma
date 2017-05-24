package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.CSalaryCategoryFacade;
import org.pharmaceutical.model.ejb.facades.MaCostcenterEmployeeFacade;
import org.pharmaceutical.model.ejb.facades.MaCostcenterFacade;
import org.pharmaceutical.model.ejb.facades.MaCostcenterMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaCostcenterVersionFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineFacade;
import org.pharmaceutical.model.entities.CSalaryCategory;
import org.pharmaceutical.model.entities.MaCostcenter;
import org.pharmaceutical.model.entities.MaCostcenterEmployee;
import org.pharmaceutical.model.entities.MaCostcenterMachine;
import org.pharmaceutical.model.entities.MaCostcenterVersion;
import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.entities.MaMaintenance;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.MaintType;
import org.pharmaceutical.model.enums.PeriodicityType;
import org.pharmaceutical.model.enums.ShiftType;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped 
public class MaCostcenterController extends AbstractController<MaCostcenter,MaCostcenter> 
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaCostcenterFacade maCostcenterFacade;
	
	@Inject
	private MaCostcenterVersionFacade maCostcenterVersionFacade;
	
	@Inject
	private MaCostcenterEmployeeFacade maCostcenterEmployeeFacade;
	
	@Inject
	private MaCostcenterMachineFacade maCostcenterMachineFacade;
	

	public MaCostcenterController() { 
		super(MaCostcenterController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaCostcenter();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaCostcenter();
		System.out.println("initialize centro de costos" );
	}

	@Override
	public List<MaCostcenter> loadDataTable(MaCostcenter filter) {
		return maCostcenterFacade.find(filter);  
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaCostcenter();
		currentEntity.setCalculated(YesNo.NO);
		currentEntity.setBydefault(YesNo.NO); 
		System.out.println("create MaCostcenter currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		detalleCentroCostoVersion.load();
		detalleCentroCostoVersion.init();
		
		detalleEmpleado.load();
		detalleEmpleado.init();
		
		
		detalleMaquina.load();
		detalleMaquina.init();
		
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaCostcenter save(MaCostcenter item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maCostcenterFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Centro de costos guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaCostcenter item) {
		// TODO Auto-generated method stub
		
		try {
			maCostcenterFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Centro de costos eliminado correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaCostcenter item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	
	
	/*
	 * Detalle version costo
	 * 
	 */
	private DataList<MaCostcenterVersion> detalleCentroCostoVersion = new DataList<MaCostcenterVersion>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MaCostcenterVersion> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaCostcenterVersion>();
			}
			return maCostcenterVersionFacade.findByMaCostcenterId(currentEntity);  
		}
		
		public MaCostcenterVersion create(){ 
			MaCostcenterVersion pl = new MaCostcenterVersion();
			pl.setMaCostcenterId(currentEntity); 
			pl.setCostuom(null); 
			return pl;
		}

		protected void delete(List<MaCostcenterVersion> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maCostcenterVersionFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Versión(s) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaCostcenterVersion save(MaCostcenterVersion item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maCostcenterVersionFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Versión guardada correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaCostcenterVersion> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maCostcenterVersionFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Versiónes guardadas correctamente.", null); 
			
		}
		
		@Override
		protected void select(List<MaCostcenterVersion> items) {
			// TODO Auto-generated method stub
			detalleEmpleado.load();
			detalleMaquina.load();
			
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlCatSalarialVer");
			JsfUtils.update(foundComponent.getClientId());
			
			foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlMachineVersion");
			JsfUtils.update(foundComponent.getClientId());
			
		}

		@Override
		protected void unSelect() {
			// TODO Auto-generated method stub
			
			detalleEmpleado.load();
			detalleMaquina.load(); 
			
			UIComponent foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlCatSalarialVer");
			JsfUtils.update(foundComponent.getClientId());
			
			foundComponent = JsfUtils.getUIComponentOfId(JsfUtils.getCurrentContext().getViewRoot(),"dlMachineVersion");
			JsfUtils.update(foundComponent.getClientId());
			
		}
		
		
		
	};
	
	public DataList<MaCostcenterVersion> getDetalleCentroCostoVersion() {  
		return detalleCentroCostoVersion;
	} 
	
	
	/*
	 * Detalle empleado
	 * 
	 */
	private DataList<MaCostcenterEmployee> detalleEmpleado = new DataList<MaCostcenterEmployee>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MaCostcenterEmployee> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null && getDetalleCentroCostoVersion().getActiveItem() == null) {
				return new ArrayList<MaCostcenterEmployee>();
			}
			return maCostcenterEmployeeFacade.findByMaCostcenterVersionId(getDetalleCentroCostoVersion().getActiveItem())  ;
		}
		
		public MaCostcenterEmployee create(){ 
			MaCostcenterEmployee pl = new MaCostcenterEmployee();
			pl.setMaCostcenterVersionId(getDetalleCentroCostoVersion().getActiveItem());
			pl.setCostuom(null); 
			return pl;
		}

		protected void delete(List<MaCostcenterEmployee> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maCostcenterEmployeeFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Empleado(s) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaCostcenterEmployee save(MaCostcenterEmployee item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maCostcenterEmployeeFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Empleado guardada correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaCostcenterEmployee> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maCostcenterEmployeeFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Empledos guardados correctamente.", null); 
			
		}
		
		
	};
	
	public DataList<MaCostcenterEmployee> getDetalleEmpleado() {  
		return detalleEmpleado; 
	}
	
	
	/*
	 * Detalle maquina
	 * 
	 */
	private DataList<MaCostcenterMachine> detalleMaquina = new DataList<MaCostcenterMachine>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MaCostcenterMachine> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null && getDetalleCentroCostoVersion().getActiveItem() == null) {
				return new ArrayList<MaCostcenterMachine>();
			}
			return maCostcenterMachineFacade.findByMaCostcenterVersionId(getDetalleCentroCostoVersion().getActiveItem())  ;
		}
		
		public MaCostcenterMachine create(){ 
			MaCostcenterMachine pl = new MaCostcenterMachine();
			pl.setMaCostcenterVersionId(getDetalleCentroCostoVersion().getActiveItem());
			return pl;
		}

		protected void delete(List<MaCostcenterMachine> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maCostcenterMachineFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Empleado(s) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaCostcenterMachine save(MaCostcenterMachine item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maCostcenterMachineFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Empleado guardada correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaCostcenterMachine> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maCostcenterMachineFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Empledos guardados correctamente.", null); 
			
		}
		
		
	};
	
	public DataList<MaCostcenterMachine> getDetalleMaquina() {  
		return detalleMaquina; 
	} 
	
	@Inject 
	private CSalaryCategoryFacade cSalaryCategoryFacade;
	
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
	
	@Inject 
	private MaMachineFacade maMachineFacade;
	
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
	

}
