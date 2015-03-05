/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.otpremnica;

import domen.Otpremnica;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
@Local
public interface SBOtpremnicaLocal {
    
    List<Otpremnica> vratiSveOtpremnice();
    
    public Otpremnica vratiOtpremnicaPoID(Integer id);
    
    public void sacuvajOtpremnicu(Otpremnica otp);
    
    public void izdajOtpremnicu(Otpremnica otp);
    
    public void izbrisiOtpremnicu(Otpremnica otp);
    
    public int vratiRB();
    
    public EntityManager vratiEM();
}
