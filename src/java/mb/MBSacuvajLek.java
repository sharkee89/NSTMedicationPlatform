/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Lek;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import session.lek.SBLekLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbSacuvajLek")
@RequestScoped
public class MBSacuvajLek implements Serializable{
    
    private Lek lek;
    @EJB
    private SBLekLocal lekFacade;

    /**
     * Creates a new instance of MBSacuvajLek
     */
    public MBSacuvajLek() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        lek = new Lek();
    }

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }
    
    public String sacuvajLekMB(){
        if(lek.getCena() > 0){
            lekFacade.sacuvajLek(lek);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sistem ne moze da zapamti podatke o novom leku", ""));
            return "sacuvajotpremnicu.xhtml";
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cena novog leka ne moze biti 0 ili manje od 0", ""));
            return "sacuvajlek.xhtml";
        }
        
    }
    
}
