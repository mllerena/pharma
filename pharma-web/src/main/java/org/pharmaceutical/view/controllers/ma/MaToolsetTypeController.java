package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MaToolsetFacade;
import org.pharmaceutical.model.ejb.facades.MaToolsetTypeFacade;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MaToolset;
import org.pharmaceutical.model.entities.MaToolsetType;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class MaToolsetTypeController extends AbstractController<MaToolsetType,MaToolsetType> 
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaToolsetTypeFacade maToolsetTypeFacade; 
	
	@Inject
	private MaToolsetFacade maToolsetFacade; 
	

	public MaToolsetTypeController() { 
		super(MaToolsetTypeController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaToolsetType();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaToolsetType();
		
	}

	@Override
	public List<MaToolsetType> loadDataTable(MaToolsetType filter) {
		return maToolsetTypeFacade.find(filter);  
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaToolsetType();
		System.out.println("create MaToolsetType currentEntity: "+currentEntity);
		
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
	protected MaToolsetType save(MaToolsetType item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maToolsetTypeFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Tipo de Herramienta guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaToolsetType item) {
		// TODO Auto-generated method stub
		
		try {
			maToolsetTypeFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Tipo de Herramienta eliminada correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaToolsetType item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	
	
	/*
	 * Detalle herramienta
	 * 
	 */
	private DataList<MaToolset> detalleHerramienta = new DataList<MaToolset>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MaToolset> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaToolset>();
			}
			return maToolsetFacade.findByMaToolsetTypeId(currentEntity);  
		}
		
		public MaToolset create(){ 
			
			JsfUtils.removeManagedBean("mLocatorView"); 
			
			MaToolset pl = new MaToolset();
			pl.setMaToolsetTypeId(currentEntity); 
			pl.setDiscarded(null);   
			return pl;
		}

		protected void delete(List<MaToolset> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maToolsetFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Herramienta(s) elimanada(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaToolset save(MaToolset item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maToolsetFacade.save(item); 
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
		protected void multiSave(List<MaToolset> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maToolsetFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Herramientas guardadas correctamente.", null); 
			
		}

		@Override
		protected MaToolset edit(MaToolset item) {
			// TODO Auto-generated method stub
			JsfUtils.removeManagedBean("mLocatorView"); 
			return super.edit(item);
		}
		
		
		
		
	};
	
	public DataList<MaToolset> getDetalleHerramienta() {  
		return detalleHerramienta; 
	}
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}
	
	public void returnLocation(SelectEvent event) {
		MLocator mLocator = (MLocator) event.getObject();
		getDetalleHerramienta().getActiveItem().setMLocatorId(mLocator); 

		System.out.println("returnLocation cLocation: " + mLocator);
	}
	

}
