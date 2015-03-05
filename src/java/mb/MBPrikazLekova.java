/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Lek;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import session.lek.SBLekLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbPrikazLekova")
@RequestScoped
public class MBPrikazLekova implements Serializable{
    
    List<Lek> listaLekova;
    @EJB
    private SBLekLocal lekFacade;

    /**
     * Creates a new instance of MBPrikazLekova
     */
    public MBPrikazLekova() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        listaLekova = lekFacade.vratiSveLekove();
    }

    public List<Lek> getListaLekova() {
        return listaLekova;
    }

    public void setListaLekova(List<Lek> listaLekova) {
        this.listaLekova = listaLekova;
    }
    
    
    
}
