/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.entity;

import eaimenuiserie.shared.Affaire;
import eaimenuiserie.shared.ChargeAffaire;
import java.util.ArrayList;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface AffairesLocal {
    
    public ArrayList<Affaire> getAffaires();

    void creerAffaire(String rue, String ville, String cp, String mail, String telephone, String entreprise, String lieuPose, ChargeAffaire referent);
    
    public void creerAffaire(Affaire affaire);

    public void modifierStatut(String idAffaire, Affaire.statutAffaire statut);
}
