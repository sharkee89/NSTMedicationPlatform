/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Kvalitativnakvantitativnakontrola;
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
@ManagedBean( name = "mbPrikazKKKZaOtpremnicu")
@RequestScoped
public class MBPrikazKKKZaOtpremnicu {
    
    private Kvalitativnakvantitativnakontrola kkk;
    @EJB
    private SBKkkLocal kkkFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;
    
    @PostConstruct
    public void inicijalizujPodatke(){
        kkk = new Kvalitativnakvantitativnakontrola();
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
    
    public String prikaziKKKZaPrijemnicu(int id){
        
        kkk = kkkFacade.vratiKKKPoOID(id);
        return "kkkzaotpremnicu";
    }
    
    
    
}
