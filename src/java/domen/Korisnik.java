/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "korisnik")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Korisnik.findAll", query = "SELECT k FROM Korisnik k"),
    @NamedQuery(name = "Korisnik.findByKorisnikRB", query = "SELECT k FROM Korisnik k WHERE k.korisnikRB = :korisnikRB"),
    @NamedQuery(name = "Korisnik.findByKorisnickoIme", query = "SELECT k FROM Korisnik k WHERE k.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Korisnik.findByKorisnickaSifra", query = "SELECT k FROM Korisnik k WHERE k.korisnickaSifra = :korisnickaSifra")})
public class Korisnik implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "korisnikRB")
    private Integer korisnikRB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "korisnickoIme")
    private String korisnickoIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "korisnickaSifra")
    private String korisnickaSifra;
    @JoinColumn(name = "zusID", referencedColumnName = "zusID")
    @ManyToOne
    private Zdravstvenaustanova zusID;
    @JoinColumn(name = "distributerID", referencedColumnName = "distributerID")
    @ManyToOne
    private Distributer distributerID;

    public Korisnik() {
    }

    public Korisnik(Integer korisnikRB) {
        this.korisnikRB = korisnikRB;
    }

    public Korisnik(Integer korisnikRB, String korisnickoIme, String korisnickaSifra) {
        this.korisnikRB = korisnikRB;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public Integer getKorisnikRB() {
        return korisnikRB;
    }

    public void setKorisnikRB(Integer korisnikRB) {
        this.korisnikRB = korisnikRB;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    public Zdravstvenaustanova getZusID() {
        return zusID;
    }

    public void setZusID(Zdravstvenaustanova zusID) {
        this.zusID = zusID;
    }

    public Distributer getDistributerID() {
        return distributerID;
    }

    public void setDistributerID(Distributer distributerID) {
        this.distributerID = distributerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnikRB != null ? korisnikRB.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Korisnik)) {
            return false;
        }
        Korisnik other = (Korisnik) object;
        if ((this.korisnikRB == null && other.korisnikRB != null) || (this.korisnikRB != null && !this.korisnikRB.equals(other.korisnikRB))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Korisnik[ korisnikRB=" + korisnikRB + " ]";
    }
    
}
