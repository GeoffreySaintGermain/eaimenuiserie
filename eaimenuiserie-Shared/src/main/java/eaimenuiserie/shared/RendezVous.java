/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eaimenuiserie.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Kevin
 */
public class RendezVous implements Serializable {
    
    private UUID identite;
    
    private Date dateDebut;
    
    private Date dateFin;
    
    private UUID affaire;
    
    private boolean confirme = false;
    
    /*public RendezVous(Date dateDebut, Date dateFin, UUID identite) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.identite = identite;
    }*/
    
    public RendezVous(Date dateDebut, Date dateFin, String identite, String affaire) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.identite = UUID.fromString(identite);
        this.affaire = UUID.fromString(affaire);
    }

    public UUID getIdentite() {
        return identite;
    }

    public void setIdentite(UUID identite) {
        this.identite = identite;
    }
    
    public UUID getAffaire() {
        return affaire;
    }

    public void setAffaire(UUID identite) {
        this.affaire = identite;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public boolean isConfirme() {
        return confirme;
    }

    public void setConfirme(boolean confirme) {
        this.confirme = confirme;
    }
    
}
