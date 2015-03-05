/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb;

import domen.Distributer;
import domen.Zdravstvenaustanova;
import java.io.Serializable;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Stefan
 */
@ManagedBean (name = "mbSesija")
@SessionScoped
public class MBSesija implements Serializable{

    Distributer ulogovaniDistributer;
    Zdravstvenaustanova ulogovaniZus;
    HashMap<String, Object> mapaPodataka;
    /**
     * Creates a new instance of MBSesija
     */
    public MBSesija() {
        mapaPodataka = new HashMap<String, Object>();
    }

    public Distributer getUlogovaniDistributer() {
        return ulogovaniDistributer;
    }

    public void setUlogovaniDistributer(Distributer ulogovaniDistributer) {
        this.ulogovaniDistributer = ulogovaniDistributer;
    }

    public HashMap<String, Object> getMapaPodataka() {
        return mapaPodataka;
    }

    public void setMapaPodataka(HashMap<String, Object> mapaPodataka) {
        this.mapaPodataka = mapaPodataka;
    }

    public Zdravstvenaustanova getUlogovaniZus() {
        return ulogovaniZus;
    }

    public void setUlogovaniZus(Zdravstvenaustanova ulogovaniZus) {
        this.ulogovaniZus = ulogovaniZus;
    }
    
    
    
}
