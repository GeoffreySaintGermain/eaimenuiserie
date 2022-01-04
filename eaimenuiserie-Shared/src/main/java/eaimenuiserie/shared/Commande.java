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
 * @author GeoffreySaint-Germai
 */
public class Commande implements Serializable {
    
    private UUID identite;
    private String refCatalogueProduit;
    private Mesure mesure;
    private double montant;
    private statutCommande statut;
    private UUID affaire;
    private UUID commercial;
    
    public Commande(UUID identite, String refCatalogueProduit, Mesure mesure, double montant, UUID affaire, UUID commercial) {
        this.refCatalogueProduit = refCatalogueProduit;
        this.mesure = mesure;
        this.montant = montant;
        this.statut = statutCommande.CREEE;
        this.affaire = affaire;
        this.commercial = commercial;
        this.identite = identite;
    }
    
    public Commande(String refCatalogueProduit, Mesure mesure, double montant, UUID affaire, UUID commercial) {
        this.refCatalogueProduit = refCatalogueProduit;
        this.mesure = mesure;
        this.montant = montant;
        this.identite = UUID.randomUUID();
        this.statut = statutCommande.CREEE;
        this.affaire = affaire;
        this.commercial = commercial;
    }

    public enum statutCommande {
        CREEE,
        ATTENTEFOURNISSEUR,
        LIVREEETSTOCKEE,
        FERMEE
    }
    
    public UUID getCommercial() {
        return commercial;
    }

    public void setCommercial(UUID referent) {
        this.commercial = referent;
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

    public UUID getAffaire() {
        return affaire;
    }

    public void setAffaire(UUID affaire) {
        this.affaire = affaire;
    }
}
