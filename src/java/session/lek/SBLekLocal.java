/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.lek;

import domen.Lek;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Stefan
 */
@Local
public interface SBLekLocal {
    
    List<Lek> vratiSveLekove();
    
    public Lek vratiLekPoId(int id);
    
    public void sacuvajLek(Lek l);
    
}
