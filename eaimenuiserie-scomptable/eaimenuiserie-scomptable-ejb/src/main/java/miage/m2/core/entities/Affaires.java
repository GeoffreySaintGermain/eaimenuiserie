/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Affaire;
import java.util.ArrayList;
import javax.ejb.Singleton;
import miage.m2.expo.jms.SendAffaireEncaisee;

/**
 *
 * @author Kevin
 */
@Singleton
public class Affaires implements AffairesLocal {

    private static ArrayList<Affaire> affaires;

    @Override
    public ArrayList<Affaire> getAffaires() {
        if(affaires == null) {
            affaires  = new ArrayList<>();
        }
        return affaires;
    }

    @Override
    public void ajouterAffaire(Affaire affaire) {
        getAffaires().add(affaire);
    }
    
    @Override
    public void encaisserAffaire(String idAffaire) {
        for(Affaire affaireObj : getAffaires()) {
            if(affaireObj.getIdentite().toString().equals(idAffaire)) {
                if(affaireObj.getStatut().equals(Affaire.statutAffaire.ACCOMPTEENCAISSE)) {
                    affaireObj.setStatut(Affaire.statutAffaire.ENCAISEE);
                    SendAffaireEncaisee.sendAffaireEncaisee(idAffaire);
                    return;
                } else {
                    affaireObj.setStatut(Affaire.statutAffaire.ACCOMPTEENCAISSE);
                }
                
            }
        }
    }
}
