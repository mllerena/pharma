package org.pharmaceutical.view.controllers.ma;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MaMaintOperationFacade;
import org.pharmaceutical.model.entities.MaMaintOperation;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.utils.JsfUtils; 

@ManagedBean
@ViewScoped
public class MaMaintOperationController extends AbstractController<MaMaintOperation,MaMaintOperation>   
		implements Serializable {  
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private MaMaintOperationFacade maMaintOperationFacade;

	public MaMaintOperationController() { 
		super(MaMaintOperationController.class);
	}
	
	@PostConstruct
	public void initialize(){
		filterEntity = new MaMaintOperation();
		//filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI); 
		currentEntity = new MaMaintOperation();
		
	}

	@Override
	public List<MaMaintOperation> loadDataTable(MaMaintOperation filter) {
		return maMaintOperationFacade.find(filter); 
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new MaMaintOperation();
		System.out.println("create MaMaintOperation currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
		//detalleUsuariosRoles.load();
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		

	}
	
	@Override
	protected MaMaintOperation save(MaMaintOperation item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		
		try {
			
			maMaintOperationFacade.save(item); 
			
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Operación de mantenimiento correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(MaMaintOperation item) {
		// TODO Auto-generated method stub
		
		try {
			maMaintOperationFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Operación de mantenimiento correctamente.", null);
		
	}

	

	@Override
	protected void cancel(MaMaintOperation item) { 
		// TODO Auto-generated method stub
		//cBpartnerFacade.find(currentEntity.getId());
	}
	

}
