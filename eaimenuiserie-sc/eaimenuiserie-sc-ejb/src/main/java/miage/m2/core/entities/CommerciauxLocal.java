/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Commercial;
import java.util.ArrayList;
import java.util.UUID;
import javax.ejb.Local;

/**
 *
 * @author Kevin
 */
@Local
public interface CommerciauxLocal {

    ArrayList<Commercial> getCommerciaux();

    Commercial addCommercial(Commercial commercial);
    
    boolean existe(UUID commercialId);
    
}
