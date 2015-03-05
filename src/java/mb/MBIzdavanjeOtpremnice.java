/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Distributer;
import domen.Lek;
import domen.Otpremnica;
import domen.Stavkaotpremnice;
import domen.StavkaotpremnicePK;
import domen.Zdravstvenaustanova;
import java.io.Serializable;
import java.util.ArrayList;
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
import session.distributer.SBDistributerLocal;
import session.lek.SBLekLocal;
import session.otpremnica.SBOtpremnicaLocal;
import session.zus.SBZusLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbIzdavanjeOtpremnice")
@ViewScoped
public class MBIzdavanjeOtpremnice implements Serializable {

    public Otpremnica trenutnaOtpremnica;
    public List<Lek> listaLekova;
    public Lek selektovaniLek;
    public Stavkaotpremnice novaStavka;
    public Stavkaotpremnice selektovanaStavka;
    public List<Zdravstvenaustanova> listaZus;
    public List<Otpremnica> listaOtpZaNaziv;
    public int brojacIzbrisiStavku;
    @EJB
    SBOtpremnicaLocal otpremnicaFacade;
    @EJB
    SBLekLocal lekFacade;
    @EJB
    SBZusLocal zusFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBIzdavanjeOtpremnice
     */
    public MBIzdavanjeOtpremnice() {

    }

    @PostConstruct
    public void inicijalizujVrednosti() {
        trenutnaOtpremnica = new Otpremnica(otpremnicaFacade.vratiRB());
        trenutnaOtpremnica.setDistributerID(mbSesija.ulogovaniDistributer);
        trenutnaOtpremnica.setStavkaotpremniceList(new ArrayList<Stavkaotpremnice>());
        listaLekova = lekFacade.vratiSveLekove();
        novaStavka = new Stavkaotpremnice();
        novaStavka.setStavkaotpremnicePK(new StavkaotpremnicePK());
        selektovanaStavka = new Stavkaotpremnice();
        selektovanaStavka.setStavkaotpremnicePK(new StavkaotpremnicePK());
        listaZus = zusFacade.vratiSveZus();
        listaOtpZaNaziv = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :distID").setParameter("distID", mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        brojacIzbrisiStavku = 0;
    }

    public int getBrojacIzbrisiStavku() {
        return brojacIzbrisiStavku;
    }

    public void setBrojacIzbrisiStavku(int brojacIzbrisiStavku) {
        this.brojacIzbrisiStavku = brojacIzbrisiStavku;
    }

    
    
    public Otpremnica getTrenutnaOtpremnica() {
        return trenutnaOtpremnica;
    }

    public void setTrenutnaOtpremnica(Otpremnica trenutnaOtpremnica) {
        this.trenutnaOtpremnica = trenutnaOtpremnica;
    }

    public Stavkaotpremnice getNovaStavka() {
        return novaStavka;
    }

    public void setNovaStavka(Stavkaotpremnice novaStavka) {
        this.novaStavka = novaStavka;
    }

    public List<Lek> getListaLekova() {
        return listaLekova;
    }

    public void setListaLekova(List<Lek> listaLekova) {
        this.listaLekova = listaLekova;
    }

    public Lek getSelektovaniLek() {
        return selektovaniLek;
    }

    public void setSelektovaniLek(Lek selektovaniLek) {
        this.selektovaniLek = selektovaniLek;
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

    public List<Zdravstvenaustanova> getListaZus() {
        return listaZus;
    }

    public void setListaZus(List<Zdravstvenaustanova> listaZus) {
        this.listaZus = listaZus;
    }

    public List<Otpremnica> getListaOtpZaNaziv() {
        return listaOtpZaNaziv;
    }

    public void setListaOtpZaNaziv(List<Otpremnica> listaOtpZaNaziv) {
        this.listaOtpZaNaziv = listaOtpZaNaziv;
    }

    public void dodajStavku() {
       
            if (selektovaniLek != null) {
                brojacIzbrisiStavku++;
                if (novaStavka.getKolicina() > 0 && novaStavka.getKolicina() % 1 == 0) {
                    novaStavka.getStavkaotpremnicePK().setStavkaotpremniceRB(trenutnaOtpremnica.getStavkaotpremniceList().size() + 1);
                    novaStavka.setLekSerijskiBroj(selektovaniLek);
                    Lek noviLek = lekFacade.vratiLekPoId((novaStavka.getLekSerijskiBroj().getLekSerijskiBroj()));
                    int counter = 0;
                    int noviLekSBR = 0;
                     for(int i = 0; i < trenutnaOtpremnica.getStavkaotpremniceList().size(); i++){
                        Lek noviLekLista = lekFacade.vratiLekPoId(trenutnaOtpremnica.getStavkaotpremniceList().get(i).getLekSerijskiBroj().getLekSerijskiBroj());
                        if(noviLek.getLekSerijskiBroj() ==noviLekLista.getLekSerijskiBroj()){
                            double postojecaKolLeka = trenutnaOtpremnica.getStavkaotpremniceList().get(i).getKolicina();
                            trenutnaOtpremnica.getStavkaotpremniceList().get(i).setKolicina(postojecaKolLeka + novaStavka.getKolicina());
                            counter++;
                        }
                    }
                     
                    if(counter == 0){
                        trenutnaOtpremnica.getStavkaotpremniceList().add(novaStavka);
                    }
                    novaStavka = new Stavkaotpremnice();
                    novaStavka.setStavkaotpremnicePK(new StavkaotpremnicePK());
                    selektovaniLek = new Lek();
                    listaLekova = lekFacade.vratiSveLekove();
                         
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Kolicina nove stavke ne moze biti 0 ili manje od 0", ""));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Morate selektovari lek iz liste", ""));
            }
        }
    

    public void izbrisiStavku() {
        novaStavka.getStavkaotpremnicePK().setStavkaotpremniceRB(selektovanaStavka.getStavkaotpremnicePK().getStavkaotpremniceRB());
        trenutnaOtpremnica.getStavkaotpremniceList().remove(selektovanaStavka);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Stavka je obrisana", ""));
        novaStavka = new Stavkaotpremnice();
        novaStavka.setStavkaotpremnicePK(new StavkaotpremnicePK());
        selektovanaStavka = new Stavkaotpremnice();
        selektovanaStavka.setStavkaotpremnicePK(new StavkaotpremnicePK());
        if(trenutnaOtpremnica.getStavkaotpremniceList().size() < 1){
            brojacIzbrisiStavku = 0;
        }
    }

    public String sacuvajOtpremnicuMB() {
        //      System.out.println("Sacuvaj otpremnicu");
        if (trenutnaOtpremnica.getOtpremnicaID() != null) {
            for (Iterator<Stavkaotpremnice> it = trenutnaOtpremnica.getStavkaotpremniceList().iterator(); it.hasNext();) {
                Stavkaotpremnice stavka = it.next();
                stavka.getStavkaotpremnicePK().setOtpremnicaID(trenutnaOtpremnica.getOtpremnicaID());
            }
        }
        trenutnaOtpremnica.setPotvrdjena(false);
        trenutnaOtpremnica.setPotvrdjenaTekst("Nije potvrdjena");
        
        String prvaDva = mbSesija.ulogovaniDistributer.getNaziv().substring(0, 2);
        String drugaDva = String.valueOf(listaOtpZaNaziv.size() + 1);
        String brojOtpremnice = "OTP" + prvaDva + drugaDva;
        trenutnaOtpremnica.setBrojOtpremnice(brojOtpremnice);
        try {
            otpremnicaFacade.izdajOtpremnicu(trenutnaOtpremnica);
    //        trenutnaOtpremnica = new Otpremnica();
    //        novaStavka = new Stavkaotpremnice();
    //        novaStavka.setStavkaotpremnicePK(new StavkaotpremnicePK());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Otpremnica broj " + trenutnaOtpremnica.getBrojOtpremnice() + "je sacuvana", ""));

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sistem ne moze da kreira novu otpremnicu", ""));
        }
        inicijalizujVrednosti();
        return "pocetna";
    }

}
