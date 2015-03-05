package domen;

import domen.Stavkakkk;
import domen.Stavkaotpremnice;
import domen.Stavkaprijemnice;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Lek.class)
public class Lek_ { 

    public static volatile SingularAttribute<Lek, Date> datumResenja;
    public static volatile SingularAttribute<Lek, String> generickiNaziv;
    public static volatile SingularAttribute<Lek, String> proizvodjac;
    public static volatile SingularAttribute<Lek, String> brojResenja;
    public static volatile SingularAttribute<Lek, String> nosiocDozvola;
    public static volatile SingularAttribute<Lek, String> jkl;
    public static volatile SingularAttribute<Lek, String> naziv;
    public static volatile SingularAttribute<Lek, Integer> lekSerijskiBroj;
    public static volatile SingularAttribute<Lek, String> rezimIzdavanja;
    public static volatile ListAttribute<Lek, Stavkaotpremnice> stavkaotpremniceList;
    public static volatile ListAttribute<Lek, Stavkakkk> stavkakkkList;
    public static volatile SingularAttribute<Lek, String> atc;
    public static volatile SingularAttribute<Lek, String> vrstaLeka;
    public static volatile SingularAttribute<Lek, Double> cena;
    public static volatile ListAttribute<Lek, Stavkaprijemnice> stavkaprijemniceList;

}