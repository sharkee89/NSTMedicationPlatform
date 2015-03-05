/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.lek;

import domen.Lek;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class SBLek implements SBLekLocal{

@PersistenceContext (unitName = "ZZZLekovi_1PU")
EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Lek> vratiSveLekove() {
        return em.createQuery("SELECT l FROM Lek l").getResultList();
    }

    @Override
    public Lek vratiLekPoId(int id) {
        return em.find(Lek.class, id);
    }

    public void persist(Object o){
        em.persist(o);
    }
    
    @Override
    public void sacuvajLek(Lek l) {
        em.persist(l);
    }
    
    

    
}
