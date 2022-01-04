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
    public ArrayList<Commande> getCommandes();

    public void addCommandes(Commande commande);

    public void removeCommandes(UUID identite);

    void passerCommandeFournisseur(String uuidCommande);

    void receptionFournisseur(String uuidCommande);

    void fermer(String idCommande);
}
