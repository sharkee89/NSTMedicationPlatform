/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package konverteri;

import domen.Lek;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import session.lek.SBLekLocal;

/**
 *
 * @author stefan
 */
@FacesConverter(forClass = Lek.class)
@ManagedBean
@SessionScoped
public class KonverterLek implements Converter{


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        Integer lekSerijskiBroj = Integer.parseInt(value);
        Lek lek = null;
        try {
            SBLekLocal sbLek = (SBLekLocal) new InitialContext().lookup("java:global/ZZZLekovi_1/SBLek");

            lek = sbLek.vratiLekPoId(lekSerijskiBroj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lek;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
         if (value instanceof Lek) {
            Lek lek = (Lek) value;
            if (lek != null) {
                return String.valueOf(lek.getLekSerijskiBroj());
            }
        }
        return "";
    }
    
}
