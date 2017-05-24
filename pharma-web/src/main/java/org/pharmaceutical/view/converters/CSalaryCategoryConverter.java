package org.pharmaceutical.view.converters;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.AdRoleFacade;
import org.pharmaceutical.model.ejb.facades.CSalaryCategoryFacade;
import org.pharmaceutical.model.ejb.facades.MaCostcenterFacade;
import org.pharmaceutical.model.ejb.facades.MaMachineFacade;
import org.pharmaceutical.model.ejb.facades.MaWorkstationFacade;
import org.pharmaceutical.model.ejb.facades.RolFacade;
import org.pharmaceutical.model.entities.AdRole;
import org.pharmaceutical.model.entities.CSalaryCategory;
import org.pharmaceutical.model.entities.MaCostcenter;
import org.pharmaceutical.model.entities.MaMachine;
import org.pharmaceutical.model.entities.MaWorkstation;
import org.pharmaceutical.model.entities.Rol;


@ManagedBean
@ApplicationScoped
public class CSalaryCategoryConverter implements Converter, Serializable {

    /**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	CSalaryCategoryFacade  cSalaryCategoryFacade;

    // ESTE CONVIERTE EL SELECTITEM SELECCIONADO EN OBJETO PARA ENVIAR AL OBEJETO PARA PERSISTIR
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    	CSalaryCategory objRes = null;
        if (!string.trim().equals("") && string != null) {
            objRes = (CSalaryCategory) cSalaryCategoryFacade.find(string);  
        }
//        return (string.trim().equals("") || string == null) ? null : objRes;
        return objRes;
    }

    // ESTE ES EL QUE SE EJECUTA AL INICIO Y HACE QUE EL CATALOGO MUESTRE LOS IDS
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) { 
        return (o == null || o.equals("")) ? "" : ((CSalaryCategory) o).getId() + "";    

    }
}
