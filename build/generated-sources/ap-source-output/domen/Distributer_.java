package domen;

import domen.Korisnik;
import domen.Otpremnica;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Distributer.class)
public class Distributer_ { 

    public static volatile SingularAttribute<Distributer, String> poslovnoIme;
    public static volatile SingularAttribute<Distributer, String> maticniBroj;
    public static volatile SingularAttribute<Distributer, String> adresa;
    public static volatile SingularAttribute<Distributer, String> naziv;
    public static volatile ListAttribute<Distributer, Otpremnica> otpremnicaList;
    public static volatile SingularAttribute<Distributer, String> dkorisnickoIme;
    public static volatile SingularAttribute<Distributer, String> dkorisnickaSifra;
    public static volatile SingularAttribute<Distributer, String> status;
    public static volatile SingularAttribute<Distributer, Date> datumOsnivanja;
    public static volatile SingularAttribute<Distributer, String> pib;
    public static volatile SingularAttribute<Distributer, String> pravnaForma;
    public static volatile SingularAttribute<Distributer, Integer> distributerID;
    public static volatile ListAttribute<Distributer, Korisnik> korisnikList;

}