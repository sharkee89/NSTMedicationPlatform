package domen;

import domen.Distributer;
import domen.Zdravstvenaustanova;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, Zdravstvenaustanova> zusID;
    public static volatile SingularAttribute<Korisnik, Integer> korisnikRB;
    public static volatile SingularAttribute<Korisnik, String> korisnickaSifra;
    public static volatile SingularAttribute<Korisnik, String> korisnickoIme;
    public static volatile SingularAttribute<Korisnik, Distributer> distributerID;

}