package org.pharmaceutical.view.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.Enumeration;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;

import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.dmr.ModelNode;
import org.jboss.security.SecurityConstants;
import org.jboss.security.plugins.auth.JaasSecurityManagerBase;
import org.jboss.security.util.MBeanServerLocator;
import org.pharmaceutical.view.utils.JsfUtils;

@Named
@SessionScoped 
public class LoginController implements Serializable{ 
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void errorInicioSesion() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario y/o Contrase�a incorrectos", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    public void logout() {
        //this.setUsuario(null);
        //this.setUserId((long) -1);
        //this.setUserName("invitado");
    	ExternalContext ec = null;
        try {
            ec = FacesContext.getCurrentInstance().getExternalContext();
            ec.redirect(ec.getRequestContextPath() + "/faces/index.xhtml?faces-redirect=true");
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        HttpSession session = (HttpSession) JsfUtils.getExternalContext().getSession(true);
        removeAttributes(session);
        
        session.invalidate();

    }
    
    private void flushAuthenticationCache(final String userid) {  
        final String domain = "pharmaceutical-security";  
        try {  
            ObjectName jaasMgr = new ObjectName("jboss.as:subsystem=security,security-domain=" + domain);  
            Object[] params = {userid};  
            String[] signature = {"java.lang.String"};  
            MBeanServer server = (MBeanServer) MBeanServerFactory.findMBeanServer(null).get(0);  
            server.invoke(jaasMgr, "flushCache", params, signature);  
        } catch (Throwable e) {  
            e.printStackTrace();
        }  
    }  


    private void removeAttributes(HttpSession session) {
        
    	
    	
    	
    	Principal user = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
    	
    	flushAuthenticationCache(user.getName());
    	
        
        Enumeration atrs = session.getAttributeNames();
        while (atrs.hasMoreElements()) {  ///esto elimina atributos guardados
        	
            String name = (String) atrs.nextElement();
            System.out.print("removeAttributes -> "+name);
            
            session.removeAttribute(name);
            
            System.out.println(" -> "+session.getAttribute(name));
        }
        
        
    }

}
