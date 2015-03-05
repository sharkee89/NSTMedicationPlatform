/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbKontrolerPoruka")
@RequestScoped
public class MBKontrolerPoruka implements Serializable{
    
    String ime;
    int broj;

    /**
     * Creates a new instance of MBKontrolerPoruka
     */
    public MBKontrolerPoruka() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
    }
    
    public void obrisanaOtpremnica(ActionEvent actionEvent){
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OTPREMNICA OBRISANA", ""));
    }
}
