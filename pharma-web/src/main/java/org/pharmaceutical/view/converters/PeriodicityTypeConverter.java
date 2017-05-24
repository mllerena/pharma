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
import org.pharmaceutical.model.enums.PeriodicityType;

@ManagedBean
@ApplicationScoped
public class PeriodicityTypeConverter implements Converter, Serializable {

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
			case "DA":
				return PeriodicityType.DIARIO;
			case "M1":
				return PeriodicityType.MENSUAL;
			case "M2":
				return PeriodicityType.BI_MENSUAL;
			case "M3":
				return PeriodicityType.TRIMESTRAL;
			case "M6":
				return PeriodicityType.SEMESTRAL;
			case "WE":
				return PeriodicityType.SEMANAL;
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
		PeriodicityType attribute = (PeriodicityType) o; 
		if (attribute != null) { 
			switch (attribute) {
			case DIARIO:
				return "DA";
			case MENSUAL:
				return "M1";
			case BI_MENSUAL:
				return "M2";
			case TRIMESTRAL:
				return "M3";
			case SEMESTRAL:
				return "M6";
			case SEMANAL:
				return "WE";
			default:
				throw new IllegalArgumentException("getAsString Unknown: "
						+ attribute);
			}
		} else
			return null;

	}
}
