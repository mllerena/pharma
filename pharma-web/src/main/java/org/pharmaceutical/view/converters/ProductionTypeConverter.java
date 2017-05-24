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
import org.pharmaceutical.model.enums.ProductionType;
import org.pharmaceutical.model.enums.ShiftType;

@ManagedBean
@ApplicationScoped
public class ProductionTypeConverter implements Converter, Serializable {

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
			case "+":
				return ProductionType.PRODUCT_PRODUCTION_POSITIVE;
			case "-": 
				return ProductionType.PRODUCT_USE_NEGATIVE; 
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
		ProductionType attribute = (ProductionType) o; 
		if (attribute != null) { 
			switch (attribute) {
			case PRODUCT_PRODUCTION_POSITIVE:
				return "+";
			case PRODUCT_USE_NEGATIVE:
				return "-"; 
			default:
				throw new IllegalArgumentException("getAsString Unknown: "
						+ attribute); 
			}
		} else
			return null;

	}
}
