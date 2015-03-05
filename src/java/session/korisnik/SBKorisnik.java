/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.korisnik;

import domen.Korisnik;
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
public class SBKorisnik implements SBKorisnikLocal{
    
    @PersistenceContext(unitName = "ZZZLekovi_1PU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Korisnik vratiKorisnika(Korisnik korisnik) throws Exception{
        Korisnik korisnikDB = null;
        try {
            korisnikDB = (Korisnik)em.createQuery("SELECT k FROM Korisnik k WHERE k.korisnickoIme = :korisnickoIme").setParameter("korisnickoIme", korisnik.getKorisnickoIme()).getSingleResult();
            
        } catch (NoResultException nre) {
            nre.getMessage();
            throw new Exception("Ne postoji korisnik sa tim korisnickim imenom");
        }
        if(korisnikDB.getKorisnickaSifra().equals(korisnik.getKorisnickaSifra())){
            return korisnikDB; 
        }else{
            throw new Exception("Pogresno ste uneli sifru za datog korisnika");
        }
    }
    
    public void persist(Object object){
        em.persist(object);
    }

    @Override
    public void sacuvajKorisnika(Korisnik korisnik) {
        em.persist(korisnik);
    }

    @Override
    public List<Korisnik> vratiSveKorisnike() {
        return em.createQuery("SELECT k FROM Korisnik k").getResultList();
    }

    @Override
    public EntityManager vratiEM() {
        return em;
    }


    
}
