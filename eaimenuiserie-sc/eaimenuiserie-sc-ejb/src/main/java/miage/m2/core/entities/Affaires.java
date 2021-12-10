/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Affaire;
import eaimenuiserie.shared.ChargeAffaire;
import java.util.ArrayList;
import javax.ejb.Singleton;

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
        affaires.add(new Affaire(affaire.getRue(), affaire.getVille(), affaire.getCp(), affaire.getMail(), affaire.getTelephone(), affaire.getEntreprise(), affaire.getLieuPose(), new ChargeAffaire(affaire.getReferent().getNom(), affaire.getReferent().getPrenom())));
    }
    
    
}
