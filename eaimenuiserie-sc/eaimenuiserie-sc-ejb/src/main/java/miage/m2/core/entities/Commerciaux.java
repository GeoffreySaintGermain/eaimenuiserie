/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Commercial;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Singleton;

/**
 *
 * @author Kevin
 */
@Singleton
public class Commerciaux implements CommerciauxLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private static ArrayList<Commercial> commerciaux;

    @Override
    public ArrayList<Commercial> getCommerciaux() {
        if(commerciaux == null) {
            commerciaux  = new ArrayList<>();
        }
        return commerciaux;
    }

    @Override
    public Commercial addCommercial(Commercial commercial) {
        Commercial commercialToAdd = new Commercial(commercial.getNom(), commercial.getPrenom());
        getCommerciaux().add(commercialToAdd);
        return commercialToAdd;
    }

    @Override
    public boolean existe(UUID commercialId) {
        for(Commercial commercial : getCommerciaux()) {
            if(commercial.getIdentite().equals(commercialId)) {
                return true;
            }
        }
        return false;
    }

}
