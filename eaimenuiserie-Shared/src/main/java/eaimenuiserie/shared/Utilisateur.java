/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eaimenuiserie.shared;

import java.util.UUID;

/**
 *
 * @author grego
 */
public class Utilisateur {
    
    private UUID identite;
    private String nom;
    private String prenom;
    
    public Utilisateur(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        
        this.identite = UUID.randomUUID();
    }
}
