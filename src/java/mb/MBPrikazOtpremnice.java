/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Otpremnica;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import session.otpremnica.SBOtpremnicaLocal;
import session.prijemnica.SBPrijemnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean (name = "mbPrikazOtpremnice")
@RequestScoped
public class MBPrikazOtpremnice implements Serializable{
    
    private Otpremnica otpremnica;
    @EJB
    private SBOtpremnicaLocal otpremnicaFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;
    
    @PostConstruct
    public void inicijalizujPodatke(){
        otpremnica = new Otpremnica();
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(Otpremnica otpremnica) {
        this.otpremnica = otpremnica;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    public String prikaziOtpremnicu(int idS){
        otpremnica = otpremnicaFacade.vratiOtpremnicaPoID(idS);
        return "otpremnica";
    }
    
    
}
