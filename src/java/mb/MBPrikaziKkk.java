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
import session.kkk.SBKkkLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbPrikaziKkk")
@RequestScoped
public class MBPrikaziKkk implements Serializable{
    
    List<Kvalitativnakvantitativnakontrola> listaKkk;
    private Kvalitativnakvantitativnakontrola selektovanKkk;
    @EJB
    private SBKkkLocal kkkFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;
    
    /**
     * Creates a new instance of MBPrikaziKkk
     */
    public MBPrikaziKkk() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        listaKkk = kkkFacade.vratiEM().createQuery("SELECT k FROM Kvalitativnakvantitativnakontrola k WHERE k.otpremnicaID.distributerID.distributerID = :kkkID").setParameter("kkkID", mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
    }

    public List<Kvalitativnakvantitativnakontrola> getListaKkk() {
        return listaKkk;
    }

    public void setListaKkk(List<Kvalitativnakvantitativnakontrola> listaKkk) {
        this.listaKkk = listaKkk;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }

    public Kvalitativnakvantitativnakontrola getSelektovanKkk() {
        return selektovanKkk;
    }

    public void setSelektovanKkk(Kvalitativnakvantitativnakontrola selektovanKkk) {
        this.selektovanKkk = selektovanKkk;
    }
    
    
    
}
