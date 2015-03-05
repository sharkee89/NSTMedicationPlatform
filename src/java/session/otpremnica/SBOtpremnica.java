/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session.otpremnica;

import domen.Otpremnica;
import static domen.Stavkaotpremnice_.otpremnica;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Stefan
 */
@Stateless
public class SBOtpremnica implements SBOtpremnicaLocal{
    @PersistenceContext (unitName = "ZZZLekovi_1PU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public EntityManager vratiEM() {
        return em;
    }

    @Override
    public Otpremnica vratiOtpremnicaPoID(Integer id) {
        return em.find(Otpremnica.class, id);
    }

    
    
    @Override
    public void sacuvajOtpremnicu(Otpremnica otp) {
        Otpremnica otpDB = em.find(Otpremnica.class, otp.getOtpremnicaID());
        if(otpDB==null){
            em.persist(otp);
        }else{
            em.merge(otp);
        }
    }
    
    public void remove(Otpremnica otp){
        em.remove(otp);
    }

    @Override
    public void izbrisiOtpremnicu(Otpremnica otp){     
       otp = em.getReference(Otpremnica.class, otp.getOtpremnicaID());
       em.remove(otp);
           
    }

    @Override
    public List<Otpremnica> vratiSveOtpremnice() {
        return em.createQuery("SELECT o FROM Otpremnica o").getResultList();
    }

    @Override
    public void izdajOtpremnicu(Otpremnica otp) {
        em.persist(otp);
    }

    @Override
    public int vratiRB() {
       if(!vratiSveOtpremnice().isEmpty()){
           return vratiSveOtpremnice().get(vratiSveOtpremnice().size()-1).getOtpremnicaID()+1;
       }else{
           return 1;
       }
    }
    

    
    
}
