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
public class Affaire implements Serializable {
    
    private UUID identite;
    private String rue;
    private String ville;
    private String cp;
    private String mail;
    private String telephone;
    private String entreprise;
    private String lieuPose;
    private statutAffaire statut;
    private UUID chargeAffaire;
    
    public Affaire(UUID identite, String rue, String ville, String cp, String mail, 
            String telephone, String entreprise, String lieuPose, UUID chargeAffaire) {
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.mail = mail;
        this.telephone = telephone;
        this.entreprise = entreprise;
        this.lieuPose = lieuPose;
        this.chargeAffaire = chargeAffaire;
        
        this.statut = statutAffaire.CREEE;
        this.identite = identite;
    }
    
    public Affaire(String rue, String ville, String cp, String mail, 
            String telephone, String entreprise, String lieuPose, UUID chargeAffaire) {
        this.rue = rue;
        this.ville = ville;
        this.cp = cp;
        this.mail = mail;
        this.telephone = telephone;
        this.entreprise = entreprise;
        this.lieuPose = lieuPose;
        this.chargeAffaire = chargeAffaire;
        
        this.statut = statutAffaire.CREEE;
        this.identite = UUID.randomUUID();
    }
    
    public enum statutAffaire {
        CREEE,
        VALIDEE,
        ATTENTECOMMANDE,
        COMMANDELIVREE,
        POSEE,
        ACCOMPTEENCAISSE,
        ENCAISEE,
        FERMEE
    }

    public UUID getIdentite() {
        return identite;
    }

    public void setIdentite(UUID identite) {
        this.identite = identite;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public String getLieuPose() {
        return lieuPose;
    }

    public void setLieuPose(String lieuPose) {
        this.lieuPose = lieuPose;
    }

    public statutAffaire getStatut() {
        return statut;
    }

    public void setStatut(statutAffaire statut) {
        this.statut = statut;
    }

    public UUID getChargeAffaire() {
        return chargeAffaire;
    }

    public void setChargeAffaire(UUID referent) {
        this.chargeAffaire = referent;
    }
    
}
