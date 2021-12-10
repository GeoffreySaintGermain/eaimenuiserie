/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Commande;
import eaimenuiserie.shared.Commercial;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Singleton;

/**
 *
 * @author Kevin
 */
@Singleton
public class Commandes implements CommandesLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static ArrayList<Commande> commandes;

    @Override
    public ArrayList<Commande> getCommandes() {
        if(commandes == null) {
            commandes  = new ArrayList<>();
        }
        return commandes;
    }

    @Override
    public void addCommandes(Commande commande) {
        getCommandes().add(new Commande(commande.getRefCatalogueProduit(), commande.getMesure(), commande.getMontant(), commande.getAffaire(), new Commercial(commande.getReferent().getNom(), commande.getReferent().getPrenom())));
        // Il faudrait passer la commande au fournisseur, ici le fournisseur n'existe pas
        // donc ici il faut valider l'affaire
    }

    @Override
    public void removeCommandes(UUID identite) {
        for(int i = 0 ; i < getCommandes().size(); i++) {
            if(commandes.get(i).getIdentite() == identite) {
                getCommandes().remove(i);
                return;
            }
        }
    }
}
