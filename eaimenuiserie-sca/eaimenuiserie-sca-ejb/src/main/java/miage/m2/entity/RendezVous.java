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

    /**
     * Permet d'envoyer un rendez-vous aux poseurs ou aux commerciaux
     * @param rendezVous Le rendez-vous que l'on envoie
     * @param typeRdv Si c'est pour un poseur ou pour un commercial
     */
    @Override
    public void envoyerRendezVous(eaimenuiserie.shared.RendezVous rendezVous, String typeRdv) {
        SendRendezVous.sendRendezVous(rendezVous, typeRdv);
    }
    
}
