/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eaimenuiserie.shared;

import java.util.UUID;

/**
 *
 * @author GeoffreySaint-Germai
 */
public class Affaire {
    
    private UUID identite;
    private String rue;
    private String ville;
    private String cp;
    private String mail;
    private String telephone;
    private String entreprise;
    private String lieuPose;
    private statutAffaire statut;
    
    public Affaire(String rue, String ville, String cp, String mail, 
            String telephone, String entreprise, String lieuPose) {
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.mail = mail;
        this.telephone = telephone;
        this.entreprise = entreprise;
        this.lieuPose = lieuPose;
        
        this.statut = statutAffaire.ENCOURS;
        this.identite = UUID.randomUUID();
    }
    
    enum statutAffaire {
        ENCOURS,
        FERME
    }
}
