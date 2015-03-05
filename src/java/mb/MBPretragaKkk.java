/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Kvalitativnakvantitativnakontrola;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import session.kkk.SBKkkLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbPretragaKkk")
@RequestScoped
public class MBPretragaKkk {
    
    List<Kvalitativnakvantitativnakontrola> listaKkk;
    private Kvalitativnakvantitativnakontrola kkk;
    @EJB
    private SBKkkLocal kkkFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBPretragaKkk
     */
    public MBPretragaKkk() {
        kkk = new Kvalitativnakvantitativnakontrola();
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        kkk = new Kvalitativnakvantitativnakontrola();
        listaKkk = kkkFacade.vratiEM().createQuery("SELECT k FROM Kvalitativnakvantitativnakontrola k WHERE k.prijemnicaID.zusID.zusID = :kkkID").setParameter("kkkID", mbSesija.ulogovaniZus.getZusID()).getResultList();
    }

    public List<Kvalitativnakvantitativnakontrola> getListaKkk() {
        return listaKkk;
    }

    public void setListaKkk(List<Kvalitativnakvantitativnakontrola> listaKkk) {
        this.listaKkk = listaKkk;
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
    
    public String vratiKkkPoIDMB(){
        kkk = kkkFacade.vratiKkkPoID(kkk.getKkkID());
        return "pretragaKkk";
    }
    
}
