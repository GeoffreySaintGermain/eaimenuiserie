/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eaimenuiserie.shared;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * @author grego
 */
public class Commercial implements Serializable {
    
    private String nom;
    private String prenom;
    private final UUID identite;
    
    public Commercial(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        identite = UUID.randomUUID();
    }

    public UUID getIdentite() {
        return identite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    
    
}
