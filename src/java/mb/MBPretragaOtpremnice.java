/*
 .
3`* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Otpremnica;
import domen.Stavkaotpremnice;
import domen.StavkaotpremnicePK;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import session.otpremnica.SBOtpremnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean (name = "mbPretragaOtpremnice")
@ViewScoped
public class MBPretragaOtpremnice implements Serializable{
    
    List<Otpremnica> listaOtpremnica;
    private Otpremnica otpremnica;
    private Stavkaotpremnice selektovanaStavka;
    @EJB
    private SBOtpremnicaLocal otpremnicaFacade;
    @ManagedProperty (value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBPretragaOtpremnice
     */
    public MBPretragaOtpremnice() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        otpremnica = new Otpremnica();
        listaOtpremnica = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :distID").setParameter("distID",mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        selektovanaStavka = new Stavkaotpremnice();
        selektovanaStavka.setStavkaotpremnicePK(new StavkaotpremnicePK());
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(Otpremnica otpremnica) {
        this.otpremnica = otpremnica;
    }

    public List<Otpremnica> getListaOtpremnica() {
        return listaOtpremnica;
    }

    public void setListaOtpremnica(List<Otpremnica> listaOtpremnica) {
        this.listaOtpremnica = listaOtpremnica;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }

    public Stavkaotpremnice getSelektovanaStavka() {
        return selektovanaStavka;
    }

    public void setSelektovanaStavka(Stavkaotpremnice selektovanaStavka) {
        this.selektovanaStavka = selektovanaStavka;
    }
    
    public String vratiOtpremnicuMB(){
        otpremnica = otpremnicaFacade.vratiOtpremnicaPoID(otpremnica.getOtpremnicaID());
        return "pretragaotpremnice";
    }
    
    public String sacuvajOtpremnicuNovuMB(){
        otpremnicaFacade.sacuvajOtpremnicu(otpremnica);
        inicijalizujPodatke();
        return "pocetna.xhtml";
    }

    public String izbrisiOtpremnicuMB(){
        otpremnica = otpremnicaFacade.vratiEM().find(Otpremnica.class, otpremnica.getOtpremnicaID());
        if(otpremnica.getPotvrdjena()==false){
            otpremnicaFacade.izbrisiOtpremnicu(otpremnica);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Otpremnica je izbrisana", ""));
            inicijalizujPodatke();
            return "pocetna"; 
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Ne mozete izbrisati otpremnicu koja je potvrdjena", ""));
            return "pretragaotpremnice";
        }
        
    
    }
    
    public void izbrisiStavku(){
        otpremnicaFacade.vratiEM().remove(selektovanaStavka);
    }
}
