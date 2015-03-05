/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Otpremnica;
import domen.Prijemnica;
import domen.Stavkaotpremnice;
import domen.Stavkaprijemnice;
import java.io.Serializable;
import java.util.ArrayList;
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
import javax.faces.model.SelectItem;
import session.otpremnica.SBOtpremnicaLocal;
import session.prijemnica.SBPrijemnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean (name = "mbPrikazOtpremnica")
@ViewScoped
public class MBPrikazOtpremnica implements Serializable{

    List<Otpremnica> listaOtpremnica;
    private Otpremnica otpremnica;
    private Otpremnica selektovanaOtpremnica;
    private Prijemnica prijemnica;
    private SelectItem[] listaPotvrda;
    private String[] potvrde;
    private String korektnost;
    @EJB
    private SBOtpremnicaLocal otpremnicaFacade; 
    @EJB
    private SBPrijemnicaLocal prijemnicaFacade; 
    @ManagedProperty (value = "#{mbSesija}")
    MBSesija mbSesija;
    
    /**
     * Creates a new instance of MBPrikazOtpremnica
     */
    public MBPrikazOtpremnica() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        otpremnica = new Otpremnica();
        selektovanaOtpremnica = new Otpremnica();
        listaOtpremnica = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :distID").setParameter("distID",mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        potvrde = new String[2];
        potvrde[0] = "Potvrdjena";
        potvrde[1] = "Nije potvrdjena";
        listaPotvrda = createFilterOptions(potvrde);
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

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(Otpremnica otpremnica) {
        this.otpremnica = otpremnica;
    }

    public Otpremnica getSelektovanaOtpremnica() {
        return selektovanaOtpremnica;
    }

    public void setSelektovanaOtpremnica(Otpremnica selektovanaOtpremnica) {
        this.selektovanaOtpremnica = selektovanaOtpremnica;
    }

    public SelectItem[] getListaPotvrda() {
        return listaPotvrda;
    }

    public void setListaPotvrda(SelectItem[] listaPotvrda) {
        this.listaPotvrda = listaPotvrda;
    }

    public String[] getPotvrde() {
        return potvrde;
    }

    public void setPotvrde(String[] potvrde) {
        this.potvrde = potvrde;
    }

    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
    }

    
    
          
    public String izvrsiProveru(){
        if(otpremnica.getPotvrdjena()==true){
            return "Nije Potvrdjena";
        }else{
            return "potvrdjena"; 
        }
    }
    
    public void izbrisiOtpremnicuMB(Otpremnica otp){
        if(otp.getPotvrdjena()==false){
            otpremnicaFacade.izbrisiOtpremnicu(otp);
            inicijalizujPodatke();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Otpremnica je izbrisana", ""));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ne mozete izbrisati otpremnicu koja je potvrdjena", ""));
        }
        
    }
    
    public String sacuvajIzmeneNaOtpremniciMB(List<Stavkaotpremnice> lotp, Otpremnica otp){
        if(otp.getPotvrdjena()==false){
            otp.setStavkaotpremniceList(lotp);
            otpremnicaFacade.sacuvajOtpremnicu(otp);
            inicijalizujPodatke();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Otpremnica je izmenjena", ""));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ne mozete izmeniti otpremnicu koja je potvrdjena", ""));
        }
        return "otpremnice.xhtml";
    }
    
    public Prijemnica prikaziPrijemnicu(int otpremnicaID){
        //listaOtpremnica = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :distID").setParameter("distID",mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        List<Prijemnica> listaPrijemnica = prijemnicaFacade.vratiEm().createQuery("SELECT p FROM Prijemnica p WHERE p.otpremnicaID.otpremnicaID = :otpID").setParameter("otpID", otpremnicaID).getResultList();
        return listaPrijemnica.get(0);
    }
    
    public List<Stavkaprijemnice> vratiStavkePrijemnice(int otpremnicaID){
        return prijemnicaFacade.vratiEm().createQuery("SELECT p FROM Prijemnica p WHERE p.otpremnicaID.otpremnicaID = :otpID").setParameter("otpID", otpremnicaID).getResultList();
    }
    
        private SelectItem[] createFilterOptions(String[] data)  {  
        SelectItem[] options = new SelectItem[data.length + 1];  
  
        options[0] = new SelectItem("", "Select");  
        for(int i = 0; i < data.length; i++) {  
            options[i + 1] = new SelectItem(data[i], data[i]);  
        }  
  
        return options;  
    } 
        
        
    
        
}
