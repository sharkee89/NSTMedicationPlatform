/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Otpremnica;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import session.otpremnica.SBOtpremnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbPrikazNegenerisanih")
@RequestScoped
public class MBPrikazNegenerisanih implements Serializable{
    
    List<Otpremnica> listaNegenerisanihOtp;
    int brojacNegenerisanih;
    @EJB
    private SBOtpremnicaLocal otpremnicaFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBPrikazNegenerisanih
     */
    public MBPrikazNegenerisanih() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        listaNegenerisanihOtp = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.zusID.zusID = :zID AND o.potvrdjena = FALSE").setParameter("zID", mbSesija.ulogovaniZus.getZusID()).getResultList();
        brojacNegenerisanih = listaNegenerisanihOtp.size();
    }

    public List<Otpremnica> getListaNegenerisanihOtp() {
        return listaNegenerisanihOtp;
    }

    public void setListaNegenerisanihOtp(List<Otpremnica> listaNegenerisanihOtp) {
        this.listaNegenerisanihOtp = listaNegenerisanihOtp;
    }

    public int getBrojacNegenerisanih() {
        return brojacNegenerisanih;
    }

    public void setBrojacNegenerisanih(int brojacNegenerisanih) {
        this.brojacNegenerisanih = brojacNegenerisanih;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    
    
}
