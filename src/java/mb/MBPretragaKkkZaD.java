/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Kvalitativnakvantitativnakontrola;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import session.kkk.SBKkkLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbPretragaKkkZaD")
@RequestScoped
public class MBPretragaKkkZaD {
    
    List<Kvalitativnakvantitativnakontrola> listaKkkZaD;
    private Kvalitativnakvantitativnakontrola kkk;
    @EJB
    private SBKkkLocal kkkFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBPretragaKkk
     */
    public MBPretragaKkkZaD() {
        kkk = new Kvalitativnakvantitativnakontrola();
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        kkk = new Kvalitativnakvantitativnakontrola();
        listaKkkZaD = kkkFacade.vratiEM().createQuery("SELECT k FROM Kvalitativnakvantitativnakontrola k WHERE k.otpremnicaID.distributerID.distributerID = :kkkID").setParameter("kkkID", mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
    }

    public List<Kvalitativnakvantitativnakontrola> getListaKkkZaD() {
        return listaKkkZaD;
    }

    public void setListaKkkZaD(List<Kvalitativnakvantitativnakontrola> listaKkkZaD) {
        this.listaKkkZaD = listaKkkZaD;
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
    
    public String vratiKkkPoIDMBZaD(){
        kkk = kkkFacade.vratiKkkPoID(kkk.getKkkID());
        return "pretragaKkk";
    }
    
}
