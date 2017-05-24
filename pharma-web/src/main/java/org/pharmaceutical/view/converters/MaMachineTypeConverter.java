package org.pharmaceutical.view.converters;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.MaMachineTypeFacade;
import org.pharmaceutical.model.entities.MaMachineType; 


@ManagedBean
@ApplicationScoped
public class MaMachineTypeConverter implements Converter, Serializable {

    /**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	MaMachineTypeFacade  maMachineTypeFacade;

    // ESTE CONVIERTE EL SELECTITEM SELECCIONADO EN OBJETO PARA ENVIAR AL OBEJETO PARA PERSISTIR
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
    	MaMachineType objRes = null;
        if (!string.trim().equals("") && string != null) {
            objRes = (MaMachineType) maMachineTypeFacade.find(string);  
        }
//        return (string.trim().equals("") || string == null) ? null : objRes;
        return objRes;
    }

    // ESTE ES EL QUE SE EJECUTA AL INICIO Y HACE QUE EL CATALOGO MUESTRE LOS IDS
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) { 
        return (o == null || o.equals("")) ? "" : ((MaMachineType) o).getId() + "";   

    }
}
