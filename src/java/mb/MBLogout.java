/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Distributer;
import domen.Zdravstvenaustanova;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbLogout")
@RequestScoped
public class MBLogout implements Serializable{

    private Distributer distributer;
    private Zdravstvenaustanova zus;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;
    /**
     * Creates a new instance of MBLogout
     */
    public MBLogout() {
    }
    
    @PostConstruct
    public void incijilizujPodatke(){
        distributer = new Distributer();
        zus = new Zdravstvenaustanova();
        mbSesija = new MBSesija();
    }
    
    public String izlogujSe(){
        
        HttpSession sesija = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesija.invalidate();
        return "index.xhtml";
    }

    public Distributer getDistributer() {
        return distributer;
    }

    public void setDistributer(Distributer distributer) {
        this.distributer = distributer;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    
    
}
