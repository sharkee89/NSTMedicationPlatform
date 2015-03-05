/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.distributer;

import domen.Distributer;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
@Local
public interface SBDistributerLocal {
    
    public Distributer vratiDistributera(Distributer distributer) throws Exception;
    
    List<Distributer> vratiSveDistributere();
    
    public void registrujDistributera(Distributer dist);
    
    public Distributer vratiDistributeraPoID(Integer id);
    
    public Distributer vratiDistributerPoImenu(String ime);
    
    public EntityManager vratiEM();
    
}
