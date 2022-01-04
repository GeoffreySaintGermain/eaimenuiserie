/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Singleton;

/**
 *
 * @author Kevin
 */
@Singleton
public class ChargeAffaire implements ChargeAffaireLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     private static ArrayList<eaimenuiserie.shared.ChargeAffaire> chargesAffaire;

    @Override
    public ArrayList<eaimenuiserie.shared.ChargeAffaire> getChargesAffaires() {
        if(chargesAffaire == null) {
            chargesAffaire = new ArrayList();
        }
        return chargesAffaire;
    }
    
    @Override
    public eaimenuiserie.shared.ChargeAffaire addChargeAffaire(eaimenuiserie.shared.ChargeAffaire chargeAffaire) {
        eaimenuiserie.shared.ChargeAffaire chargeAffaireToAdd = new eaimenuiserie.shared.ChargeAffaire(chargeAffaire.getNom(), chargeAffaire.getPrenom());
        getChargesAffaires().add(chargeAffaireToAdd);
        System.out.println("liste " + getChargesAffaires());
        return chargeAffaireToAdd;
    }

    @Override
    public boolean existe(UUID chargeAffaireId) {
        for(eaimenuiserie.shared.ChargeAffaire chargeAffaire : getChargesAffaires()) {
            if(chargeAffaire.getIdentite().equals(chargeAffaireId)) {
                return true;
            }
        }
        return false;
    }
  
}
