/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.korisnik;

import domen.Korisnik;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author Stefan
 */
@Local
public interface SBKorisnikLocal {
    
    public Korisnik vratiKorisnika(Korisnik korisnik) throws Exception;
    
    public void sacuvajKorisnika(Korisnik korisnik);
    
    List<Korisnik> vratiSveKorisnike();
    
    public EntityManager vratiEM();
}
