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
public class Commande {
    
    private UUID identite;
    private String refCatalogueProduit;
    private Mesure mesure;
    
    public Commande(String refCatalogueProduit, Mesure mesure) {
        this.refCatalogueProduit = refCatalogueProduit;
        this.mesure = mesure;
        
        this.identite = UUID.randomUUID();
    }

    class Mesure {
        
        private String mesureLargeur;
        private String mesureLongueur;
        
        public Mesure(String mesureLargeur, String mesureLongueur) {
            this.mesureLargeur = mesureLargeur;
            this.mesureLongueur = mesureLongueur;
        }
    }
}
