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
    private double montant;
    private statutCommande statut;
    
    public Commande(String refCatalogueProduit, Mesure mesure, double montant) {
        this.refCatalogueProduit = refCatalogueProduit;
        this.mesure = mesure;
        this.montant = montant;
        this.identite = UUID.randomUUID();
        this.statut = statutCommande.CREEE;
    }

    class Mesure {
        
        private String mesureLargeur;
        private String mesureLongueur;
        
        public Mesure(String mesureLargeur, String mesureLongueur) {
            this.mesureLargeur = mesureLargeur;
            this.mesureLongueur = mesureLongueur;
        }
    }
    
    enum statutCommande {
        CREEE,
        MODIFIEE,
        FERMEE
    }

    public UUID getIdentite() {
        return identite;
    }

    public void setIdentite(UUID identite) {
        this.identite = identite;
    }

    public String getRefCatalogueProduit() {
        return refCatalogueProduit;
    }

    public void setRefCatalogueProduit(String refCatalogueProduit) {
        this.refCatalogueProduit = refCatalogueProduit;
    }

    public Mesure getMesure() {
        return mesure;
    }

    public void setMesure(Mesure mesure) {
        this.mesure = mesure;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public statutCommande getStatut() {
        return statut;
    }

    public void setStatut(statutCommande statut) {
        this.statut = statut;
    }
}
