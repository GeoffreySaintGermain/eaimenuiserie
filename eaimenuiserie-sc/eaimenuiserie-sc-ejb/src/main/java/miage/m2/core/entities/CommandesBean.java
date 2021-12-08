/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Commande;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import miage.m2.expo.jms.SendCommandeValidee;

/**
 *
 * @author Kevin
 */
@Singleton
@LocalBean
public class CommandesBean {

    private static ArrayList<Commande> commandes;

    public ArrayList<Commande> getCommandes() {
        if(commandes == null) {
            commandes  = new ArrayList<>();
        }
        return commandes;
    }

    public void addCommandes(Commande commande) {
        getCommandes().add(commande);
        SendCommandeValidee.sendMsg(commande);
    }

    public void removeCommandes(UUID identite) {
        for(int i = 0 ; i < getCommandes().size(); i++) {
            if(commandes.get(i).getIdentite() == identite) {
                getCommandes().remove(i);
                return;
            }
        }
    }
}
