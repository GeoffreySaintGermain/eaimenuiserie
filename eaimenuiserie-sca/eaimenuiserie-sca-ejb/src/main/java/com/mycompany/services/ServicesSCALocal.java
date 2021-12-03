/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.mycompany.eaimenuiserie.shared.Affaire;
import com.mycompany.exceptions.AffaireInconnuException;
import java.io.Serializable;
import javax.ejb.Local;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author GeoffreySaint-Germai
 */
@Local
public interface ServicesSCALocal {

   public String majAffaire(Affaire affaire) throws AffaireInconnuException;
    
}
