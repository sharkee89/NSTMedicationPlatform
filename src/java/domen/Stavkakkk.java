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
@Table(name = "stavkakkk")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavkakkk.findAll", query = "SELECT s FROM Stavkakkk s"),
    @NamedQuery(name = "Stavkakkk.findByKkkID", query = "SELECT s FROM Stavkakkk s WHERE s.stavkakkkPK.kkkID = :kkkID"),
    @NamedQuery(name = "Stavkakkk.findByStavkaKKKRB", query = "SELECT s FROM Stavkakkk s WHERE s.stavkakkkPK.stavkaKKKRB = :stavkaKKKRB"),
    @NamedQuery(name = "Stavkakkk.findByKolicina", query = "SELECT s FROM Stavkakkk s WHERE s.kolicina = :kolicina")})
public class Stavkakkk implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkakkkPK stavkakkkPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kolicina")
    private double kolicina;
    @JoinColumn(name = "lekSerijskiBroj", referencedColumnName = "lekSerijskiBroj")
    @ManyToOne(optional = false)
    private Lek lekSerijskiBroj;
    @JoinColumn(name = "kkkID", referencedColumnName = "kkkID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Kvalitativnakvantitativnakontrola kvalitativnakvantitativnakontrola;

    public Stavkakkk() {
    }

    public Stavkakkk(StavkakkkPK stavkakkkPK) {
        this.stavkakkkPK = stavkakkkPK;
    }

    public Stavkakkk(StavkakkkPK stavkakkkPK, double kolicina) {
        this.stavkakkkPK = stavkakkkPK;
        this.kolicina = kolicina;
    }

    public Stavkakkk(int kkkID, int stavkaKKKRB) {
        this.stavkakkkPK = new StavkakkkPK(kkkID, stavkaKKKRB);
    }

    public StavkakkkPK getStavkakkkPK() {
        return stavkakkkPK;
    }

    public void setStavkakkkPK(StavkakkkPK stavkakkkPK) {
        this.stavkakkkPK = stavkakkkPK;
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

    public Kvalitativnakvantitativnakontrola getKvalitativnakvantitativnakontrola() {
        return kvalitativnakvantitativnakontrola;
    }

    public void setKvalitativnakvantitativnakontrola(Kvalitativnakvantitativnakontrola kvalitativnakvantitativnakontrola) {
        this.kvalitativnakvantitativnakontrola = kvalitativnakvantitativnakontrola;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkakkkPK != null ? stavkakkkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavkakkk)) {
            return false;
        }
        Stavkakkk other = (Stavkakkk) object;
        if ((this.stavkakkkPK == null && other.stavkakkkPK != null) || (this.stavkakkkPK != null && !this.stavkakkkPK.equals(other.stavkakkkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Stavkakkk[ stavkakkkPK=" + stavkakkkPK + " ]";
    }
    
}
