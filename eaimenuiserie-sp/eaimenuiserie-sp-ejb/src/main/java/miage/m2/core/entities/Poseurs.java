/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Poseur;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Singleton;

/**
 *
 * @author Kevin
 */
@Singleton
public class Poseurs implements PoseursLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static ArrayList<Poseur> poseurs;

    @Override
    public ArrayList<Poseur> getPoseurs() {
        if(poseurs == null) {
            poseurs = new ArrayList<>();
        }
        return poseurs;
    }

    @Override
    public void addPoseur(Poseur poseur) {
        getPoseurs().add(new Poseur(poseur.getNom(), poseur.getPrenom()));
    }

    @Override
    public boolean existe(UUID uuidPoseur) {
        for(Poseur commercial : getPoseurs()) {
            if(commercial.getIdentite().equals(uuidPoseur)) {
                return true;
            }
        }
        return false;
    }
    
}
