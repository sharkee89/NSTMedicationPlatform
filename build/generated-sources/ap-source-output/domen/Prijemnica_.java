package domen;

import domen.Kvalitativnakvantitativnakontrola;
import domen.Otpremnica;
import domen.Stavkaprijemnice;
import domen.Zdravstvenaustanova;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Prijemnica.class)
public class Prijemnica_ { 

    public static volatile ListAttribute<Prijemnica, Kvalitativnakvantitativnakontrola> kvalitativnakvantitativnakontrolaList;
    public static volatile SingularAttribute<Prijemnica, Integer> prijemnicaID;
    public static volatile SingularAttribute<Prijemnica, Zdravstvenaustanova> zusID;
    public static volatile SingularAttribute<Prijemnica, String> brojPrijemnice;
    public static volatile SingularAttribute<Prijemnica, Date> datum;
    public static volatile SingularAttribute<Prijemnica, Otpremnica> otpremnicaID;
    public static volatile ListAttribute<Prijemnica, Stavkaprijemnice> stavkaprijemniceList;

}