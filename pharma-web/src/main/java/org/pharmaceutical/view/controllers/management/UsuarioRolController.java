package org.pharmaceutical.view.controllers.management;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.UserTransaction;

import org.omnifaces.cdi.ViewScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.model.DualListModel;
import org.pharmaceutical.model.ejb.facades.UsuarioFacade;
import org.pharmaceutical.model.ejb.services.RolService;
import org.pharmaceutical.model.ejb.services.UsuarioRolService;
import org.pharmaceutical.model.ejb.services.UsuarioService;
import org.pharmaceutical.model.entities.AbstractEntity;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol;
import org.pharmaceutical.model.enums.Estado;
import org.pharmaceutical.model.utils.StringsUtils; 
import org.pharmaceutical.view.facelets.components.MasterDetailController;
import org.pharmaceutical.view.utils.JsfUtils;

@Named
@ViewScoped
public class UsuarioRolController //extends MasterDetailController<UsuarioRol>
		implements Serializable { 
	/*

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	public static final Logger LOGGER = Logger
			.getLogger(UsuarioRolController.class.getName());

	@Inject
	UsuarioRolService usuarioRolService;

	@Inject
	RolService rolService;

	@Resource
	UserTransaction u;

	public UsuarioRolController() {
		super(UsuarioRol.class);
		// TODO Auto-generated constructor stub
	}

	// =======================================================
	// INICIALIZAICON DE LAS VAARIABLES
	// =======================================================
	@PostConstruct
	public void inicialize() {

		System.out.println("inicialize UsuarioRolMgtController");

		setEnabledRefresh(false);
		setEnabledCreate(false);

		setSelectedEntityEdit(new UsuarioRol());

		// setList(usuarioService.findByEstado());

	}

	public void cancel() {

		System.out.println("back");

		setEnabledCreate(true);
		setEnabledSave(false);
		setEnabledDelete(false);
		setEnabledCancel(false);

		reset();

	}

	public void loadList(Object... parametros) {
		// TODO Auto-generated method stub

		Usuario selectedEntityLinked = (Usuario) parametros[0];

		System.out
				.println("Estoy en UsuarioRolMgtController, selectedEntityLinked: "
						+ selectedEntityLinked);

		setList(usuarioRolService.findByUsuario(selectedEntityLinked));

		// this.linked = selectedEntityLinked;

		setParametrosLoadList(parametros);

		System.out.println("list UsuarioRolMgtController: " + getList());

		setEnabledCreate(true);
		setEnabledRefresh(true);

	}

	public void reset() {
		// TODO Auto-generated method stub

		System.out.println("reset: ");

		setSelectedEntityEdit(new UsuarioRol());

		Usuario selectedEntityLinked = (Usuario) getParametrosLoadList()[0];

		if (selectedEntityLinked != null)
			setList(usuarioRolService.findByUsuario(selectedEntityLinked));

		System.out.println("reset : getlist: " + getList());

	}

	public boolean validate() {
		// TODO Auto-generated method stub
		Boolean esValido = true;

		FacesContext context = FacesContext.getCurrentInstance();

		
		 * System.out.println("pass1: " + pass1 + " - pass2: " + pass2);
		 * 
		 * // si se escribio nuevo pass: if (!StringsUtils.isEmptyTrim(pass1) ||
		 * !StringsUtils.isEmptyTrim(pass2)) { // validar pass1 if
		 * (StringsUtils.isEmptyTrim(pass1)) { context.addMessage(null, new
		 * FacesMessage( FacesMessage.SEVERITY_ERROR, "Contrase�a vac�a.",
		 * null)); esValido = false; } // validar pass2 if
		 * (!StringsUtils.eqTrim_NotNullOrEmpty(pass1, pass2)) {
		 * context.addMessage(null, new FacesMessage(
		 * FacesMessage.SEVERITY_ERROR, "Contrase�a no concuerda.", null));
		 * esValido = false; } }
		 

		return esValido;

	}

	public void save() {

		System.out.println("save : " + getClass().getName());

		try {

			u.begin();

			if (!validate()) {
				return;
			}
			
			Usuario selectedEntityLinked = (Usuario) getParametrosLoadList()[0];
			
			if( getSelectedEntityEdit().getId() == null ){
				getSelectedEntityEdit().setUsuario(selectedEntityLinked);
				getSelectedEntityEdit().setEstado(Estado.ACTIVO);
				usuarioRolService.almacenar(getSelectedEntityEdit());
			}else{
				usuarioRolService.actualizar(getSelectedEntityEdit());
			}

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Grabado Exitosamente!", ""));

			u.commit();

			cancel();

			JsfUtils.executeJS("PF('wvMasterDetail_mdUsuarioRol').select(0);");

		} catch (Exception ex) {

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));

			Logger.getLogger(UsuarioRolController.class.getName()).log(
					Level.SEVERE, null, ex);

		}

	}

	public void delete(UsuarioRol entity) {
		// TODO Auto-generated method stub
		try {
			u.begin();

			entity.setEstado(Estado.INACTIVO);

			usuarioRolService.actualizar(entity);

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Eliminado Exitosamente!", ""));

			u.commit();

			cancel();

		} catch (Exception ex) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));

			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public void selected(UsuarioRol entity) {
		// TODO Auto-generated method stub

		setSelectedEntityEdit(entity);

		System.out.println("selected - " + getSelectedEntityEdit());

		setEnabledCreate(false);
		setEnabledSave(true);
		setEnabledDelete(true);
		setEnabledCancel(true);

		// setPass1(getSelectedEntity().getClave());
		// setPass2(getSelectedEntity().getClave());

	}

	@Override
	public void selectedLinked() {
		// TODO Auto-generated method stub

	}

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
	}*/

}
