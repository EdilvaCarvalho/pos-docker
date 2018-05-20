
package br.edu.ifpb.pos.docker.web.beans.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Edilva
 */
@FacesConverter("localDateConverter")
public class LocalDateConverter implements Converter {
    
    private final String pattern = "dd/MM/yyyy";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.isEmpty()) return null;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        LocalDate date = LocalDate.parse(value, dtf);
        return date;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null) return "";
        LocalDate date = (LocalDate) value;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return date.format(dtf);
    }
    
}
