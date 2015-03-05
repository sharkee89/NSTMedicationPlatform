/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.zus;

import domen.Zdravstvenaustanova;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
@Local
public interface SBZusLocal {
    
    public Zdravstvenaustanova vratiZus(Zdravstvenaustanova zus)throws Exception;
    
    List<Zdravstvenaustanova> vratiSveZus();
    
    public void registrujZus(Zdravstvenaustanova zus);
    
    public Zdravstvenaustanova vratiZusPoID(Integer id);
    
    public Zdravstvenaustanova vratiZusPoImenu(String ime);
    
    public EntityManager vratiEM();
    
}
