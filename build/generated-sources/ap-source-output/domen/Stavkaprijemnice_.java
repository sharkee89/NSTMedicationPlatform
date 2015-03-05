package domen;

import domen.Lek;
import domen.Prijemnica;
import domen.StavkaprijemnicePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Stavkaprijemnice.class)
public class Stavkaprijemnice_ { 

    public static volatile SingularAttribute<Stavkaprijemnice, Lek> lekSerijskiBroj;
    public static volatile SingularAttribute<Stavkaprijemnice, Double> kolicina;
    public static volatile SingularAttribute<Stavkaprijemnice, Prijemnica> prijemnica;
    public static volatile SingularAttribute<Stavkaprijemnice, StavkaprijemnicePK> stavkaprijemnicePK;

}