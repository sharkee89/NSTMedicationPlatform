/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Prijemnica;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import session.prijemnica.SBPrijemnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "ssss")
@RequestScoped
public class SSSS implements Serializable{
    
    private Prijemnica prijemnica;
    @EJB
    private SBPrijemnicaLocal prijemnicaFacade;

    /**
     * Creates a new instance of SSSS
     */
    public SSSS() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        prijemnica = new Prijemnica();
    }

    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
    }
    
    public void sacuvaj(){
        prijemnica.setPrijemnicaID(555);
        prijemnicaFacade.sacuvajPrijemnicu(prijemnica);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno sacuvana prijemnica", ""));
     
    }
}
