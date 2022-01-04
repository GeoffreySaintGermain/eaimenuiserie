/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eaimenuiserie.shared;

import java.io.Serializable;

/**
 *
 * @author Kevin
 */
public class Mesure implements Serializable {
    private String mesureLargeur;
    private String mesureLongueur;

    public Mesure(String mesureLargeur, String mesureLongueur) {
        this.mesureLargeur = mesureLargeur;
        this.mesureLongueur = mesureLongueur;
    }

    public String getMesureLargeur() {
        return mesureLargeur;
    }

    public void setMesureLargeur(String mesureLargeur) {
        this.mesureLargeur = mesureLargeur;
    }

    public String getMesureLongueur() {
        return mesureLongueur;
    }

    public void setMesureLongueur(String mesureLongueur) {
        this.mesureLongueur = mesureLongueur;
    }
    
}
