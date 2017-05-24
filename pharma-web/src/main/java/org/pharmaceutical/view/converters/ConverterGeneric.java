package org.pharmaceutical.view.converters;

import java.util.Collections;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@FacesConverter("ConverterGeneric")
public class ConverterGeneric implements Converter {

    @Override 
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        final int index = Integer.parseInt(value);
        if (index == -1) {
            return null;
        }
        final List<?> objects = getObjectsFromUISelectItemsComponent(component);
        //System.out.println("Objeto seleccionado : " + objects.get(index));
        return objects.get(index);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        final List<?> objects = getObjectsFromUISelectItemsComponent(component);

//        System.out.println("getAsStringObject value: " + value);
//        System.out.println("getAsStringObject : " + objects.indexOf(value));
        return objects != null ? String.valueOf(objects.indexOf(value)) : "";
    }

    private List<?> getObjectsFromUISelectItemsComponent(UIComponent component) {
        List<?> objects = Collections.emptyList();
        for (UIComponent child : component.getChildren()) {
            if (child.getClass() == UISelectItems.class) {
                objects = (List<?>) ((UISelectItems) child).getValue();
            }
        }
//        System.out.println("TODOS LOS OBJETOS : " + objects);
        return objects;
    }
}
