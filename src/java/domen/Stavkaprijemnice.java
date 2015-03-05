/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "stavkaprijemnice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Stavkaprijemnice.findAll", query = "SELECT s FROM Stavkaprijemnice s"),
    @NamedQuery(name = "Stavkaprijemnice.findByPrijemnicaID", query = "SELECT s FROM Stavkaprijemnice s WHERE s.stavkaprijemnicePK.prijemnicaID = :prijemnicaID"),
    @NamedQuery(name = "Stavkaprijemnice.findByStavkaprijemniceRB", query = "SELECT s FROM Stavkaprijemnice s WHERE s.stavkaprijemnicePK.stavkaprijemniceRB = :stavkaprijemniceRB"),
    @NamedQuery(name = "Stavkaprijemnice.findByKolicina", query = "SELECT s FROM Stavkaprijemnice s WHERE s.kolicina = :kolicina")})
public class Stavkaprijemnice implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StavkaprijemnicePK stavkaprijemnicePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kolicina")
    private Double kolicina;
    @JoinColumn(name = "lekSerijskiBroj", referencedColumnName = "lekSerijskiBroj")
    @ManyToOne
    private Lek lekSerijskiBroj;
    @JoinColumn(name = "prijemnicaID", referencedColumnName = "prijemnicaID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prijemnica prijemnica;

    public Stavkaprijemnice() {
    }

    public Stavkaprijemnice(StavkaprijemnicePK stavkaprijemnicePK) {
        this.stavkaprijemnicePK = stavkaprijemnicePK;
    }

    public Stavkaprijemnice(int prijemnicaID, int stavkaprijemniceRB) {
        this.stavkaprijemnicePK = new StavkaprijemnicePK(prijemnicaID, stavkaprijemniceRB);
    }

    public StavkaprijemnicePK getStavkaprijemnicePK() {
        return stavkaprijemnicePK;
    }

    public void setStavkaprijemnicePK(StavkaprijemnicePK stavkaprijemnicePK) {
        this.stavkaprijemnicePK = stavkaprijemnicePK;
    }

    public Double getKolicina() {
        return kolicina;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }

    public Lek getLekSerijskiBroj() {
        return lekSerijskiBroj;
    }

    public void setLekSerijskiBroj(Lek lekSerijskiBroj) {
        this.lekSerijskiBroj = lekSerijskiBroj;
    }

    public Prijemnica getPrijemnica() {
        return prijemnica;
    }

    public void setPrijemnica(Prijemnica prijemnica) {
        this.prijemnica = prijemnica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stavkaprijemnicePK != null ? stavkaprijemnicePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Stavkaprijemnice)) {
            return false;
        }
        Stavkaprijemnice other = (Stavkaprijemnice) object;
        if ((this.stavkaprijemnicePK == null && other.stavkaprijemnicePK != null) || (this.stavkaprijemnicePK != null && !this.stavkaprijemnicePK.equals(other.stavkaprijemnicePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Stavkaprijemnice[ stavkaprijemnicePK=" + stavkaprijemnicePK + " ]";
    }
    
}
