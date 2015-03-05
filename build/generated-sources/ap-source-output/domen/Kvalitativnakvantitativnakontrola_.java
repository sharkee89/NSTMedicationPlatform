package domen;

import domen.Otpremnica;
import domen.Prijemnica;
import domen.Stavkakkk;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Kvalitativnakvantitativnakontrola.class)
public class Kvalitativnakvantitativnakontrola_ { 

    public static volatile SingularAttribute<Kvalitativnakvantitativnakontrola, Integer> kkkID;
    public static volatile SingularAttribute<Kvalitativnakvantitativnakontrola, Prijemnica> prijemnicaID;
    public static volatile ListAttribute<Kvalitativnakvantitativnakontrola, Stavkakkk> stavkakkkList;
    public static volatile SingularAttribute<Kvalitativnakvantitativnakontrola, String> brojKkk;
    public static volatile SingularAttribute<Kvalitativnakvantitativnakontrola, Date> datum;
    public static volatile SingularAttribute<Kvalitativnakvantitativnakontrola, Otpremnica> otpremnicaID;

}