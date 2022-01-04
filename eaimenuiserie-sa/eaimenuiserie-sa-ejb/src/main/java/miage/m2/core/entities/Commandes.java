/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Affaire;
import eaimenuiserie.shared.Commande;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Singleton;
import miage.m2.expo.jms.UpdateStatutAffaire;
import miage.m2.expo.jms.UpdateStatutCommande;

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
        getCommandes().add(commande);
    }

    @Override
    public void removeCommandes(UUID identite) {
        for(int i = 0 ; i < getCommandes().size(); i++) {
            if(getCommandes().get(i).getIdentite() == identite) {
                getCommandes().remove(i);
                return;
            }
        }
    }

    @Override
    public void passerCommandeFournisseur(String uuidCommande) {
        for(int i = 0 ; i < getCommandes().size(); i++) {
            if(getCommandes().get(i).getIdentite().toString().equals(uuidCommande)) {
                getCommandes().get(i).setStatut(Commande.statutCommande.ATTENTEFOURNISSEUR);
                UpdateStatutCommande.updateCommande(uuidCommande, Commande.statutCommande.ATTENTEFOURNISSEUR);
                UpdateStatutAffaire.updateAffaire(getCommandes().get(i).getAffaire().toString(), Affaire.statutAffaire.ATTENTECOMMANDE);
                return;
            }
        }
    }

    @Override
    public void receptionFournisseur(String uuidCommande) {
        for(int i = 0 ; i < getCommandes().size(); i++) {
            if(getCommandes().get(i).getIdentite().toString().equals(uuidCommande)) {
                getCommandes().get(i).setStatut(Commande.statutCommande.LIVREEETSTOCKEE);
                UpdateStatutCommande.updateCommande(uuidCommande, Commande.statutCommande.LIVREEETSTOCKEE);
                UpdateStatutAffaire.updateAffaire(getCommandes().get(i).getAffaire().toString(), Affaire.statutAffaire.COMMANDELIVREE);
                return;
            }
        }
    }

    @Override
    public void fermer(String idCommande) {
        for(Commande commande : getCommandes()) {
            if(commande.getIdentite().toString().equals(idCommande)) {
                commande.setStatut(Commande.statutCommande.FERMEE);
            }
        }
    }
    
    
    
}
