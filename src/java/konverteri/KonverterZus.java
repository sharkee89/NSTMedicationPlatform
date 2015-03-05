/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverteri;

import domen.Zdravstvenaustanova;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import session.zus.SBZusLocal;

/**
 *
 * @author Stefan
 */
@FacesConverter(forClass = Zdravstvenaustanova.class)
@ManagedBean
@SessionScoped
public class KonverterZus implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }

        Integer zusID = Integer.parseInt(value);
        Zdravstvenaustanova zus = null;
        try {
            SBZusLocal sbZus = (SBZusLocal) new InitialContext().lookup("java:global/ZZZLekovi_1/SBZus");

            zus = sbZus.vratiZusPoID(zusID);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return zus;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
            if (value instanceof Zdravstvenaustanova) {
            Zdravstvenaustanova zus = (Zdravstvenaustanova) value;
            if (zus != null) {
                return String.valueOf(zus.getZusID());
            }
        }
        return "";
    }
    
    
    
}
