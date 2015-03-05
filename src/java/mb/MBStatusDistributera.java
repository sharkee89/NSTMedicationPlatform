/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Kvalitativnakvantitativnakontrola;
import domen.Otpremnica;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import session.kkk.SBKkkLocal;
import session.otpremnica.SBOtpremnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean(name = "mbStatusDistributera")
@RequestScoped
public class MBStatusDistributera implements Serializable{
    
    List<Otpremnica> listaOtpremljenih;
    List<Otpremnica> listaPotvdjenih;
    List<Otpremnica> listaNepotvrdjenihl;
    List<Kvalitativnakvantitativnakontrola> listaKkk;
    int botpremljenih;
    int bpotvrdjenih;
    int bnepotvrdjenih;
    int bkkk;
    @EJB
    private SBOtpremnicaLocal otpremnicaFacade;
    @EJB
    private SBKkkLocal kkkFacade;
    @ManagedProperty(value = "#{mbSesija}")
    MBSesija mbSesija;
    /**
     * Creates a new instance of MBStatusDistributera
     */
    public MBStatusDistributera() {
    }
    
    @PostConstruct
    public void inicijalizujPodatke(){
        listaOtpremljenih = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :distID").setParameter("distID",mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        botpremljenih = listaOtpremljenih.size();
        listaPotvdjenih = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :distID AND o.potvrdjena = TRUE").setParameter("distID",mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        bpotvrdjenih = listaPotvdjenih.size();
        listaNepotvrdjenihl = otpremnicaFacade.vratiEM().createQuery("SELECT o FROM Otpremnica o WHERE o.distributerID.distributerID = :distID AND o.potvrdjena = FALSE").setParameter("distID",mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        bnepotvrdjenih = listaNepotvrdjenihl.size();
        listaKkk = kkkFacade.vratiEM().createQuery("SELECT k FROM Kvalitativnakvantitativnakontrola k WHERE k.otpremnicaID.distributerID.distributerID = :kkkID").setParameter("kkkID", mbSesija.ulogovaniDistributer.getDistributerID()).getResultList();
        bkkk = listaKkk.size();
    }

    public List<Otpremnica> getListaOtpremljenih() {
        return listaOtpremljenih;
    }

    public void setListaOtpremljenih(List<Otpremnica> listaOtpremljenih) {
        this.listaOtpremljenih = listaOtpremljenih;
    }

    public List<Otpremnica> getListaPotvdjenih() {
        return listaPotvdjenih;
    }

    public void setListaPotvdjenih(List<Otpremnica> listaPotvdjenih) {
        this.listaPotvdjenih = listaPotvdjenih;
    }

    public List<Otpremnica> getListaNepotvrdjenihl() {
        return listaNepotvrdjenihl;
    }

    public void setListaNepotvrdjenihl(List<Otpremnica> listaNepotvrdjenihl) {
        this.listaNepotvrdjenihl = listaNepotvrdjenihl;
    }

    public List<Kvalitativnakvantitativnakontrola> getListaKkk() {
        return listaKkk;
    }

    public void setListaKkk(List<Kvalitativnakvantitativnakontrola> listaKkk) {
        this.listaKkk = listaKkk;
    }

    public int getBotpremljenih() {
        return botpremljenih;
    }

    public void setBotpremljenih(int botpremljenih) {
        this.botpremljenih = botpremljenih;
    }

    public int getBpotvrdjenih() {
        return bpotvrdjenih;
    }

    public void setBpotvrdjenih(int bpotvrdjenih) {
        this.bpotvrdjenih = bpotvrdjenih;
    }

    public int getBnepotvrdjenih() {
        return bnepotvrdjenih;
    }

    public void setBnepotvrdjenih(int bnepotvrdjenih) {
        this.bnepotvrdjenih = bnepotvrdjenih;
    }

    public int getBkkk() {
        return bkkk;
    }

    public void setBkkk(int bkkk) {
        this.bkkk = bkkk;
    }

    public MBSesija getMbSesija() {
        return mbSesija;
    }

    public void setMbSesija(MBSesija mbSesija) {
        this.mbSesija = mbSesija;
    }
    
    
    
}
