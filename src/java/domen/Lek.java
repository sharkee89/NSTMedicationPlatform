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
import javax.persistence.CascadeType;
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
@Table(name = "lek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lek.findAll", query = "SELECT l FROM Lek l"),
    @NamedQuery(name = "Lek.findByLekSerijskiBroj", query = "SELECT l FROM Lek l WHERE l.lekSerijskiBroj = :lekSerijskiBroj"),
    @NamedQuery(name = "Lek.findByNaziv", query = "SELECT l FROM Lek l WHERE l.naziv = :naziv"),
    @NamedQuery(name = "Lek.findByGenerickiNaziv", query = "SELECT l FROM Lek l WHERE l.generickiNaziv = :generickiNaziv"),
    @NamedQuery(name = "Lek.findByProizvodjac", query = "SELECT l FROM Lek l WHERE l.proizvodjac = :proizvodjac"),
    @NamedQuery(name = "Lek.findByNosiocDozvola", query = "SELECT l FROM Lek l WHERE l.nosiocDozvola = :nosiocDozvola"),
    @NamedQuery(name = "Lek.findByRezimIzdavanja", query = "SELECT l FROM Lek l WHERE l.rezimIzdavanja = :rezimIzdavanja"),
    @NamedQuery(name = "Lek.findByAtc", query = "SELECT l FROM Lek l WHERE l.atc = :atc"),
    @NamedQuery(name = "Lek.findByJkl", query = "SELECT l FROM Lek l WHERE l.jkl = :jkl"),
    @NamedQuery(name = "Lek.findByBrojResenja", query = "SELECT l FROM Lek l WHERE l.brojResenja = :brojResenja"),
    @NamedQuery(name = "Lek.findByDatumResenja", query = "SELECT l FROM Lek l WHERE l.datumResenja = :datumResenja"),
    @NamedQuery(name = "Lek.findByVrstaLeka", query = "SELECT l FROM Lek l WHERE l.vrstaLeka = :vrstaLeka"),
    @NamedQuery(name = "Lek.findByCena", query = "SELECT l FROM Lek l WHERE l.cena = :cena")})
public class Lek implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lekSerijskiBroj")
    private Integer lekSerijskiBroj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "generickiNaziv")
    private String generickiNaziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "proizvodjac")
    private String proizvodjac;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nosiocDozvola")
    private String nosiocDozvola;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "rezimIzdavanja")
    private String rezimIzdavanja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "atc")
    private String atc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "jkl")
    private String jkl;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "brojResenja")
    private String brojResenja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datumResenja")
    @Temporal(TemporalType.DATE)
    private Date datumResenja;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vrstaLeka")
    private String vrstaLeka;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena")
    private double cena;
    @OneToMany(mappedBy = "lekSerijskiBroj")
    private List<Stavkaprijemnice> stavkaprijemniceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lekSerijskiBroj")
    private List<Stavkakkk> stavkakkkList;
    @OneToMany(mappedBy = "lekSerijskiBroj")
    private List<Stavkaotpremnice> stavkaotpremniceList;

    public Lek() {
    }

    public Lek(Integer lekSerijskiBroj) {
        this.lekSerijskiBroj = lekSerijskiBroj;
    }

    public Lek(Integer lekSerijskiBroj, String naziv, String generickiNaziv, String proizvodjac, String nosiocDozvola, String rezimIzdavanja, String atc, String jkl, String brojResenja, Date datumResenja, String vrstaLeka, double cena) {
        this.lekSerijskiBroj = lekSerijskiBroj;
        this.naziv = naziv;
        this.generickiNaziv = generickiNaziv;
        this.proizvodjac = proizvodjac;
        this.nosiocDozvola = nosiocDozvola;
        this.rezimIzdavanja = rezimIzdavanja;
        this.atc = atc;
        this.jkl = jkl;
        this.brojResenja = brojResenja;
        this.datumResenja = datumResenja;
        this.vrstaLeka = vrstaLeka;
        this.cena = cena;
    }

    public Integer getLekSerijskiBroj() {
        return lekSerijskiBroj;
    }

    public void setLekSerijskiBroj(Integer lekSerijskiBroj) {
        this.lekSerijskiBroj = lekSerijskiBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGenerickiNaziv() {
        return generickiNaziv;
    }

    public void setGenerickiNaziv(String generickiNaziv) {
        this.generickiNaziv = generickiNaziv;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getNosiocDozvola() {
        return nosiocDozvola;
    }

    public void setNosiocDozvola(String nosiocDozvola) {
        this.nosiocDozvola = nosiocDozvola;
    }

    public String getRezimIzdavanja() {
        return rezimIzdavanja;
    }

    public void setRezimIzdavanja(String rezimIzdavanja) {
        this.rezimIzdavanja = rezimIzdavanja;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getJkl() {
        return jkl;
    }

    public void setJkl(String jkl) {
        this.jkl = jkl;
    }

    public String getBrojResenja() {
        return brojResenja;
    }

    public void setBrojResenja(String brojResenja) {
        this.brojResenja = brojResenja;
    }

    public Date getDatumResenja() {
        return datumResenja;
    }

    public void setDatumResenja(Date datumResenja) {
        this.datumResenja = datumResenja;
    }

    public String getVrstaLeka() {
        return vrstaLeka;
    }

    public void setVrstaLeka(String vrstaLeka) {
        this.vrstaLeka = vrstaLeka;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @XmlTransient
    public List<Stavkaprijemnice> getStavkaprijemniceList() {
        return stavkaprijemniceList;
    }

    public void setStavkaprijemniceList(List<Stavkaprijemnice> stavkaprijemniceList) {
        this.stavkaprijemniceList = stavkaprijemniceList;
    }

    @XmlTransient
    public List<Stavkakkk> getStavkakkkList() {
        return stavkakkkList;
    }

    public void setStavkakkkList(List<Stavkakkk> stavkakkkList) {
        this.stavkakkkList = stavkakkkList;
    }

    @XmlTransient
    public List<Stavkaotpremnice> getStavkaotpremniceList() {
        return stavkaotpremniceList;
    }

    public void setStavkaotpremniceList(List<Stavkaotpremnice> stavkaotpremniceList) {
        this.stavkaotpremniceList = stavkaotpremniceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lekSerijskiBroj != null ? lekSerijskiBroj.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lek)) {
            return false;
        }
        Lek other = (Lek) object;
        if ((this.lekSerijskiBroj == null && other.lekSerijskiBroj != null) || (this.lekSerijskiBroj != null && !this.lekSerijskiBroj.equals(other.lekSerijskiBroj))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Lek[ lekSerijskiBroj=" + lekSerijskiBroj + " ]";
    }
    
}
