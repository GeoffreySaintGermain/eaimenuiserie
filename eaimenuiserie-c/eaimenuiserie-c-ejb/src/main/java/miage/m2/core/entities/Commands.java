/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.core.entities;

import eaimenuiserie.shared.Commande;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
public class Commands {
    
    private static ArrayList<Commande> commands;
    
    public static ArrayList<Commande> getCommands() {
        if(commands == null) {
            commands  = new ArrayList<>();
        }
        return commands;
    }
}
