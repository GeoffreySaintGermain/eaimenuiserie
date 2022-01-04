 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import eaimenuiserie.shared.Affaire;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Singleton;
import miage.m2.expo.jms.SendAffaireEmise;
import miage.m2.expo.jms.SendAffaireFermee;

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
    public void creerAffaire(String rue, String ville, String cp, String mail, 
            String telephone, String entreprise, String lieuPose, UUID referent) {
        Affaire affaireObj = new Affaire(rue, ville, cp, mail, telephone, entreprise, lieuPose, referent);
        getAffaires().add(affaireObj);
        SendAffaireEmise.sendAffaire(affaireObj);
    }
    
    @Override
    public void creerAffaire(Affaire affaire) {
        Affaire affaireObj = new Affaire(affaire.getRue(), affaire.getVille(), affaire.getCp(), affaire.getMail(), affaire.getTelephone(), affaire.getEntreprise(), affaire.getLieuPose(), affaire.getChargeAffaire());
        getAffaires().add(affaireObj);
        SendAffaireEmise.sendAffaire(affaireObj);
    }
    
    @Override
    public void modifierStatut(String idAffaire, Affaire.statutAffaire statut) {
        if(statut.equals(Affaire.statutAffaire.FERMEE)) {
            SendAffaireFermee.sendAffaireFermee(idAffaire);
        }
        for(Affaire aff : getAffaires()) {
            if(aff.getIdentite().toString().equals(idAffaire)) {
                aff.setStatut(statut);
                return;
            }
        }
    }
    
}
