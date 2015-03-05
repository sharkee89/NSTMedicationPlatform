/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package konverteri;

import domen.Otpremnica;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;
import session.otpremnica.SBOtpremnicaLocal;

/**
 *
 * @author Stefan
 */
@FacesConverter(value = "konvOtpremnica")
public class KonverterOtpremnica implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null ||  value.isEmpty()){
            return null;
        }
        
        Integer otpremnicaID = Integer.parseInt(value);
        Otpremnica otpremnica = null;
        
        try {
            SBOtpremnicaLocal sbOtpremnica = (SBOtpremnicaLocal)new InitialContext().lookup("SBOtpremnica");
            otpremnica = sbOtpremnica.vratiOtpremnicaPoID(otpremnicaID);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return otpremnica;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Otpremnica){
            Otpremnica otpremnica = (Otpremnica)value;
            if(otpremnica != null){
                return String.valueOf(otpremnica.getOtpremnicaID());
            }
        }
        return "";
    }
    
}
