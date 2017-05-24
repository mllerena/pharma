package org.pharmaceutical.view.controllers;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.pharmaceutical.model.ejb.facades.AdUserFacade;
import org.pharmaceutical.model.ejb.services.UsuarioService;
import org.pharmaceutical.model.entities.AdUser;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.entities.Usuario;
import org.pharmaceutical.model.entities.UsuarioRol;
import org.pharmaceutical.model.utils.StringsUtils;
import org.pharmaceutical.view.utils.JsfUtils;

@Named
@SessionScoped
public class AuthenticationController implements Serializable{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AdUserFacade adUserFacade;
	
	//@Resource UserTransaction u;
	
	
	private AdUser usuario;
	
	private String pass1;
	
	private String pass2;
	
	
	
	
	@PostConstruct
	public void initialize(){
		
		System.out.println("initialize AuthenticationController");
		
		
		Principal user = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		
		if(user != null){
			this.usuario = adUserFacade.findByUsername(user.getName());
		}else{
			this.usuario = null;
		}
		
		
		
	}
	
	
	public void actualizarUsuario() {
        try {
        	
        	System.out.println("actualizarUsuario Authentication");
        	
            //u.begin();
            
          
            
            if (!validateUser()) {
                return;
            }

            if (!StringsUtils.isEmptyTrim(pass1) && !StringsUtils.isEmptyTrim(pass2)) {
                //usuariosVista.getSelectedEnt().setClave(DigestUtils.md5Hex(pass1.trim()));
            	this.usuario.setPassword(pass1.trim());
            }
            
            
			adUserFacade.save(usuario, pass1, pass2);
            
           // u.commit();
            
            JsfUtils.executeJS("PF('wvCambioClave').hide()");
            
            this.pass1 = null;
            this.pass2 = null;
            
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Cambio de clave con Exito!", ""));
			
            
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
	
	public Boolean validateUser() {
        Boolean esValido = true;

        FacesContext context = FacesContext.getCurrentInstance();
        
        System.out.println("pass1: "+pass1+" - pass2: "+pass2);

        // si se escribio nuevo pass:
        if (!StringsUtils.isEmptyTrim(pass1) || !StringsUtils.isEmptyTrim(pass2)) {
            // validar pass1
            if (StringsUtils.isEmptyTrim(pass1)) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrase�a vac�a.", null));
                esValido = false;
            }
            // validar pass2
            if (!StringsUtils.eqTrim_NotNullOrEmpty(pass1, pass2)) {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contrase�a no concuerda.",null));
                esValido = false;
            }
        }

        return esValido;
    }
	
	public AdUser getUsuario() {
		/*Principal user = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		if(user != null){
			this.usuario = usuarioService.findByUsuario(user.getName());
		}else{
			this.usuario = null;
		}*/
		return usuario;
	}


	public void setUsuario(AdUser usuario) {
		this.usuario = usuario;
	}



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
	
	
	
	

}
