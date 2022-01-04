/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface ChargeAffaireLocal {

    /**
     * Permet de récupérer tous les charges d'affaires stockées
     * @return Tous les chargés d'affaires existants
     */
    ArrayList<eaimenuiserie.shared.ChargeAffaire> getChargesAffaires();
    
    /**
     * Permet de créer un charge d'affaires
     * @param chargeAffaire Le chargé d'affaire à ajouter dans le système
     * @return Le chargé d'affaire ajouté
     */
    eaimenuiserie.shared.ChargeAffaire addChargeAffaire(eaimenuiserie.shared.ChargeAffaire chargeAffaire);
    
    /**
     * Spécifie si le chargé d'affaire existe
     * @param chargeAffaireId Le chargé d'affaire dont on veut connaître l'existe
     * @return True si il existe, sinon false
     */
    boolean existe(UUID chargeAffaireId);
    
}
