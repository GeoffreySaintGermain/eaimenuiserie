/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.PersonneInconnue;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.ejb.Singleton;

/**
 *
 * @author Kevin
 */
@Singleton
public class RendezVous implements RendezVousLocal {

    @EJB
    private CommerciauxLocal commerciaux;
    
    private static ArrayList<eaimenuiserie.shared.RendezVous> rendezVous;
    
    
    @Override
    public ArrayList<eaimenuiserie.shared.RendezVous> getRendezVous() {
        if(rendezVous == null) {
            rendezVous  = new ArrayList<>();
        }
        return rendezVous;
    }

    @Override
    public void addRendezVous(eaimenuiserie.shared.RendezVous rendezVous) throws PersonneInconnue {
        if(commerciaux.existe(rendezVous.getIdentite())) {
            getRendezVous().add(rendezVous);
        } else {
            throw new PersonneInconnue();
        }
    } 
    
    @Override
    public ArrayList<eaimenuiserie.shared.RendezVous> getRendezVous(String id) {
        if(rendezVous == null) {
            rendezVous  = new ArrayList<>();
        }
        ArrayList<eaimenuiserie.shared.RendezVous> userRdv = new ArrayList<>();
        for(eaimenuiserie.shared.RendezVous rdv : rendezVous) {
            if(rdv.getIdentite().toString().equals(id)) {
                userRdv.add(rdv);
            }
        }
        return userRdv;
    }
    
}
