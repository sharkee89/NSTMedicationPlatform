/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Korisnik;
import domen.Zdravstvenaustanova;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import session.korisnik.SBKorisnikLocal;
import session.zus.SBZusLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbRegistracijaZus")
@ViewScoped
public class MBRegistracijaZus implements Serializable{
    
    private Zdravstvenaustanova trenutniZus;
    private Korisnik tekuciKorisnik;
    List<Korisnik> listaKorisnika;
    @EJB
    private SBZusLocal zusFacade;
    @EJB
    private SBKorisnikLocal korisnikFacade;


    /**
     * Creates a new instance of MBRegistracijaZus
     */
    public MBRegistracijaZus() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        trenutniZus = new Zdravstvenaustanova();
        tekuciKorisnik = new Korisnik();
        listaKorisnika = korisnikFacade.vratiSveKorisnike();
    }

    public Zdravstvenaustanova getTrenutniZus() {
        return trenutniZus;
    }

    public void setTrenutniZus(Zdravstvenaustanova trenutniZus) {
        this.trenutniZus = trenutniZus;
    }

    public Korisnik getTekuciKorisnik() {
        return tekuciKorisnik;
    }

    public void setTekuciKorisnik(Korisnik tekuciKorisnik) {
        this.tekuciKorisnik = tekuciKorisnik;
    }

    public List<Korisnik> getListaKorisnika() {
        return listaKorisnika;
    }

    public void setListaKorisnika(List<Korisnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }
    
    
    
    public String idiNaStranuRegistracijaZus(){
        return "registracijaZus";
    } 
    
    public String regustrujZus(){
        zusFacade.registrujZus(trenutniZus);
        tekuciKorisnik.setKorisnikRB(listaKorisnika.get(listaKorisnika.size()-1).getKorisnikRB()+1);
        tekuciKorisnik.setKorisnickoIme(trenutniZus.getZkorisnickoIme());
        tekuciKorisnik.setKorisnickaSifra(trenutniZus.getZkorisnickaSifra());
        tekuciKorisnik.setDistributerID(null);
        tekuciKorisnik.setZusID(trenutniZus);
        korisnikFacade.sacuvajKorisnika(tekuciKorisnik);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno ste se registrovali", ""));
        return "index.xhtml";
    }
    
    
    
    
    
}
