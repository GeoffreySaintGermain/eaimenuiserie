/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.controllers;

import java.io.Serializable;
import java.util.UUID;
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
public interface SPBeanLocal {
    
    public void installationValidee(int idCommande);
    
    public void cloturerAffaire(int idAffaire);
    
 }