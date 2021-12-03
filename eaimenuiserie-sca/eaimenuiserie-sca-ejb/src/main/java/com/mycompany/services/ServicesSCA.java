/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.eaimenuiserie.shared.Affaire;
import com.mycompany.exceptions.AffaireInconnuException;
import javax.ejb.Stateless;

/**
 *
 * @author GeoffreySaint-Germai
 */

@Stateless
public class ServicesSCA implements ServicesSCALocal {

    @Override
    public String majAffaire(Affaire affaire) throws AffaireInconnuException {
        // TODO: Implements
        return null;
    }
    
}
