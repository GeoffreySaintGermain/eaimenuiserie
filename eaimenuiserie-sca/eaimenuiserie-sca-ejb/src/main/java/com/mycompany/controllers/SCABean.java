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
import javax.ejb.Singleton;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author GeoffreySaint-Germai
 */
@Singleton
public class SCABean implements SCABeanLocal {

    @Override
    public Affaire modifierAffaire(UUID identite, String rue, String ville, String cp, String mail, String telephone, String entreprise, String lieuPose, Affaire.statutAffaire statut) throws AffaireInconnuException {
        // TODO: Implements
        return null;
    }

    @Override
    public Affaire creerAffaire() throws AffaireExistanteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void renseignerAffaire(UUID identite, String rue, String ville, String cp, String mail, String telephone, String entreprise, String lieuPose, Affaire.statutAffaire statut) throws AffaireInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void suivreAffaire(UUID identite) throws AffaireInconnuException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }   
    
}
