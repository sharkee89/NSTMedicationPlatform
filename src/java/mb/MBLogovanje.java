/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Distributer;
import domen.Korisnik;

import domen.Zdravstvenaustanova;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import session.distributer.SBDistributerLocal;
import session.korisnik.SBKorisnikLocal;
import session.zus.SBZusLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean (name = "mbLogovanje")
@RequestScoped
public class MBLogovanje implements Serializable{
    
    private Distributer tekuciDistributer;
    private Zdravstvenaustanova tekuciZus;
    private Korisnik tekucikorisnik;
    private Korisnik korisnikIzBaze;
 //   private Objekat objekat;
    @EJB
    private SBDistributerLocal distributerFacade;
    @EJB
    private SBZusLocal zusFacade;
    @EJB
    private SBKorisnikLocal korisnikFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBLogovanje
     */
    public MBLogovanje() {
        tekuciDistributer = new Distributer();
        tekuciZus = new Zdravstvenaustanova();
        tekucikorisnik = new Korisnik();
        korisnikIzBaze = new Korisnik();
 //       objekat = new Objekat();
    }

    public Distributer getTekuciDistributer() {
        return tekuciDistributer;
    }

    public void setTekuciDistributer(Distributer tekuciDistributer) {
        this.tekuciDistributer = tekuciDistributer;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }

    public Zdravstvenaustanova getTekuciZus() {
        return tekuciZus;
    }

    public void setTekuciZus(Zdravstvenaustanova tekuciZus) {
        this.tekuciZus = tekuciZus;
    }

    public Korisnik getTekucikorisnik() {
        return tekucikorisnik;
    }

    public void setTekucikorisnik(Korisnik tekucikorisnik) {
        this.tekucikorisnik = tekucikorisnik;
    }

    public Korisnik getKorisnikIzBaze() {
        return korisnikIzBaze;
    }

    public void setKorisnikIzBaze(Korisnik korisnikIzBaze) {
        this.korisnikIzBaze = korisnikIzBaze;
    }
    
    

//    public Objekat getObjekat() {
//        return objekat;
//    }
//
//    public void setObjekat(Objekat objekat) {
//        this.objekat = objekat;
//    }
    
//    public String logovvv(){
//        if(zusFacade.vratiZusPoImenu(objekat.getIme())!=null){
//            tekuciZus = zusFacade.vratiZusPoImenu(objekat.getIme());
//            mbSesija.setUlogovaniZus(tekuciZus);
//            return "pocetnaZus";
//        }else if(distributerFacade.vratiDistributerPoImenu(objekat.getIme())!=null){
//            tekuciDistributer = distributerFacade.vratiDistributerPoImenu(objekat.getIme());
//            mbSesija.setUlogovaniDistributer(tekuciDistributer);
//            return "pocetna";
//     
//        }
//        return "fail";
//    }
    
    public String logovanje() throws Exception{
        try {
            korisnikIzBaze = (Korisnik)korisnikFacade.vratiEM().createQuery("SELECT k FROM Korisnik k WHERE k.korisnickoIme = :korisnickoIme").setParameter("korisnickoIme", tekucikorisnik.getKorisnickoIme()).getSingleResult();
            if(korisnikIzBaze.getDistributerID()!=null){
            tekuciDistributer = distributerFacade.vratiDistributeraPoID(korisnikIzBaze.getDistributerID().getDistributerID());
                if(tekuciDistributer.getDkorisnickaSifra().equals(tekucikorisnik.getKorisnickaSifra())){
                    mbSesija.setUlogovaniDistributer(tekuciDistributer);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Korisnik "+ tekuciDistributer.getNaziv()+" je uspesno ulogovan", ""));
                    return "pocetna";
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ne postoji korisnik sa takvim kredencijalima", ""));
                    return null;
                }
            }else if(korisnikIzBaze.getZusID()!=null){
            tekuciZus = zusFacade.vratiZusPoID(korisnikIzBaze.getZusID().getZusID());
                if(tekuciZus.getZkorisnickaSifra().equals(tekucikorisnik.getKorisnickaSifra())){
                    mbSesija.setUlogovaniZus(tekuciZus);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Korisnik "+ tekuciZus.getNaziv()+" je uspesno ulogovan", ""));
                    return "pocetnaZus";
                }else{
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ne postoji korisnik sa takvim kredencijalima", ""));
                    return null;                    
                }
            }else{
                return "fail";
            }
            
        } catch (Exception e) {
            e.getMessage();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ne postoji korisnik sa takvim kredencijalima", ""));
            return null;
        }
    }
      
//    public String logovanjeKorisnika(){
//        try {
//            tekuciDistributer = distributerFacade.vratiDistributera(tekuciDistributer); 
//            mbSesija.setUlogovaniDistributer(tekuciDistributer);
//        } catch (Exception ex) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
//            return null;
//        }
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Korisnik D "+ tekuciDistributer.getDkorisnickoIme() +" je uspesno ulogovan", ""));
//        return "pocetna.xhtml?faces-redirect-true";
//    }
//    
//    public String logovanjeZus(){
//        try {
//            tekuciZus = zusFacade.vratiZus(tekuciZus);
//            mbSesija.setUlogovaniZus(tekuciZus);
//        } catch (Exception ex) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), ""));
//            return null;
//        }
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Korisnik Z " + tekuciZus.getZkorisnickoIme() + " je uspesno ulogovan", ""));
//        return "pocetnaZus.xhtml?faces-redirect-true";
//    }
    
    
    
}
