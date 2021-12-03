/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllers;

import eaimenuiserie.shared.Affaire;
import com.mycompany.exceptions.*;
import java.io.Serializable;
import java.util.UUID;
import javax.ejb.Local;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author GeoffreySaint-Germai
 */
@Local
public interface SCABeanLocal {
    
    public Affaire creerAffaire() throws AffaireExistanteException;
    
    public void renseignerAffaire(UUID identite, String rue, String ville, String cp, String mail, String telephone, String entreprise, String lieuPose, Affaire.statutAffaire statut) throws AffaireInconnuException;

    public void suivreAffaire(UUID identite) throws AffaireInconnuException;
    
    public Affaire modifierAffaire(UUID identite, String rue, String ville, String cp, String mail, String telephone, String entreprise, String lieuPose, Affaire.statutAffaire statut) throws AffaireInconnuException;    
}