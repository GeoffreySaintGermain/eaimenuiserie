/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import eaimenuiserie.shared.Affaire;
import java.util.ArrayList;
import javax.ejb.Singleton;
import miage.m2.expo.jms.SendAffaireEmise;

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
            String telephone, String entreprise, String lieuPose) {
        getAffaires().add(new Affaire(rue, ville, cp, mail, telephone, entreprise, lieuPose));
    }
    
    @Override
    public void creerAffaire(Affaire affaire) {
        Affaire affaireObj = new Affaire(affaire.getRue(), affaire.getVille(), affaire.getCp(), affaire.getMail(), affaire.getTelephone(), affaire.getEntreprise(), affaire.getLieuPose());
        getAffaires().add(affaireObj);
        SendAffaireEmise.sendAffaire(affaireObj);
    }
    
    @Override
    public void modifierStatut(String idAffaire, Affaire.statutAffaire statut) {
        for(Affaire aff : affaires) {
            if(aff.getIdentite().toString().equals(idAffaire)) {
                aff.setStatut(statut);
                return;
            }
        }
    }
    
}
