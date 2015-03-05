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
public class StavkaprijemnicePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "prijemnicaID")
    private int prijemnicaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stavkaprijemniceRB")
    private int stavkaprijemniceRB;

    public StavkaprijemnicePK() {
    }

    public StavkaprijemnicePK(int prijemnicaID, int stavkaprijemniceRB) {
        this.prijemnicaID = prijemnicaID;
        this.stavkaprijemniceRB = stavkaprijemniceRB;
    }

    public int getPrijemnicaID() {
        return prijemnicaID;
    }

    public void setPrijemnicaID(int prijemnicaID) {
        this.prijemnicaID = prijemnicaID;
    }

    public int getStavkaprijemniceRB() {
        return stavkaprijemniceRB;
    }

    public void setStavkaprijemniceRB(int stavkaprijemniceRB) {
        this.stavkaprijemniceRB = stavkaprijemniceRB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prijemnicaID;
        hash += (int) stavkaprijemniceRB;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaprijemnicePK)) {
            return false;
        }
        StavkaprijemnicePK other = (StavkaprijemnicePK) object;
        if (this.prijemnicaID != other.prijemnicaID) {
            return false;
        }
        if (this.stavkaprijemniceRB != other.stavkaprijemniceRB) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.StavkaprijemnicePK[ prijemnicaID=" + prijemnicaID + ", stavkaprijemniceRB=" + stavkaprijemniceRB + " ]";
    }
    
}
