package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MaPeriodicControlFacade;
import org.pharmaceutical.model.ejb.facades.MaPcTestFacade;
import org.pharmaceutical.model.entities.CLocation;
import org.pharmaceutical.model.entities.MLocator;
import org.pharmaceutical.model.entities.MaPeriodicControl;
import org.pharmaceutical.model.entities.MaPcTest;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class MaPeriodicControlController extends AbstractController<MaPeriodicControl,MaPeriodicControl> 
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaPeriodicControlFacade maPeriodicControlFacade; 
	
	@Inject
	private MaPcTestFacade maPcTestFacade; 
	

	public MaPeriodicControlController() { 
		super(MaPeriodicControlController.class);
	}
	
	@PostConstruct
	public void initialize(){ 
		filterEntity = new MaPeriodicControl();
		//filterEntity.setEstado(Estado.ACTIVO); 
		filterEntity.setIsactive(YesNo.SI);
		currentEntity = new MaPeriodicControl();
		
	}

	@Override
	public List<MaPeriodicControl> loadDataTable(MaPeriodicControl filter) {
		return maPeriodicControlFacade.find(filter);   
	} 

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaPeriodicControl();
		System.out.println("create MaPeriodicControl currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		detallePrueba.load();
		detallePrueba.init();
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaPeriodicControl save(MaPeriodicControl item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maPeriodicControlFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Tipo de Herramienta guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaPeriodicControl item) {
		// TODO Auto-generated method stub
		
		try {
			maPeriodicControlFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Tipo de Herramienta eliminada correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaPeriodicControl item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	
	
	
	/*
	 * Detalle herramienta
	 * 
	 */
	private DataList<MaPcTest> detallePrueba = new DataList<MaPcTest>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<MaPcTest> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<MaPcTest>();
			}
			return maPcTestFacade.findByMaPeriodicControlId(currentEntity);  
		}
		
		public MaPcTest create(){ 
			
			MaPcTest pl = new MaPcTest();
			pl.setMaPeriodicControlId(currentEntity);    
			return pl;
		}

		protected void delete(List<MaPcTest> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				maPcTestFacade.delete(items);  
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Prueba(s) elimanada(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected MaPcTest save(MaPcTest item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				maPcTestFacade.save(item); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Prueba guardada correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<MaPcTest> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				maPcTestFacade.save(items);   
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Pruebas guardadas correctamente.", null); 
			
		}
		
		
		
		
	};
	
	public DataList<MaPcTest> getDetallePrueba() {  
		return detallePrueba; 
	}
	
	public YesNo[] getListYesNo(){
		return YesNo.values();      
	}
	

}
