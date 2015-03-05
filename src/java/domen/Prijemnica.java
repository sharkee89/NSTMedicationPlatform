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
@Table(name = "prijemnica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prijemnica.findAll", query = "SELECT p FROM Prijemnica p"),
    @NamedQuery(name = "Prijemnica.findByBrojPrijemnice", query = "SELECT p FROM Prijemnica p WHERE p.brojPrijemnice = :brojPrijemnice"),
    @NamedQuery(name = "Prijemnica.findByPrijemnicaID", query = "SELECT p FROM Prijemnica p WHERE p.prijemnicaID = :prijemnicaID"),
    @NamedQuery(name = "Prijemnica.findByDatum", query = "SELECT p FROM Prijemnica p WHERE p.datum = :datum")})
public class Prijemnica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "brojPrijemnice")
    private String brojPrijemnice;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "prijemnicaID")
    private Integer prijemnicaID;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prijemnicaID")
    private List<Kvalitativnakvantitativnakontrola> kvalitativnakvantitativnakontrolaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prijemnica")
    private List<Stavkaprijemnice> stavkaprijemniceList;
    @JoinColumn(name = "otpremnicaID", referencedColumnName = "otpremnicaID")
    @ManyToOne
    private Otpremnica otpremnicaID;
    @JoinColumn(name = "zusID", referencedColumnName = "zusID")
    @ManyToOne
    private Zdravstvenaustanova zusID;

    public Prijemnica() {
    }

    public Prijemnica(Integer prijemnicaID) {
        this.prijemnicaID = prijemnicaID;
    }

    public Prijemnica(Integer prijemnicaID, String brojPrijemnice) {
        this.prijemnicaID = prijemnicaID;
        this.brojPrijemnice = brojPrijemnice;
    }

    public String getBrojPrijemnice() {
        return brojPrijemnice;
    }

    public void setBrojPrijemnice(String brojPrijemnice) {
        this.brojPrijemnice = brojPrijemnice;
    }

    public Integer getPrijemnicaID() {
        return prijemnicaID;
    }

    public void setPrijemnicaID(Integer prijemnicaID) {
        this.prijemnicaID = prijemnicaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @XmlTransient
    public List<Kvalitativnakvantitativnakontrola> getKvalitativnakvantitativnakontrolaList() {
        return kvalitativnakvantitativnakontrolaList;
    }

    public void setKvalitativnakvantitativnakontrolaList(List<Kvalitativnakvantitativnakontrola> kvalitativnakvantitativnakontrolaList) {
        this.kvalitativnakvantitativnakontrolaList = kvalitativnakvantitativnakontrolaList;
    }

    @XmlTransient
    public List<Stavkaprijemnice> getStavkaprijemniceList() {
        return stavkaprijemniceList;
    }

    public void setStavkaprijemniceList(List<Stavkaprijemnice> stavkaprijemniceList) {
        this.stavkaprijemniceList = stavkaprijemniceList;
    }

    public Otpremnica getOtpremnicaID() {
        return otpremnicaID;
    }

    public void setOtpremnicaID(Otpremnica otpremnicaID) {
        this.otpremnicaID = otpremnicaID;
    }

    public Zdravstvenaustanova getZusID() {
        return zusID;
    }

    public void setZusID(Zdravstvenaustanova zusID) {
        this.zusID = zusID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prijemnicaID != null ? prijemnicaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prijemnica)) {
            return false;
        }
        Prijemnica other = (Prijemnica) object;
        if ((this.prijemnicaID == null && other.prijemnicaID != null) || (this.prijemnicaID != null && !this.prijemnicaID.equals(other.prijemnicaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Prijemnica[ prijemnicaID=" + prijemnicaID + " ]";
    }
    
}
