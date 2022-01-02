/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import javax.ejb.Singleton;
import miage.m2.expo.jms.SendRendezVous;

/**
 *
 * @author Kevin
 */
@Singleton
public class RendezVous implements RendezVousLocal {

    @Override
    public void envoyerRendezVous(eaimenuiserie.shared.RendezVous rendezVous) {
        SendRendezVous.sendRendezVous(rendezVous);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
