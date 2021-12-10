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
import javax.ejb.EJB;
import javax.ejb.Singleton;
import miage.m2.expo.jms.SendAffaireValidee;
import miage.m2.expo.jms.SendCommandeValidee;

/**
 *
 * @author Kevin
 */
@Singleton
public class Commandes implements CommandesLocal {

    @EJB
    private AffairesLocal affaires;

    private static ArrayList<Commande> commandes;

    public ArrayList<Commande> getCommandes() {
        if(commandes == null) {
            commandes  = new ArrayList<>();
        }
        return commandes;
    }

    @Override
    public void addCommandes(Commande commande) {
        getCommandes().add(new Commande(commande.getRefCatalogueProduit(), commande.getMesure(), commande.getMontant(), commande.getAffaire(), new Commercial(commande.getReferent().getNom(), commande.getReferent().getPrenom())));
        //for(Affaire affaire : this.affaires.getAffaires()) {
        //    if(affaire.getIdentite().equals(commande.getAffaire())) {
        //        affaire.setStatut(Affaire.statutAffaire.VALIDEE);
                SendAffaireValidee.sendMsg(commande.getAffaire());
        //        break;
        //    }
        //}
        SendCommandeValidee.sendMsg(commande);
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
