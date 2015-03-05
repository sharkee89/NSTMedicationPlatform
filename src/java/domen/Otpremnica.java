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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "otpremnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otpremnica.findAll", query = "SELECT o FROM Otpremnica o"),
    @NamedQuery(name = "Otpremnica.findByBrojOtpremnice", query = "SELECT o FROM Otpremnica o WHERE o.brojOtpremnice = :brojOtpremnice"),
    @NamedQuery(name = "Otpremnica.findByOtpremnicaID", query = "SELECT o FROM Otpremnica o WHERE o.otpremnicaID = :otpremnicaID"),
    @NamedQuery(name = "Otpremnica.findByDatum", query = "SELECT o FROM Otpremnica o WHERE o.datum = :datum"),
    @NamedQuery(name = "Otpremnica.findByPotvrdjena", query = "SELECT o FROM Otpremnica o WHERE o.potvrdjena = :potvrdjena"),
    @NamedQuery(name = "Otpremnica.findByPotvrdjenaTekst", query = "SELECT o FROM Otpremnica o WHERE o.potvrdjenaTekst = :potvrdjenaTekst")})
public class Otpremnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "brojOtpremnice")
    private String brojOtpremnice;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "otpremnicaID")
    private Integer otpremnicaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "potvrdjena")
    private boolean potvrdjena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "potvrdjenaTekst")
    private String potvrdjenaTekst;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "otpremnicaID")
    private List<Kvalitativnakvantitativnakontrola> kvalitativnakvantitativnakontrolaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "otpremnica")
    private List<Stavkaotpremnice> stavkaotpremniceList;
    @OneToMany(mappedBy = "otpremnicaID")
    private List<Prijemnica> prijemnicaList;
    @JoinColumn(name = "zusID", referencedColumnName = "zusID")
    @ManyToOne
    private Zdravstvenaustanova zusID;
    @JoinColumn(name = "distributerID", referencedColumnName = "distributerID")
    @ManyToOne
    private Distributer distributerID;

    public Otpremnica() {
    }

    public Otpremnica(Integer otpremnicaID) {
        this.otpremnicaID = otpremnicaID;
    }

    public Otpremnica(Integer otpremnicaID, String brojOtpremnice, Date datum, boolean potvrdjena, String potvrdjenaTekst) {
        this.otpremnicaID = otpremnicaID;
        this.brojOtpremnice = brojOtpremnice;
        this.datum = datum;
        this.potvrdjena = potvrdjena;
        this.potvrdjenaTekst = potvrdjenaTekst;
    }

    public String getBrojOtpremnice() {
        return brojOtpremnice;
    }

    public void setBrojOtpremnice(String brojOtpremnice) {
        this.brojOtpremnice = brojOtpremnice;
    }

    public Integer getOtpremnicaID() {
        return otpremnicaID;
    }

    public void setOtpremnicaID(Integer otpremnicaID) {
        this.otpremnicaID = otpremnicaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public boolean getPotvrdjena() {
        return potvrdjena;
    }

    public void setPotvrdjena(boolean potvrdjena) {
        this.potvrdjena = potvrdjena;
    }

    public String getPotvrdjenaTekst() {
        return potvrdjenaTekst;
    }

    public void setPotvrdjenaTekst(String potvrdjenaTekst) {
        this.potvrdjenaTekst = potvrdjenaTekst;
    }

    @XmlTransient
    public List<Kvalitativnakvantitativnakontrola> getKvalitativnakvantitativnakontrolaList() {
        return kvalitativnakvantitativnakontrolaList;
    }

    public void setKvalitativnakvantitativnakontrolaList(List<Kvalitativnakvantitativnakontrola> kvalitativnakvantitativnakontrolaList) {
        this.kvalitativnakvantitativnakontrolaList = kvalitativnakvantitativnakontrolaList;
    }

    @XmlTransient
    public List<Stavkaotpremnice> getStavkaotpremniceList() {
        return stavkaotpremniceList;
    }

    public void setStavkaotpremniceList(List<Stavkaotpremnice> stavkaotpremniceList) {
        this.stavkaotpremniceList = stavkaotpremniceList;
    }

    @XmlTransient
    public List<Prijemnica> getPrijemnicaList() {
        return prijemnicaList;
    }

    public void setPrijemnicaList(List<Prijemnica> prijemnicaList) {
        this.prijemnicaList = prijemnicaList;
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
        hash += (otpremnicaID != null ? otpremnicaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Otpremnica)) {
            return false;
        }
        Otpremnica other = (Otpremnica) object;
        if ((this.otpremnicaID == null && other.otpremnicaID != null) || (this.otpremnicaID != null && !this.otpremnicaID.equals(other.otpremnicaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Otpremnica[ otpremnicaID=" + otpremnicaID + " ]";
    }
    
}
