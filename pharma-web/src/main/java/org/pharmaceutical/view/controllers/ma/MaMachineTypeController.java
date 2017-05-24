package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MaMachineCostFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineTypeFacade;
import org.pharmaceutical.model.ejb.facades.MaMachinestationFacade;
import org.pharmaceutical.model.ejb.facades.MaMaintOperationFacade;
import org.pharmaceutical.model.ejb.facades.MaMaintenanceFacade;
import org.pharmaceutical.model.ejb.facades.MaSectionFacade;
import org.pharmaceutical.model.entities.CCountry;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.entities.MaMachineCost;
import org.pharmaceutical.model.entities.MaMachineType;
import org.pharmaceutical.model.entities.MaMachinestation;
import org.pharmaceutical.model.entities.MaMaintOperation;
import org.pharmaceutical.model.entities.MaMaintenance;
import org.pharmaceutical.model.entities.MaSection;
import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.MaintType;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class MaMachineTypeController extends AbstractController<MaMachineType,MaMachineType> 
		implements Serializable {   
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaMachineTypeFacade maMachineTypeFacade; 
	
	@Inject
	private MaMaintenanceFacade maMaintenanceFacade; 
	
	@Inject
	private MaMaintOperationFacade maMaintOperationFacade; 
	

	public MaMachineTypeController() { 
		super(MaMachineTypeController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaMachineType();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaMachineType();
		
	}

	@Override
	public List<MaMachineType> loadDataTable(MaMachineType filter) {
		return maMachineTypeFacade.find(filter);   
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaMachineType();
		System.out.println("create MaMachineType currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
		detalleMantenimiento.load();
		detalleMantenimiento.init(); 
		
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaMachineType save(MaMachineType item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maMachineTypeFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Tipo de Máquina guardada correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaMachineType item) {
		// TODO Auto-generated method stub
		
		try {
			maMachineTypeFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Tipo de Máquina eliminada correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaMachineType item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
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
			return maMaintenanceFacade.findByMaMachineTypeId(currentEntity);   
		}
		
		public MaMaintenance create(){ 
			MaMaintenance pl = new MaMaintenance();
			//pl.setMaMachineId(currentEntity);
			pl.setMaMachineTypeId(currentEntity); 
			pl.setMaintenanceType(null); 
			pl.setExplode(YesNo.NO);
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
		
		
	};
	
	public DataList<MaMaintenance> getDetalleMantenimiento() {  
		return detalleMantenimiento; 
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
	
	public MaintType[] getListMaintType(){
		return MaintType.values();   
	}
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}  
	

}
