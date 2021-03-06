/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Otpremnica;
import domen.Prijemnica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import session.otpremnica.SBOtpremnicaLocal;
import session.prijemnica.SBPrijemnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean( name = "mbPrikazPrijemnice")
@RequestScoped
public class MBPrikazPrijemnice implements Serializable{
    
    private Prijemnica prijemnica;
    @EJB
    private SBPrijemnicaLocal prijemnicaFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;
    
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

    

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    public String prikaziOtpremnicu(int idS){
        prijemnica = prijemnicaFacade.vratiPrijemnicuPoOtpID(idS);
        return "prijemnica";
    }
}
