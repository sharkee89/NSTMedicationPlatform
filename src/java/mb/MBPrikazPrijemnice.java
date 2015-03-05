/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Otpremnica;
import domen.Prijemnica;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import session.otpremnica.SBOtpremnicaLocal;

/**
 *
 * @author Stefan
 */
@ManagedBean( name = "mbPrikazPrijemnice")
@ViewScoped
public class MBPrikazPrijemnice implements Serializable{
    
    private Otpremnica otpremnica;
    private Prijemnica prijemnica;
    private SelectItem[] listaPotvrda;
    private String[] potvrde;
    private String korektnost;
    @EJB
    private SBOtpremnicaLocal otpremnicaFacade;
    @ManagedProperty (value = "#{mbSesija}")
    MBSesija mbSesija;
}
