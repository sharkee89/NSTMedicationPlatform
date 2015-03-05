/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "distributer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Distributer.findAll", query = "SELECT d FROM Distributer d"),
    @NamedQuery(name = "Distributer.findByDistributerID", query = "SELECT d FROM Distributer d WHERE d.distributerID = :distributerID"),
    @NamedQuery(name = "Distributer.findByDkorisnickoIme", query = "SELECT d FROM Distributer d WHERE d.dkorisnickoIme = :dkorisnickoIme"),
    @NamedQuery(name = "Distributer.findByDkorisnickaSifra", query = "SELECT d FROM Distributer d WHERE d.dkorisnickaSifra = :dkorisnickaSifra"),
    @NamedQuery(name = "Distributer.findByNaziv", query = "SELECT d FROM Distributer d WHERE d.naziv = :naziv"),
    @NamedQuery(name = "Distributer.findByAdresa", query = "SELECT d FROM Distributer d WHERE d.adresa = :adresa"),
    @NamedQuery(name = "Distributer.findByPoslovnoIme", query = "SELECT d FROM Distributer d WHERE d.poslovnoIme = :poslovnoIme"),
    @NamedQuery(name = "Distributer.findByPravnaForma", query = "SELECT d FROM Distributer d WHERE d.pravnaForma = :pravnaForma"),
    @NamedQuery(name = "Distributer.findByStatus", query = "SELECT d FROM Distributer d WHERE d.status = :status"),
    @NamedQuery(name = "Distributer.findByPib", query = "SELECT d FROM Distributer d WHERE d.pib = :pib"),
    @NamedQuery(name = "Distributer.findByMaticniBroj", query = "SELECT d FROM Distributer d WHERE d.maticniBroj = :maticniBroj"),
    @NamedQuery(name = "Distributer.findByDatumOsnivanja", query = "SELECT d FROM Distributer d WHERE d.datumOsnivanja = :datumOsnivanja")})
public class Distributer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "distributerID")
    private Integer distributerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dkorisnickoIme")
    private String dkorisnickoIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "dkorisnickaSifra")
    private String dkorisnickaSifra;
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
    @Column(name = "poslovnoIme")
    private String poslovnoIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "pravnaForma")
    private String pravnaForma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status")
    private String status;
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
    @Column(name = "datumOsnivanja")
    @Temporal(TemporalType.DATE)
    private Date datumOsnivanja;
    @OneToMany(mappedBy = "distributerID")
    private List<Korisnik> korisnikList;
    @OneToMany(mappedBy = "distributerID")
    private List<Otpremnica> otpremnicaList;

    public Distributer() {
    }

    public Distributer(Integer distributerID) {
        this.distributerID = distributerID;
    }

    public Distributer(Integer distributerID, String dkorisnickoIme, String dkorisnickaSifra, String naziv, String adresa, String poslovnoIme, String pravnaForma, String status, String pib, String maticniBroj, Date datumOsnivanja) {
        this.distributerID = distributerID;
        this.dkorisnickoIme = dkorisnickoIme;
        this.dkorisnickaSifra = dkorisnickaSifra;
        this.naziv = naziv;
        this.adresa = adresa;
        this.poslovnoIme = poslovnoIme;
        this.pravnaForma = pravnaForma;
        this.status = status;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.datumOsnivanja = datumOsnivanja;
    }

    public Integer getDistributerID() {
        return distributerID;
    }

    public void setDistributerID(Integer distributerID) {
        this.distributerID = distributerID;
    }

    public String getDkorisnickoIme() {
        return dkorisnickoIme;
    }

    public void setDkorisnickoIme(String dkorisnickoIme) {
        this.dkorisnickoIme = dkorisnickoIme;
    }

    public String getDkorisnickaSifra() {
        return dkorisnickaSifra;
    }

    public void setDkorisnickaSifra(String dkorisnickaSifra) {
        this.dkorisnickaSifra = dkorisnickaSifra;
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

    public String getPoslovnoIme() {
        return poslovnoIme;
    }

    public void setPoslovnoIme(String poslovnoIme) {
        this.poslovnoIme = poslovnoIme;
    }

    public String getPravnaForma() {
        return pravnaForma;
    }

    public void setPravnaForma(String pravnaForma) {
        this.pravnaForma = pravnaForma;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getDatumOsnivanja() {
        return datumOsnivanja;
    }

    public void setDatumOsnivanja(Date datumOsnivanja) {
        this.datumOsnivanja = datumOsnivanja;
    }

    @XmlTransient
    public List<Korisnik> getKorisnikList() {
        return korisnikList;
    }

    public void setKorisnikList(List<Korisnik> korisnikList) {
        this.korisnikList = korisnikList;
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
        hash += (distributerID != null ? distributerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Distributer)) {
            return false;
        }
        Distributer other = (Distributer) object;
        if ((this.distributerID == null && other.distributerID != null) || (this.distributerID != null && !this.distributerID.equals(other.distributerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Distributer[ distributerID=" + distributerID + " ]";
    }
    
}
