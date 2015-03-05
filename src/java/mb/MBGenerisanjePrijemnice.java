/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Kvalitativnakvantitativnakontrola;
import domen.Otpremnica;
import domen.Prijemnica;
import domen.Stavkakkk;
import domen.StavkakkkPK;
import domen.Stavkaotpremnice;
import domen.Stavkaprijemnice;
import domen.StavkaprijemnicePK;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import session.kkk.SBKkkLocal;
import session.otpremnica.SBOtpremnicaLocal;
import session.prijemnica.SBPrijemnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbGenerisanjePrijemnice")
@ViewScoped
public class MBGenerisanjePrijemnice implements Serializable{
    
    private Otpremnica otpremnica;
    private Prijemnica prijemnica;
    private Stavkaprijemnice novaStavkaP;
    private Kvalitativnakvantitativnakontrola kkk;
    private Stavkakkk novaStavkaKkk;
    List<Otpremnica> listaOtpremnicaZaGenerisanje;
    List<Prijemnica> listaPrijemnicaZaBroj;
    List<Kvalitativnakvantitativnakontrola> listaKkkZaBroj;
    @EJB
    SBOtpremnicaLocal otpremnicaFacade;
    @EJB 
    SBPrijemnicaLocal prijemnicaFacade;
    @EJB
    SBKkkLocal kkkFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBGenerisanjeOtpremnice
     */
    public MBGenerisanjePrijemnice() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        otpremnica = new Otpremnica();
        otpremnica.setStavkaotpremniceList(new ArrayList<Stavkaotpremnice>());
        prijemnica = new Prijemnica();
        prijemnica.setStavkaprijemniceList(new ArrayList<Stavkaprijemnice>());
        novaStavkaP = new Stavkaprijemnice();
        novaStavkaP.setStavkaprijemnicePK(new StavkaprijemnicePK());
        listaOtpremnicaZaGenerisanje = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.zusID.zusID = :zID AND o.potvrdjena=0").setParameter("zID", mbSesija.ulogovaniZus.getZusID()).getResultList();
        listaPrijemnicaZaBroj = prijemnicaFacade.vratiEm().createQuery("SELECT p FROM Prijemnica p WHERE p.zusID.zusID = :zusID").setParameter("zusID", mbSesija.ulogovaniZus.getZusID()).getResultList();
        listaKkkZaBroj = kkkFacade.vratiEM().createQuery("SELECT k FROM Kvalitativnakvantitativnakontrola k").getResultList();
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(Otpremnica otpremnica) {
        this.otpremnica = otpremnica;
    }

    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
    }

    public Kvalitativnakvantitativnakontrola getKkk() {
        return kkk;
    }

    public void setKkk(Kvalitativnakvantitativnakontrola kkk) {
        this.kkk = kkk;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }

    public List<Otpremnica> getListaOtpremnicaZaGenerisanje() {
        return listaOtpremnicaZaGenerisanje;
    }

    public void setListaOtpremnicaZaGenerisanje(List<Otpremnica> listaOtpremnicaZaGenerisanje) {
        this.listaOtpremnicaZaGenerisanje = listaOtpremnicaZaGenerisanje;
    } 

    public List<Prijemnica> getListaPrijemnicaZaBroj() {
        return listaPrijemnicaZaBroj;
    }

    public void setListaPrijemnicaZaBroj(List<Prijemnica> listaPrijemnicaZaBroj) {
        this.listaPrijemnicaZaBroj = listaPrijemnicaZaBroj;
    }

    public List<Kvalitativnakvantitativnakontrola> getListaKkkZaBroj() {
        return listaKkkZaBroj;
    }

    public void setListaKkkZaBroj(List<Kvalitativnakvantitativnakontrola> listaKkkZaBroj) {
        this.listaKkkZaBroj = listaKkkZaBroj;
    }
    
    
    
    public String vratiGenerisanuPrijemnicu(){
        otpremnica = otpremnicaFacade.vratiOtpremnicaPoID(otpremnica.getOtpremnicaID());
        prijemnica = new Prijemnica(prijemnicaFacade.vratiRB());
        prijemnica.setZusID(mbSesija.ulogovaniZus);
        String prvaDva = prijemnica.getZusID().getNaziv().substring(0, 2);
        String drugaDva = String.valueOf(listaPrijemnicaZaBroj.size()+1);
        String brojPrijemnice = "PRI"+prvaDva+drugaDva;
        prijemnica.setBrojPrijemnice(brojPrijemnice);
        prijemnica.setOtpremnicaID(otpremnica); 
        prijemnica.setStavkaprijemniceList(new ArrayList<Stavkaprijemnice>());

        if(otpremnica.getOtpremnicaID() == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nema novih otpremnica na osnovu kojih biste generisali prijemnicu", ""));
        }
        
        
        for(int i = 0; i <otpremnica.getStavkaotpremniceList().size(); i++){
                novaStavkaP.getStavkaprijemnicePK().setPrijemnicaID(prijemnica.getPrijemnicaID());
                novaStavkaP.getStavkaprijemnicePK().setStavkaprijemniceRB(i+1);
                novaStavkaP.setKolicina(otpremnica.getStavkaotpremniceList().get(i).getKolicina());
                novaStavkaP.setLekSerijskiBroj(otpremnica.getStavkaotpremniceList().get(i).getLekSerijskiBroj());
                prijemnica.getStavkaprijemniceList().add(novaStavkaP);
                novaStavkaP = new Stavkaprijemnice();
                novaStavkaP.setStavkaprijemnicePK(new StavkaprijemnicePK());
        }
        
//        kkk = new Kvalitativnakvantitativnakontrola(otpremnica.getOtpremnicaID()+200);
//        kkk.setOtpremnicaID(otpremnica);
//        kkk.setPrijemnicaID(prijemnica);
//        kkk.setStavkakkkList(new ArrayList<Stavkakkk>());
//        novaStavkaKkk = new Stavkakkk();
//        novaStavkaKkk.setStavkakkkPK(new StavkakkkPK());
//        for(int i = 0; i<otpremnica.getStavkaotpremniceList().size(); i++){
//            if(otpremnica.getStavkaotpremniceList().get(i).getKolicina()!= prijemnica.getStavkaprijemniceList().get(i).getKolicina()){
//                novaStavkaKkk.getStavkakkkPK().setKkkID(kkk.getKkkID());
//                novaStavkaKkk.getStavkakkkPK().setStavkaKKKRB(i+1);
//                novaStavkaKkk.setKolicina(otpremnica.getStavkaotpremniceList().get(i).getKolicina()- prijemnica.getStavkaprijemniceList().get(i).getKolicina());
//                novaStavkaKkk.setLekSerijskiBroj(otpremnica.getStavkaotpremniceList().get(i).getLekSerijskiBroj());
//                kkk.getStavkakkkList().add(novaStavkaKkk);
//                novaStavkaKkk = new Stavkakkk();
//                novaStavkaKkk.setStavkakkkPK(new StavkakkkPK());
//            }
//        }
        
        
        
        return "generisanjePrijemnice"; 
    }
    
    public String sacuvajPrijemnicuMB(){
        otpremnica.setPotvrdjena(true);
        otpremnica.setPotvrdjenaTekst("Potvrdjena");
        kkk = new Kvalitativnakvantitativnakontrola(kkkFacade.vratiRB());
        kkk.setOtpremnicaID(otpremnica);
        kkk.setPrijemnicaID(prijemnica);
        Date datumk = new Date();
        datumk = prijemnica.getDatum();
        kkk.setDatum(datumk);
        String prvaDva = kkk.getOtpremnicaID().getDistributerID().getNaziv().substring(0, 2);
        String drugaDva = kkk.getPrijemnicaID().getZusID().getNaziv().substring(0, 2);
        String trecaDva = String.valueOf(listaKkkZaBroj.size()+1);
        String brojKkk = "KKK"+prvaDva+drugaDva+trecaDva;
        kkk.setBrojKkk(brojKkk);
        kkk.setStavkakkkList(new ArrayList<Stavkakkk>());
        novaStavkaKkk = new Stavkakkk();
        novaStavkaKkk.setStavkakkkPK(new StavkakkkPK());
        for(int i = 0; i<otpremnica.getStavkaotpremniceList().size(); i++){
            if(otpremnica.getStavkaotpremniceList().get(i).getKolicina()!= prijemnica.getStavkaprijemniceList().get(i).getKolicina()){
                novaStavkaKkk.getStavkakkkPK().setKkkID(kkk.getKkkID());
                novaStavkaKkk.getStavkakkkPK().setStavkaKKKRB(vratiBrojKkkRB());
                novaStavkaKkk.setKolicina(otpremnica.getStavkaotpremniceList().get(i).getKolicina()- prijemnica.getStavkaprijemniceList().get(i).getKolicina());
                novaStavkaKkk.setLekSerijskiBroj(otpremnica.getStavkaotpremniceList().get(i).getLekSerijskiBroj());
                kkk.getStavkakkkList().add(novaStavkaKkk);
                novaStavkaKkk = new Stavkakkk();
                novaStavkaKkk.setStavkakkkPK(new StavkakkkPK());
            }
        }
        
        prijemnicaFacade.sacuvajPrijemnicu(prijemnica);
        otpremnicaFacade.sacuvajOtpremnicu(otpremnica);
        if(!kkk.getStavkakkkList().isEmpty()){
            kkkFacade.sacuvajKkk(kkk);
        }
        // ovde nesto ne valja treba da se vrati na pocetnu zus 
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sistem ne moze da kreira novu prijemnicu", ""));
        listaOtpremnicaZaGenerisanje.clear();
        prijemnica = new Prijemnica();
        return "pocetnaZus.xhtml";
       
    }
    
    public int vratiBrojKkkRB(){
        if(kkk.getStavkakkkList().isEmpty()){
            return 1;
        }else{
            return kkk.getStavkakkkList().get(kkk.getStavkakkkList().size()-1).getStavkakkkPK().getStavkaKKKRB()+1;
        }
    }

}
