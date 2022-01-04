/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Commande;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface CommandesLocal {
    /**
     * @return Toutes les commandes stockées
     */
    public ArrayList<Commande> getCommandes();

    /**
     * Créée une nouvelle commande
     * @param commande La commande à créer
     */
    public void addCommandes(Commande commande);

    /**
     * Supprime une commande
     * @param identite L'identifiant de la commande à supprimer
     */
    public void removeCommandes(UUID identite);

    /**
     * Envoie la commande au fournisseur
     * @param uuidCommande La commande à passer
     */
    void passerCommandeFournisseur(String uuidCommande);

    /**
     * Notifier que la commande fournisseur à bien été réceptionnée 
     * dans l'entreprise
     * @param uuidCommande La commande réceptionnée
     */
    void receptionFournisseur(String uuidCommande);

    /**
     * Passer le statut d'une commande à fermée
     * @param idCommande La commande à fermer
     */
    void fermer(String idCommande);
}
