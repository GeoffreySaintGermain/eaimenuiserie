/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface RendezVousLocal {

    void envoyerRendezVous(eaimenuiserie.shared.RendezVous rendezVous, String typeRdv);
    
}
