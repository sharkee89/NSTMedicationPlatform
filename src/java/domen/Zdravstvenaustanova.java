/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "zdravstvenaustanova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zdravstvenaustanova.findAll", query = "SELECT z FROM Zdravstvenaustanova z"),
    @NamedQuery(name = "Zdravstvenaustanova.findByZusID", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.zusID = :zusID"),
    @NamedQuery(name = "Zdravstvenaustanova.findByZkorisnickoIme", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.zkorisnickoIme = :zkorisnickoIme"),
    @NamedQuery(name = "Zdravstvenaustanova.findByZkorisnickaSifra", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.zkorisnickaSifra = :zkorisnickaSifra"),
    @NamedQuery(name = "Zdravstvenaustanova.findByNaziv", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.naziv = :naziv"),
    @NamedQuery(name = "Zdravstvenaustanova.findByAdresa", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.adresa = :adresa"),
    @NamedQuery(name = "Zdravstvenaustanova.findByPib", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.pib = :pib"),
    @NamedQuery(name = "Zdravstvenaustanova.findByMaticniBroj", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.maticniBroj = :maticniBroj"),
    @NamedQuery(name = "Zdravstvenaustanova.findByRegistarskiBroj", query = "SELECT z FROM Zdravstvenaustanova z WHERE z.registarskiBroj = :registarskiBroj")})
public class Zdravstvenaustanova implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zusID")
    private Integer zusID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "zkorisnickoIme")
    private String zkorisnickoIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "zkorisnickaSifra")
    private String zkorisnickaSifra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "adresa")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pib")
    private String pib;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "maticniBroj")
    private String maticniBroj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "registarskiBroj")
    private String registarskiBroj;
    @OneToMany(mappedBy = "zusID")
    private List<Korisnik> korisnikList;
    @OneToMany(mappedBy = "zusID")
    private List<Prijemnica> prijemnicaList;
    @OneToMany(mappedBy = "zusID")
    private List<Otpremnica> otpremnicaList;

    public Zdravstvenaustanova() {
    }

    public Zdravstvenaustanova(Integer zusID) {
        this.zusID = zusID;
    }

    public Zdravstvenaustanova(Integer zusID, String zkorisnickoIme, String zkorisnickaSifra, String naziv, String adresa, String pib, String maticniBroj, String registarskiBroj) {
        this.zusID = zusID;
        this.zkorisnickoIme = zkorisnickoIme;
        this.zkorisnickaSifra = zkorisnickaSifra;
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.registarskiBroj = registarskiBroj;
    }

    public Integer getZusID() {
        return zusID;
    }

    public void setZusID(Integer zusID) {
        this.zusID = zusID;
    }

    public String getZkorisnickoIme() {
        return zkorisnickoIme;
    }

    public void setZkorisnickoIme(String zkorisnickoIme) {
        this.zkorisnickoIme = zkorisnickoIme;
    }

    public String getZkorisnickaSifra() {
        return zkorisnickaSifra;
    }

    public void setZkorisnickaSifra(String zkorisnickaSifra) {
        this.zkorisnickaSifra = zkorisnickaSifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getRegistarskiBroj() {
        return registarskiBroj;
    }

    public void setRegistarskiBroj(String registarskiBroj) {
        this.registarskiBroj = registarskiBroj;
    }

    @XmlTransient
    public List<Korisnik> getKorisnikList() {
        return korisnikList;
    }

    public void setKorisnikList(List<Korisnik> korisnikList) {
        this.korisnikList = korisnikList;
    }

    @XmlTransient
    public List<Prijemnica> getPrijemnicaList() {
        return prijemnicaList;
    }

    public void setPrijemnicaList(List<Prijemnica> prijemnicaList) {
        this.prijemnicaList = prijemnicaList;
    }

    @XmlTransient
    public List<Otpremnica> getOtpremnicaList() {
        return otpremnicaList;
    }

    public void setOtpremnicaList(List<Otpremnica> otpremnicaList) {
        this.otpremnicaList = otpremnicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zusID != null ? zusID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zdravstvenaustanova)) {
            return false;
        }
        Zdravstvenaustanova other = (Zdravstvenaustanova) object;
        if ((this.zusID == null && other.zusID != null) || (this.zusID != null && !this.zusID.equals(other.zusID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Zdravstvenaustanova[ zusID=" + zusID + " ]";
    }
    
}
