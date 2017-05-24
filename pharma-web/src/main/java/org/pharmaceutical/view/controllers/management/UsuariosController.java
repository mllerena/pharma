package org.pharmaceutical.view.controllers.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.services.RolService;
import org.pharmaceutical.model.ejb.services.UsuarioRolService;
import org.pharmaceutical.model.ejb.services.UsuarioService;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.utils.StringsUtils;
import org.pharmaceutical.view.controllers.AbstractController;
import org.pharmaceutical.view.facelets.components.DataList;
import org.pharmaceutical.view.utils.JsfUtils;

@ManagedBean
@ViewScoped
public class UsuariosController //extends AbstractController<Usuario,Usuario> 
		implements Serializable { 
	  

	/**
	 * 
	 */
	
	/*


	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	private UsuarioRolService usuarioRolService;
	
	 
	
	public UsuariosController() {
		super(UsuariosController.class);
	}
	
	@PostConstruct
	public void initialize(){
		filterEntity = new Usuario();
		filterEntity.setEstado(Estado.ACTIVO);
		currentEntity = new Usuario();
		
	}

	@Override
	public List<Usuario> loadDataTable(Usuario filter) {
		return usuarioService.find(filter);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		currentEntity = new Usuario();
		setPass1(null);
		setPass2(null);
	}

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		setPass1(getCurrentEntity().getClave());
		setPass2(getCurrentEntity().getClave());
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
	protected Usuario save(Usuario item) {
		// TODO Auto-generated method stub
		
		System.out.println("save item: "+item);
		System.out.println("save pass1: "+pass1);
		System.out.println("save pass2: "+pass2);
		
		try {
			usuarioService.save(item,pass1,pass2); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return null;
		}
		
		JsfUtils.messageInfo(null, "Usuario guardado correctamente.", null);
				
		return item;
	}
	
	@Override
	protected void delete(Usuario item) {
		// TODO Auto-generated method stub
		
		try {
			usuarioService.delete(item); 
		} catch (Exception e) {
			JsfUtils.messageError(null, e.getMessage(), null);
			return;
		}
		
		JsfUtils.messageInfo(null, "Usuario eliminado correctamente.", null);
		
	}

	

	@Override
	protected void cancel(Usuario item) {
		// TODO Auto-generated method stub
		
	}

/*

	private DataList<UsuarioRol> detalleUsuariosRoles = new DataList<UsuarioRol>() {

		@Override
		public List<UsuarioRol> loadDataList() {
			// TODO Auto-generated method stub
			if (currentEntity.getId() == null) {
				return new ArrayList<UsuarioRol>();
			}
			return usuarioRolService.findByUsuario(currentEntity);
		}
		
		public UsuarioRol create(){
			UsuarioRol ur = new UsuarioRol();
			ur.setUsuario(currentEntity);
			return ur;
		}

		protected void delete(List<UsuarioRol> items) {
			System.out.println("BORRO EN BASE: "+items);
			
			try {
				usuarioRolService.delete(items); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Rol(es) elimanado(s) correctamente.", null);
			
		}
		
		
		
		@Override
		protected UsuarioRol save(UsuarioRol item) {
			// TODO Auto-generated method stub

			//debe guardar el item
			System.out.println("save item: "+item);
			
			try {
				usuarioRolService.save(item,currentEntity); 
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
		protected void multiSave(List<UsuarioRol> items) {
			// TODO Auto-generated method stub
			System.out.println("multiSave items: "+items);
			
			try {
				usuarioRolService.save(items,currentEntity); 
			} catch (Exception e) {
				JsfUtils.messageError(null, e.getMessage(), null);
				return;
			}
			
			JsfUtils.messageInfo(null, "Roles guardados correctamente.", null);
			
		}
		
		
		
		
		
		
	};
	
	
	
	
	public DataList<UsuarioRol> getDetalleUsuariosRoles() {
		return detalleUsuariosRoles;
	}
	
	public void listenerTest(){
		System.out.println("listenerTest: "+getDetalleUsuariosRoles().getActiveItem());
	}

	public void onChangeCrearNombreUsuario() {

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

	}
	
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
	
	@Inject
	RolService rolService;
	
	public List<Rol> completeRol(String query) {

		System.out.println("query: " + query);

		List<Rol> allRol = rolService.findAll();
		List<Rol> filteredRoles = new ArrayList<Rol>();

		if (allRol != null && !allRol.isEmpty())
			for (int i = 0; i < allRol.size(); i++) {
				Rol rol = allRol.get(i);
				if (rol.getNombre().toUpperCase().contains(query.toUpperCase())) {
					filteredRoles.add(rol);
				}
			}

		return filteredRoles;
	}

	
*/	

}
