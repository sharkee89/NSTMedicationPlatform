/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "stavkaotpremnice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavkaotpremnice.findAll", query = "SELECT s FROM Stavkaotpremnice s"),
    @NamedQuery(name = "Stavkaotpremnice.findByOtpremnicaID", query = "SELECT s FROM Stavkaotpremnice s WHERE s.stavkaotpremnicePK.otpremnicaID = :otpremnicaID"),
    @NamedQuery(name = "Stavkaotpremnice.findByStavkaotpremniceRB", query = "SELECT s FROM Stavkaotpremnice s WHERE s.stavkaotpremnicePK.stavkaotpremniceRB = :stavkaotpremniceRB"),
    @NamedQuery(name = "Stavkaotpremnice.findByKolicina", query = "SELECT s FROM Stavkaotpremnice s WHERE s.kolicina = :kolicina")})
public class Stavkaotpremnice implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkaotpremnicePK stavkaotpremnicePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolicina")
    private double kolicina;
    @JoinColumn(name = "lekSerijskiBroj", referencedColumnName = "lekSerijskiBroj")
    @ManyToOne
    private Lek lekSerijskiBroj;
    @JoinColumn(name = "otpremnicaID", referencedColumnName = "otpremnicaID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Otpremnica otpremnica;

    public Stavkaotpremnice() {
    }

    public Stavkaotpremnice(StavkaotpremnicePK stavkaotpremnicePK) {
        this.stavkaotpremnicePK = stavkaotpremnicePK;
    }

    public Stavkaotpremnice(StavkaotpremnicePK stavkaotpremnicePK, double kolicina) {
        this.stavkaotpremnicePK = stavkaotpremnicePK;
        this.kolicina = kolicina;
    }

    public Stavkaotpremnice(int otpremnicaID, int stavkaotpremniceRB) {
        this.stavkaotpremnicePK = new StavkaotpremnicePK(otpremnicaID, stavkaotpremniceRB);
    }

    public StavkaotpremnicePK getStavkaotpremnicePK() {
        return stavkaotpremnicePK;
    }

    public void setStavkaotpremnicePK(StavkaotpremnicePK stavkaotpremnicePK) {
        this.stavkaotpremnicePK = stavkaotpremnicePK;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public Lek getLekSerijskiBroj() {
        return lekSerijskiBroj;
    }

    public void setLekSerijskiBroj(Lek lekSerijskiBroj) {
        this.lekSerijskiBroj = lekSerijskiBroj;
    }

    public Otpremnica getOtpremnica() {
        return otpremnica;
    }

    public void setOtpremnica(Otpremnica otpremnica) {
        this.otpremnica = otpremnica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkaotpremnicePK != null ? stavkaotpremnicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavkaotpremnice)) {
            return false;
        }
        Stavkaotpremnice other = (Stavkaotpremnice) object;
        if ((this.stavkaotpremnicePK == null && other.stavkaotpremnicePK != null) || (this.stavkaotpremnicePK != null && !this.stavkaotpremnicePK.equals(other.stavkaotpremnicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Stavkaotpremnice[ stavkaotpremnicePK=" + stavkaotpremnicePK + " ]";
    }
    
}
