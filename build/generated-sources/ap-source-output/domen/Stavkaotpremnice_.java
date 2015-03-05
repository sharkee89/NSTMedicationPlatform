package domen;

import domen.Lek;
import domen.Otpremnica;
import domen.StavkaotpremnicePK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-03-11T12:40:34")
@StaticMetamodel(Stavkaotpremnice.class)
public class Stavkaotpremnice_ { 

    public static volatile SingularAttribute<Stavkaotpremnice, Lek> lekSerijskiBroj;
    public static volatile SingularAttribute<Stavkaotpremnice, StavkaotpremnicePK> stavkaotpremnicePK;
    public static volatile SingularAttribute<Stavkaotpremnice, Double> kolicina;
    public static volatile SingularAttribute<Stavkaotpremnice, Otpremnica> otpremnica;

}