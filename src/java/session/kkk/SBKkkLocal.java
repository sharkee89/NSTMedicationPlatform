/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.kkk;

import domen.Kvalitativnakvantitativnakontrola;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
@Local
public interface SBKkkLocal {
    
    List<Kvalitativnakvantitativnakontrola> vratiSveKkk();
    
    public Kvalitativnakvantitativnakontrola vratiKkkPoID(Integer id);
    
    public void sacuvajKkk(Kvalitativnakvantitativnakontrola kkk);
    
    public int vratiRB();
    
    public EntityManager vratiEM();
    
    public Kvalitativnakvantitativnakontrola vratiKKKPoPID(int id);
    
    public Kvalitativnakvantitativnakontrola vratiKKKPoOID(int id);
    
}
