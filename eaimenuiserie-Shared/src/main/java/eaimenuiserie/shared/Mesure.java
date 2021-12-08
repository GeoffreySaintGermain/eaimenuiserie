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
}
