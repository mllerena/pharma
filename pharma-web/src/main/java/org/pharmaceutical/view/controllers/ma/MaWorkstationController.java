package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MaMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaMachinestationFacade;
import org.pharmaceutical.model.ejb.facades.MaProcessFacade;
import org.pharmaceutical.model.ejb.facades.MaSectionFacade;
import org.pharmaceutical.model.ejb.facades.MaWorkstationFacade;
import org.pharmaceutical.model.entities.CCountry;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.entities.MaMachinestation;
import org.pharmaceutical.model.entities.MaProcess;
import org.pharmaceutical.model.entities.MaSection;
import org.pharmaceutical.model.entities.MaWorkstation;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class MaWorkstationController extends AbstractController<MaWorkstation,MaWorkstation> 
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaWorkstationFacade maWorkstationFacade;
	
	@Inject
	private MaSectionFacade maSectionFacade; 
	
	@Inject
	private MaMachinestationFacade maMachinestationFacade;
	
	@Inject
	private MaMachineFacade maMachineFacade;
	
	@Inject
	private MaProcessFacade maProcessFacade; 
	
	
	private List<MaProcess> detalleProcesos;

	public MaWorkstationController() { 
		super(MaWorkstationController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaWorkstation();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaWorkstation();
		
	}

	@Override
	public List<MaWorkstation> loadDataTable(MaWorkstation filter) {
		return maWorkstationFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaWorkstation();
		System.out.println("create MaWorkstation currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
		detalleMaquinas.load();
		detalleMaquinas.init();
		
		if (currentEntity.getId() == null) {
			detalleProcesos = new ArrayList<MaProcess>(); 
		}
		detalleProcesos = maProcessFacade.findByCBpartnerId(currentEntity); 
		
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaWorkstation save(MaWorkstation item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maWorkstationFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Puesto de trabajo guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaWorkstation item) {
		// TODO Auto-generated method stub
		
		try {
			maWorkstationFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Puesto de trabajo eliminado correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaWorkstation item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	/*
	 * Detalle maquinas
	 * 
	 */
	private DataList<MaMachinestation> detalleMaquinas = new DataList<MaMachinestation>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MaMachinestation> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaMachinestation>();
			}
			return maMachinestationFacade.findByCBpartnerId(currentEntity); 
		}
		
		public MaMachinestation create(){
			MaMachinestation pl = new MaMachinestation();
			pl.setMaWorkstationId(currentEntity); 
			return pl;
		}

		protected void delete(List<MaMachinestation> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maMachinestationFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Máquina(s) elimanada(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaMachinestation save(MaMachinestation item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maMachinestationFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Máquina guardada correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaMachinestation> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maMachinestationFacade.save(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Máquinas guardadas correctamente.", null);
			
		}
		
		
	};
	
	public DataList<MaMachinestation> getDetalleMaquinas() {
		return detalleMaquinas;
	}
	
	
	public List<MaProcess> getDetalleProcesos() { 
		// TODO Auto-generated method stub
		return detalleProcesos;
	}
	
	
	
	
	
	
	
	/**
	 * Complete 
	 * */

	public List<MaSection> completeSections(String query) {

		System.out.println("query: " + query);

		List<MaSection> all = maSectionFacade.findAll(); 
		List<MaSection> filtered = new ArrayList<MaSection>();

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaSection item = all.get(i);
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}

		return filtered;
	}
	
	public List<MaMachine> completeMachine(String query) {

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
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}  
	

}
