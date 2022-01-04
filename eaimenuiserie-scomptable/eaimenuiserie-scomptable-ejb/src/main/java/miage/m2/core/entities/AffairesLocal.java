/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Affaire;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface AffairesLocal {
    ArrayList<Affaire> getAffaires();

    void ajouterAffaire(Affaire affaire);
    
    void encaisserAffaire(String idAffaire);
}
