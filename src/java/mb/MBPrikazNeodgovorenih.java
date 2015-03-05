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
@ManagedBean(name = "mbPrikazNeodgovorenih")
@RequestScoped
public class MBPrikazNeodgovorenih implements Serializable{
    
    List<Otpremnica> listaNeodgovorenihOtp;
    int brojacNeodgovorenih;
    @EJB
    private SBOtpremnicaLocal otpremnicaFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBPrikazNeodgovorenih
     */
    public MBPrikazNeodgovorenih() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        listaNeodgovorenihOtp = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :dID AND o.potvrdjena = FALSE").setParameter("dID", mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        brojacNeodgovorenih = listaNeodgovorenihOtp.size();
    }

    public List<Otpremnica> getListaNeodgovorenihOtp() {
        return listaNeodgovorenihOtp;
    }

    public void setListaNeodgovorenihOtp(List<Otpremnica> listaNeodgovorenihOtp) {
        this.listaNeodgovorenihOtp = listaNeodgovorenihOtp;
    }

    public int getBrojacNeodgovorenih() {
        return brojacNeodgovorenih;
    }

    public void setBrojacNeodgovorenih(int brojacNeodgovorenih) {
        this.brojacNeodgovorenih = brojacNeodgovorenih;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    
    
}
