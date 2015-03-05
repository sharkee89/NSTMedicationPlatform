/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbPoruke")
@RequestScoped
public class MBPoruke {

    /**
     * Creates a new instance of MBPoruke
     */
    public MBPoruke() {
    }
    
    public void sacuvanaOtpremnica(ActionEvent actionEvent){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Otpremnica je uspesno sacuvana iz PORUAK", null));
    }
    
}
