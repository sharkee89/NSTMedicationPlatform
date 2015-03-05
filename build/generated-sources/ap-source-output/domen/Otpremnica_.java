package domen;

import domen.Distributer;
import domen.Kvalitativnakvantitativnakontrola;
import domen.Prijemnica;
import domen.Stavkaotpremnice;
import domen.Zdravstvenaustanova;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Otpremnica.class)
public class Otpremnica_ { 

    public static volatile SingularAttribute<Otpremnica, Boolean> potvrdjena;
    public static volatile ListAttribute<Otpremnica, Kvalitativnakvantitativnakontrola> kvalitativnakvantitativnakontrolaList;
    public static volatile ListAttribute<Otpremnica, Prijemnica> prijemnicaList;
    public static volatile SingularAttribute<Otpremnica, Zdravstvenaustanova> zusID;
    public static volatile SingularAttribute<Otpremnica, String> potvrdjenaTekst;
    public static volatile SingularAttribute<Otpremnica, String> brojOtpremnice;
    public static volatile ListAttribute<Otpremnica, Stavkaotpremnice> stavkaotpremniceList;
    public static volatile SingularAttribute<Otpremnica, Date> datum;
    public static volatile SingularAttribute<Otpremnica, Integer> otpremnicaID;
    public static volatile SingularAttribute<Otpremnica, Distributer> distributerID;

}