package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MaCostcenterFacade;
import org.pharmaceutical.model.ejb.facades.MaToolsetTypeFacade;
import org.pharmaceutical.model.ejb.facades.MaToolsetprocessFacade;
import org.pharmaceutical.model.ejb.facades.MaProcessFacade;
import org.pharmaceutical.model.ejb.facades.MaWorkstationFacade;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MaCostcenter;
import org.pharmaceutical.model.entities.MaMaintOperation;
import org.pharmaceutical.model.entities.MaProcess;
import org.pharmaceutical.model.entities.MaToolsetType;
import org.pharmaceutical.model.entities.MaToolsetprocess;
import org.pharmaceutical.model.entities.MaWorkstation;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class MaProcessController extends AbstractController<MaProcess,MaProcess> 
		implements Serializable {   
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaProcessFacade maProcessFacade; 
	
	@Inject
	private MaToolsetprocessFacade maToolsetprocessFacade;  
	
	@Inject
	private MaCostcenterFacade maCostcenterFacade;
	
	@Inject
	private MaWorkstationFacade maWorkstationFacade;
	
	@Inject
	private MaToolsetTypeFacade maToolsetTypeFacade;
	
	

	public MaProcessController() { 
		super(MaProcessController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaProcess();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaProcess(); 
		
	}

	@Override
	public List<MaProcess> loadDataTable(MaProcess filter) {
		return maProcessFacade.find(filter);   
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaProcess();
		System.out.println("create MaProcess currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		detalleHerramienta.load();
		detalleHerramienta.init();
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaProcess save(MaProcess item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maProcessFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Proceso guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaProcess item) {
		// TODO Auto-generated method stub
		
		try {
			maProcessFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Proceso eliminado correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaProcess item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	
	
	/*
	 * Detalle herramienta
	 * 
	 */
	private DataList<MaToolsetprocess> detalleHerramienta = new DataList<MaToolsetprocess>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MaToolsetprocess> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaToolsetprocess>();
			}
			return maToolsetprocessFacade.findByMaProcessId(currentEntity);  
		}
		
		public MaToolsetprocess create(){
			
			MaToolsetprocess pl = new MaToolsetprocess();
			pl.setMaProcessId(currentEntity);   
			
			return pl;
		}

		protected void delete(List<MaToolsetprocess> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maToolsetprocessFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Herramienta(s) elimanada(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaToolsetprocess save(MaToolsetprocess item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maToolsetprocessFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Herramienta guardada correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaToolsetprocess> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maToolsetprocessFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Herramientas guardadas correctamente.", null); 
			
		}
		
		
		
		
	};
	
	public DataList<MaToolsetprocess> getDetalleHerramienta() {     
		return detalleHerramienta; 
	}
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}
	
	public List<MaCostcenter> completeCostcenter(String query) { 

		System.out.println("query: " + query);

		List<MaCostcenter> all = maCostcenterFacade.findAll();   
		List<MaCostcenter> filtered = new ArrayList<MaCostcenter>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaCostcenter item = all.get(i);  
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<MaWorkstation> completeWorkstation(String query) { 

		System.out.println("query: " + query);

		List<MaWorkstation> all = maWorkstationFacade.findAll();    
		List<MaWorkstation> filtered = new ArrayList<MaWorkstation>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaWorkstation item = all.get(i);  
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}
		return filtered; 
	}
	
	public List<MaToolsetType> completeToolsetType(String query) { 

		System.out.println("query: " + query);

		List<MaToolsetType> all = maToolsetTypeFacade.findAll();    
		List<MaToolsetType> filtered = new ArrayList<MaToolsetType>(); 

		if (all != null && !all.isEmpty())
			for (int i = 0; i < all.size(); i++) {
				MaToolsetType item = all.get(i);  
				if (item.getName().toUpperCase().contains(query.toUpperCase())) {
					filtered.add(item);  
				}
			}
		return filtered; 
	}

}
