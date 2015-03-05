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
@Table(name = "kvalitativnakvantitativnakontrola")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kvalitativnakvantitativnakontrola.findAll", query = "SELECT k FROM Kvalitativnakvantitativnakontrola k"),
    @NamedQuery(name = "Kvalitativnakvantitativnakontrola.findByKkkID", query = "SELECT k FROM Kvalitativnakvantitativnakontrola k WHERE k.kkkID = :kkkID"),
    @NamedQuery(name = "Kvalitativnakvantitativnakontrola.findByBrojKkk", query = "SELECT k FROM Kvalitativnakvantitativnakontrola k WHERE k.brojKkk = :brojKkk"),
    @NamedQuery(name = "Kvalitativnakvantitativnakontrola.findByDatum", query = "SELECT k FROM Kvalitativnakvantitativnakontrola k WHERE k.datum = :datum")})
public class Kvalitativnakvantitativnakontrola implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "kkkID")
    private Integer kkkID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "brojKkk")
    private String brojKkk;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @JoinColumn(name = "prijemnicaID", referencedColumnName = "prijemnicaID")
    @ManyToOne(optional = false)
    private Prijemnica prijemnicaID;
    @JoinColumn(name = "otpremnicaID", referencedColumnName = "otpremnicaID")
    @ManyToOne(optional = false)
    private Otpremnica otpremnicaID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kvalitativnakvantitativnakontrola")
    private List<Stavkakkk> stavkakkkList;

    public Kvalitativnakvantitativnakontrola() {
    }

    public Kvalitativnakvantitativnakontrola(Integer kkkID) {
        this.kkkID = kkkID;
    }

    public Kvalitativnakvantitativnakontrola(Integer kkkID, String brojKkk) {
        this.kkkID = kkkID;
        this.brojKkk = brojKkk;
    }

    public Integer getKkkID() {
        return kkkID;
    }

    public void setKkkID(Integer kkkID) {
        this.kkkID = kkkID;
    }

    public String getBrojKkk() {
        return brojKkk;
    }

    public void setBrojKkk(String brojKkk) {
        this.brojKkk = brojKkk;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Prijemnica getPrijemnicaID() {
        return prijemnicaID;
    }

    public void setPrijemnicaID(Prijemnica prijemnicaID) {
        this.prijemnicaID = prijemnicaID;
    }

    public Otpremnica getOtpremnicaID() {
        return otpremnicaID;
    }

    public void setOtpremnicaID(Otpremnica otpremnicaID) {
        this.otpremnicaID = otpremnicaID;
    }

    @XmlTransient
    public List<Stavkakkk> getStavkakkkList() {
        return stavkakkkList;
    }

    public void setStavkakkkList(List<Stavkakkk> stavkakkkList) {
        this.stavkakkkList = stavkakkkList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kkkID != null ? kkkID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kvalitativnakvantitativnakontrola)) {
            return false;
        }
        Kvalitativnakvantitativnakontrola other = (Kvalitativnakvantitativnakontrola) object;
        if ((this.kkkID == null && other.kkkID != null) || (this.kkkID != null && !this.kkkID.equals(other.kkkID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Kvalitativnakvantitativnakontrola[ kkkID=" + kkkID + " ]";
    }
    
}
