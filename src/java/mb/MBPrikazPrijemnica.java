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
@ManagedBean(name = "mbPrikazPrijemnica")
@RequestScoped
public class MBPrikazPrijemnica implements Serializable{
    
    private List<Prijemnica> listaPrijemnica;
    @EJB
    private SBPrijemnicaLocal prijemnicaFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;

    /**
     * Creates a new instance of MBPrikazPrijemnica
     */
    public MBPrikazPrijemnica() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        listaPrijemnica = prijemnicaFacade.vratiEm().createQuery("SELECT p FROM Prijemnica p WHERE p.zusID.zusID = :zusID").setParameter("zusID", mbSesija.ulogovaniZus.getZusID()).getResultList();
    }

    public List<Prijemnica> getListaPrijemnica() {
        return listaPrijemnica;
    }

    public void setListaPrijemnica(List<Prijemnica> listaPrijemnica) {
        this.listaPrijemnica = listaPrijemnica;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    
    
}
