/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.zus;

import domen.Zdravstvenaustanova;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class SBZus implements SBZusLocal{
    
    @PersistenceContext(unitName = "ZZZLekovi_1PU")
    EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Zdravstvenaustanova vratiZus(Zdravstvenaustanova zus) throws Exception {
        Zdravstvenaustanova zusDB = null;
        try {
            zusDB = (Zdravstvenaustanova)em.createQuery("SELECT z FROM Zdravstvenaustanova z WHERE z.zkorisnickoIme = :zkorisnickoIme").setParameter("zkorisnickoIme", zus.getZkorisnickoIme()).getSingleResult();
        } catch (NoResultException nre) {
            nre.getMessage();
            throw new Exception("Ne postoji korisnik sa tim korisnickim imenom");
        }
        if(zusDB.getZkorisnickaSifra().equals(zus.getZkorisnickaSifra())){
            return zusDB;
        }else{
            throw new Exception("Uneli ste pogresnu sifru za datog korisnika");
        }
    }
    
    public void persist(Object object){
        em.persist(object);
    }

    @Override
    public List<Zdravstvenaustanova> vratiSveZus() {
        return em.createQuery("SELECT z FROM Zdravstvenaustanova z").getResultList();
    }

    @Override
    public void registrujZus(Zdravstvenaustanova zus) {
        em.persist(zus);
    }

    @Override
    public Zdravstvenaustanova vratiZusPoID(Integer id) {
        return em.find(Zdravstvenaustanova.class, id);
    }

    @Override
    public EntityManager vratiEM() {
        return em;
    }

    @Override
    public Zdravstvenaustanova vratiZusPoImenu(String ime) {
        return (Zdravstvenaustanova)em.createQuery("SELECT z FROM Zdravstvenaustanova z WHERE z.zkorisnickoIme = :zkorisnickoIme").setParameter("zkorisnickoIme", ime).getSingleResult();
    }

}
