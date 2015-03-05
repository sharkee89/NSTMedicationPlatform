/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Distributer;
import domen.Korisnik;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import session.distributer.SBDistributerLocal;
import session.korisnik.SBKorisnikLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean (name = "mbRegistracijaDistributera")
@ViewScoped
public class MBRegistracijaDistributera implements Serializable{

    private Distributer trenutniDistributer;
    private Korisnik trenutniKorisnik;
    List<Korisnik> listaKorisnika;
    @EJB
    private SBDistributerLocal distributerFacade;
    @EJB
    private SBKorisnikLocal korisnikFacade;
    
    /**
     * Creates a new instance of MBRegistracijaDistributera
     */
    public MBRegistracijaDistributera() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        trenutniDistributer = new Distributer();
        trenutniKorisnik = new Korisnik();
        listaKorisnika = korisnikFacade.vratiSveKorisnike();
    }

    public Distributer getTrenutniDistributer() {
        return trenutniDistributer;
    }

    public void setTrenutniDistributer(Distributer trenutniDistributer) {
        this.trenutniDistributer = trenutniDistributer;
    }

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }

    public List<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(List<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }
    
    
    
    public String idiNaStranuZaRegistraciju(){
        trenutniDistributer = new Distributer();
        trenutniKorisnik = new Korisnik();
        return "registracija";
    }

    
    public String registrujDistributeraMB(){
        
        try {
        distributerFacade.registrujDistributera(trenutniDistributer);
        trenutniKorisnik.setKorisnikRB(listaKorisnika.get(listaKorisnika.size()-1).getKorisnikRB()+1);
        trenutniKorisnik.setKorisnickoIme(trenutniDistributer.getDkorisnickoIme());
        trenutniKorisnik.setKorisnickaSifra(trenutniDistributer.getDkorisnickaSifra());
        trenutniKorisnik.setDistributerID(trenutniDistributer);
        trenutniKorisnik.setZusID(null);
        korisnikFacade.sacuvajKorisnika(trenutniKorisnik);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno ste se registrovali", ""));
        
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Nije izvrsena registracija korisnika", ""));
        }
        return "index.xhtml";
    }
    
}
