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
public class StavkaotpremnicePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "otpremnicaID")
    private int otpremnicaID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stavkaotpremniceRB")
    private int stavkaotpremniceRB;

    public StavkaotpremnicePK() {
    }

    public StavkaotpremnicePK(int otpremnicaID, int stavkaotpremniceRB) {
        this.otpremnicaID = otpremnicaID;
        this.stavkaotpremniceRB = stavkaotpremniceRB;
    }

    public int getOtpremnicaID() {
        return otpremnicaID;
    }

    public void setOtpremnicaID(int otpremnicaID) {
        this.otpremnicaID = otpremnicaID;
    }

    public int getStavkaotpremniceRB() {
        return stavkaotpremniceRB;
    }

    public void setStavkaotpremniceRB(int stavkaotpremniceRB) {
        this.stavkaotpremniceRB = stavkaotpremniceRB;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) otpremnicaID;
        hash += (int) stavkaotpremniceRB;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaotpremnicePK)) {
            return false;
        }
        StavkaotpremnicePK other = (StavkaotpremnicePK) object;
        if (this.otpremnicaID != other.otpremnicaID) {
            return false;
        }
        if (this.stavkaotpremniceRB != other.stavkaotpremniceRB) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.StavkaotpremnicePK[ otpremnicaID=" + otpremnicaID + ", stavkaotpremniceRB=" + stavkaotpremniceRB + " ]";
    }
    
}
