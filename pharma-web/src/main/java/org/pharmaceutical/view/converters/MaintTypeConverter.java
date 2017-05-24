package org.pharmaceutical.view.converters;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;

import org.pharmaceutical.model.ejb.facades.AdRoleFacade;
import org.pharmaceutical.model.ejb.facades.RolFacade;
import org.pharmaceutical.model.entities.AdRole;
import org.pharmaceutical.model.entities.Rol;
import org.pharmaceutical.model.enums.CostUOM;
import org.pharmaceutical.model.enums.MaintType;

@ManagedBean
@ApplicationScoped
public class MaintTypeConverter implements Converter, Serializable {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;

	// ESTE CONVIERTE EL SELECTITEM SELECCIONADO EN OBJETO PARA ENVIAR AL
	// OBEJETO PARA PERSISTIR
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		if (string != null) {
			switch (string) {
			case "C":
				return MaintType.CORRECTIVO;
			case "U":
				return MaintType.CORRECTIVO_URGENTE;
			case "P":
				return MaintType.PREVENTIVO;
			case "Seleccione":
				return null; 	
			default:
				throw new IllegalArgumentException("getAsObject Unknown: "
						+ string);
			}
		} else {
			return null;
		}
	}

	// ESTE ES EL QUE SE EJECUTA AL INICIO Y HACE QUE EL CATALOGO MUESTRE LOS
	// IDS
	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		MaintType attribute = (MaintType) o;
		if (attribute != null) { 
			switch (attribute) {
			case CORRECTIVO:
				return "C";
			case CORRECTIVO_URGENTE:
				return "U";
			case PREVENTIVO:
				return "P";
			default:
				throw new IllegalArgumentException("getAsString Unknown: "
						+ attribute); 
			}
		} else
			return null;

	}
}
