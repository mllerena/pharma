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
import org.pharmaceutical.model.enums.MovementType;
import org.pharmaceutical.model.enums.ProductionType;
import org.pharmaceutical.model.enums.ShiftType;

@ManagedBean
@ApplicationScoped
public class MovementTypeConverter implements Converter, Serializable {

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
			case "I+":
				return MovementType.ENTRADA_INVENTARIO;
			case "I-": 
				return MovementType.SALIDA_INVENTARIO;
			case "M+":
				return MovementType.MOVIMIENTO_PARA;
			case "M-": 
				return MovementType.MOVIMIENTO_DE;
			case "P+":
				return MovementType.PRODUCCION_POSITIVA;
			case "P-": 
				return MovementType.PRODUCCION_NEGATIVA; 
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
		MovementType attribute = (MovementType) o; 
		if (attribute != null) { 
			switch (attribute) {
			case ENTRADA_INVENTARIO:
				return "I+";
			case SALIDA_INVENTARIO:
				return "I-";
			case MOVIMIENTO_PARA:
				return "M+";
			case MOVIMIENTO_DE:
				return "M-";
			case PRODUCCION_POSITIVA:
				return "P+";
			case PRODUCCION_NEGATIVA:
				return "P-"; 
			default:
				throw new IllegalArgumentException("getAsString Unknown: "
						+ attribute); 
			}
		} else
			return null;

	}
}
