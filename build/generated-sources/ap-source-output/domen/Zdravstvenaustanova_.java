package domen;

import domen.Korisnik;
import domen.Otpremnica;
import domen.Prijemnica;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Zdravstvenaustanova.class)
public class Zdravstvenaustanova_ { 

    public static volatile SingularAttribute<Zdravstvenaustanova, String> adresa;
    public static volatile SingularAttribute<Zdravstvenaustanova, String> maticniBroj;
    public static volatile SingularAttribute<Zdravstvenaustanova, String> naziv;
    public static volatile ListAttribute<Zdravstvenaustanova, Otpremnica> otpremnicaList;
    public static volatile ListAttribute<Zdravstvenaustanova, Prijemnica> prijemnicaList;
    public static volatile SingularAttribute<Zdravstvenaustanova, Integer> zusID;
    public static volatile SingularAttribute<Zdravstvenaustanova, String> registarskiBroj;
    public static volatile SingularAttribute<Zdravstvenaustanova, String> pib;
    public static volatile SingularAttribute<Zdravstvenaustanova, String> zkorisnickoIme;
    public static volatile SingularAttribute<Zdravstvenaustanova, String> zkorisnickaSifra;
    public static volatile ListAttribute<Zdravstvenaustanova, Korisnik> korisnikList;

}