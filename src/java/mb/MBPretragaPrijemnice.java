/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Prijemnica;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import session.prijemnica.SBPrijemnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbPretragaPrijemnice")
@RequestScoped
public class MBPretragaPrijemnice {

    List<Prijemnica> listaPrijemnica;
    private Prijemnica prijemnica;
    @EJB
    private SBPrijemnicaLocal prijemnicaFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;
    /**
     * Creates a new instance of MBPretragaPrijemnice
     */
    public MBPretragaPrijemnice() {
        prijemnica = new Prijemnica();
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        prijemnica = new Prijemnica();
        listaPrijemnica = prijemnicaFacade.vratiEm().createQuery("SELECT p FROM Prijemnica p WHERE p.zusID.zusID = :zusID").setParameter("zusID", mbSesija.ulogovaniZus.getZusID()).getResultList();
    }

    public List<Prijemnica> getListaPrijemnica() {
        return listaPrijemnica;
    }

    public void setListaPrijemnica(List<Prijemnica> listaPrijemnica) {
        this.listaPrijemnica = listaPrijemnica;
    }

    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    public String vratiPrijemnicuPoIDMB(){
        prijemnica = prijemnicaFacade.vratiPrijemnicuPoID(prijemnica.getPrijemnicaID());
        return "pretragaprijemnice";
    }
    
}
