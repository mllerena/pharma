package org.pharmaceutical.view.controllers.ad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.AdRoleFacade;
import org.pharmaceutical.model.ejb.facades.AdUserFacade;
import org.pharmaceutical.model.ejb.facades.AdUserRolesFacade;
import org.pharmaceutical.model.ejb.services.RolService;
import org.pharmaceutical.model.ejb.services.UsuarioRolService;
import org.pharmaceutical.model.ejb.services.UsuarioService;
import org.pharmaceutical.model.entities.AdRole;
import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.AdUserRoles;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.enums.YesNo;
import org.pharmaceutical.model.utils.StringsUtils;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class AdUsersController extends AbstractController<AdUser,AdUser> 
		implements Serializable { 
	  

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AdUserFacade adUserFacade;
	
	@Inject
	private AdUserRolesFacade adUserRolesFacade;
	
	@Inject
	private AdRoleFacade adRoleFacade;
	
	 
	
	public AdUsersController() {
		super(AdUsersController.class);
	}
	
	@PostConstruct
	public void initialize(){
		filterEntity = new AdUser();
		//filterEntity.setEstado(Estado.ACTIVO);
		filterEntity.setIsactive(YesNo.SI); 
		currentEntity = new AdUser();
		
	}

	@Override
	public List<AdUser> loadDataTable(AdUser filter) {
		return adUserFacade.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new AdUser();
		setPass1(null);
		setPass2(null);
		
		System.out.println("create aduser currentEntity: "+currentEntity);
		
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		setPass1(getCurrentEntity().getPassword());
		setPass2(getCurrentEntity().getPassword());
		detalleUsuariosRoles.load();
	}
	
	@Override
	public void back() {
		// TODO Auto-generated method stub
		setPass1(null);
		setPass2(null);
		detalleUsuariosRoles.clear();
	}
	
	@Override
	protected AdUser save(AdUser item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		System.out.println("save pass1: "+pass1);
		System.out.println("save pass2: "+pass2);
		
		try {
			adUserFacade.save(item,pass1,pass2); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Usuario guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(AdUser item) {
		// TODO Auto-generated method stub
		
		try {
			adUserFacade.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Usuario eliminado correctamente.", null);
		
	}

	

	@Override
	protected void cancel(AdUser item) {
		// TODO Auto-generated method stub
		//adUserFacade.find(currentEntity.getId());
	}



	private DataList<AdUserRoles> detalleUsuariosRoles = new DataList<AdUserRoles>() {
		
		@Override
		protected void initialize() {
			// TODO Auto-generated method stub
		}

		@Override
		public List<AdUserRoles> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<AdUserRoles>();
			}
			return adUserRolesFacade.findByAdUser(currentEntity); 
		}
		
		public AdUserRoles create(){
			AdUserRoles ur = new AdUserRoles();
			ur.setAdUserId(currentEntity);
			return ur;
		}

		protected void delete(List<AdUserRoles> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				adUserRolesFacade.delete(items); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Rol(es) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected AdUserRoles save(AdUserRoles item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				adUserRolesFacade.save(item,currentEntity); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return null;
			}
			
			JsfUtils.messageInfo(null, "Rol guardado correctamente.", null);
			
			return item;
		}

		protected void cancel() { 
			System.out.println("cancelado: ");
		}

		@Override
		protected void multiSave(List<AdUserRoles> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				adUserRolesFacade.save(items,currentEntity); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Roles guardados correctamente.", null);
			
		}
		
		
		
		
		
		
	};
	
	
	
	public DataList<AdUserRoles> getDetalleUsuariosRoles() {
		return detalleUsuariosRoles;
	}
	
	public void listenerTest(){
		System.out.println("listenerTest: "+getDetalleUsuariosRoles().getActiveItem());
	}

	/*public void onChangeCrearNombreUsuario() {

		String username = "";

		if (getCurrentEntity() != null) {
			if (getCurrentEntity().getNombre() != null
					&& !getCurrentEntity().getNombre().equals("")) {
				username = getCurrentEntity().getNombre().substring(0, 1)
						.toUpperCase();
			}
			if (getCurrentEntity().getApellido() != null
					&& !getCurrentEntity().getApellido().equals("")) {
				int maxLength = 7;
				String apellidos = StringsUtils
						.removeWhiteSpace(getCurrentEntity().getApellido());
				maxLength = apellidos.length() >= maxLength ? maxLength
						: apellidos.length();
				username += apellidos.substring(0, maxLength).toUpperCase();
			}

			getCurrentEntity().setUsuario(username);
			
			
			
			
			//verificar si existe, sin cambios
			System.out.println("getCurrentEntity().getId() : "+getCurrentEntity().getId());
			if( getCurrentEntity().getId() != null){
				
				Usuario usuarioWithNotChange = usuarioService.findById(getCurrentEntity().getId());
				
	            if (!usuarioWithNotChange.getUsuario().trim().equals(getCurrentEntity().getUsuario().trim())) {
	            	Usuario usuarioExiste = usuarioService.findByUsuario(username);
	            	if ( usuarioExiste !=  null){
	    				if (getCurrentEntity().getNombre() != null
	    						&& !getCurrentEntity().getNombre().equals("")) {
	    					
	    					username = getCurrentEntity().getNombre().substring(0, 1)
	    							.toUpperCase();
	    					int index = getCurrentEntity().getNombre().indexOf(" ");
	    					
	    					System.out.println("index : "+index+" length: "+getCurrentEntity().getNombre().length());
	    					
	    					if(index > 0 && index <= getCurrentEntity().getNombre().length()){
	    						String letraSegundoNombre = getCurrentEntity().getNombre().substring( (index+1) , (index+2) )
	    								.toUpperCase();
	    						
	    						System.out.println("letraSegundoNombre : "+letraSegundoNombre);
	    						
	    						username += letraSegundoNombre;
	    					}
	    					
	    					
	    					
	    				}
	    				if (getCurrentEntity().getApellido() != null
	    						&& !getCurrentEntity().getApellido().equals("")) {
	    					int maxLength = 6;
	    					String apellidos = StringsUtils
	    							.removeWhiteSpace(getCurrentEntity().getApellido());
	    					maxLength = apellidos.length() >= maxLength ? maxLength
	    							: apellidos.length();
	    					username += apellidos.substring(0, maxLength).toUpperCase();
	    				}
	    				
	    				getCurrentEntity().setUsuario(username);
	    				
	    			}
	            }
				
			}
			
			
			
			
			

		}

	}*/
	
	private String pass1;
	private String pass2;


	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}
	
	
	
	public List<AdRole> completeRol(String query) {

		System.out.println("query: " + query);

		List<AdRole> allRol = adRoleFacade.findAll();
		List<AdRole> filteredRoles = new ArrayList<AdRole>();

		if (allRol != null && !allRol.isEmpty())
			for (int i = 0; i < allRol.size(); i++) {
				AdRole rol = allRol.get(i);
				if (rol.getName().toUpperCase().contains(query.toUpperCase())) {
					filteredRoles.add(rol);
				}
			}

		return filteredRoles;
	}

	
	

}
