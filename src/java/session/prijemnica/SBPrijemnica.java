/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.prijemnica;

import domen.Prijemnica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class SBPrijemnica implements SBPrijemnicaLocal{
    
    @PersistenceContext(unitName = "ZZZLekovi_1PU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Prijemnica> vratiSvePrijemnice() {
        return em.createQuery("SELECT p FROM Prijemnica p").getResultList();
    }

    @Override
    public Prijemnica vratiPrijemnicuPoID(Integer id) {
        return em.find(Prijemnica.class, id);
    }

    @Override
    public EntityManager vratiEm() {
        return em;
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void sacuvajPrijemnicu(Prijemnica pri) {
        em.persist(pri);
    }

    @Override
    public int vratiRB() {
        if(!vratiSvePrijemnice().isEmpty()){
            return vratiSvePrijemnice().get(vratiSvePrijemnice().size()-1).getPrijemnicaID()+1;
        }else{
            return 1;
        }
                
    }
}
