/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import eaimenuiserie.shared.Affaire;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface AffairesLocal {
    
    /**
     * Permet de récupérer toutes les affaires stockées
     * @return Les affaires stockées dans sca
     */
    public ArrayList<Affaire> getAffaires();

    /**
     * Permet de créer une affaire dans le sca
     * @param rue La rue du client
     * @param ville La ville du client
     * @param cp Le cp du client
     * @param mail Le mail du clienbt
     * @param telephone Le téléphone du client
     * @param entreprise L'entreprise du client
     * @param lieuPose Le lieu où la pose sera faite
     * @param referent Le chargé d'affaire référent
     */
    void creerAffaire(String rue, String ville, String cp, String mail, String telephone, String entreprise, String lieuPose, UUID referent);
    
    /**
     * Permet de créer une affaire dans le sca
     * @param affaire L'affaire à crééer
     */
    public void creerAffaire(Affaire affaire);

    /**
     * Permet de modifier le statut de l'affaire selon Affaire.statutAffaire
     * @param idAffaire Laffaire dont on veut modifier le statut
     * @param statut Le nouveau statut de l'affaire
     */
    public void modifierStatut(String idAffaire, Affaire.statutAffaire statut);
}
