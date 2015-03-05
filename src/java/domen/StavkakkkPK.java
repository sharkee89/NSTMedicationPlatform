/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Stefan
 */
@Embeddable
public class StavkakkkPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "kkkID")
    private int kkkID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stavkaKKKRB")
    private int stavkaKKKRB;

    public StavkakkkPK() {
    }

    public StavkakkkPK(int kkkID, int stavkaKKKRB) {
        this.kkkID = kkkID;
        this.stavkaKKKRB = stavkaKKKRB;
    }

    public int getKkkID() {
        return kkkID;
    }

    public void setKkkID(int kkkID) {
        this.kkkID = kkkID;
    }

    public int getStavkaKKKRB() {
        return stavkaKKKRB;
    }

    public void setStavkaKKKRB(int stavkaKKKRB) {
        this.stavkaKKKRB = stavkaKKKRB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) kkkID;
        hash += (int) stavkaKKKRB;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkakkkPK)) {
            return false;
        }
        StavkakkkPK other = (StavkakkkPK) object;
        if (this.kkkID != other.kkkID) {
            return false;
        }
        if (this.stavkaKKKRB != other.stavkaKKKRB) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.StavkakkkPK[ kkkID=" + kkkID + ", stavkaKKKRB=" + stavkaKKKRB + " ]";
    }
    
}
