/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.distributer;

import domen.Distributer;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class SBDistributer implements SBDistributerLocal{
  
    @PersistenceContext(unitName = "ZZZLekovi_1PU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public Distributer vratiDistributera(Distributer distributer) throws Exception {
        Distributer distributerDB = null;
        try {
            distributerDB = (Distributer)em.createQuery("SELECT d FROM Distributer d WHERE d.dkorisnickoIme = :dkorisnickoIme").setParameter("dkorisnickoIme", distributer.getDkorisnickoIme()).getSingleResult();
            
        } catch (NoResultException nre) {
            nre.getMessage();
            throw new Exception("Ne postoji korisnik sa tim korisnickim imenom");
        }
        if(distributerDB.getDkorisnickaSifra().equals(distributer.getDkorisnickaSifra())){
            return distributerDB; 
        }else{
            throw new Exception("Pogresno ste uneli sifru za datog korisnika");
        }
        
          
    }
    
    public void persist(Object object){
        em.persist(object);
    }

    @Override
    public void registrujDistributera(Distributer dist) {
        em.persist(dist);
    }

    @Override
    public List<Distributer> vratiSveDistributere() {
        return em.createQuery("SELECT d FROM Distributer d").getResultList();
    }

    @Override
    public Distributer vratiDistributeraPoID(Integer id) {
        return em.find(Distributer.class, id);
    }
    
    

    @Override
    public EntityManager vratiEM() {
        return em;
    }

    @Override
    public Distributer vratiDistributerPoImenu(String ime) {
        return (Distributer)em.createQuery("SELECT d FROM Distributer d WHERE d.dkorisnickoIme = :dkorisnickoIme").setParameter("dkorisnickoIme", ime).getSingleResult();
    }




}
