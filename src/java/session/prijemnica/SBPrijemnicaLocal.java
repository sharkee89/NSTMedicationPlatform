/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.prijemnica;

import domen.Prijemnica;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
@Local
public interface SBPrijemnicaLocal {
    
    List<Prijemnica> vratiSvePrijemnice();
    
    public Prijemnica vratiPrijemnicuPoID(Integer id);
    
    public Prijemnica vratiPrijemnicuPoOtpID(Integer id);
    
    public void sacuvajPrijemnicu(Prijemnica pri);
    
    public int vratiRB();
    
    public EntityManager vratiEm();
    
}
