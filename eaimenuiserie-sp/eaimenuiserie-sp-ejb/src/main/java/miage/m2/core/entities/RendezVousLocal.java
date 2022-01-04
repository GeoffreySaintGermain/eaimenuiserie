/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.PersonneInconnue;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface RendezVousLocal {
    public ArrayList<eaimenuiserie.shared.RendezVous> getRendezVous();

    void addRendezVous(eaimenuiserie.shared.RendezVous rendezVous) throws PersonneInconnue;
    
    ArrayList<eaimenuiserie.shared.RendezVous> getRendezVous(String id);

    void confimerRendezVous(String idAffaire) throws Exception;
    
    
}
