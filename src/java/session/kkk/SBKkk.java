/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.kkk;

import domen.Kvalitativnakvantitativnakontrola;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class SBKkk implements SBKkkLocal{

    @PersistenceContext(unitName = "ZZZLekovi_1PU")
    private EntityManager em;
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Kvalitativnakvantitativnakontrola> vratiSveKkk() {
        return em.createQuery("SELECT k FROM Kvalitativnakvantitativnakontrola k").getResultList();
    }

    @Override
    public Kvalitativnakvantitativnakontrola vratiKkkPoID(Integer id) {
        return em.find(Kvalitativnakvantitativnakontrola.class, id);
    }

    @Override
    public void sacuvajKkk(Kvalitativnakvantitativnakontrola kkk) {
        em.persist(kkk);
    }

    @Override
    public EntityManager vratiEM() {
        return em;
    }

    @Override
    public int vratiRB() {
        if(!vratiSveKkk().isEmpty()){
            return vratiSveKkk().get(vratiSveKkk().size()-1).getKkkID()+1;
        }else{
            return 1;
        }
                
    }
}
