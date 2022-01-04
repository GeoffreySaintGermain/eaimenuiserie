/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.jms;

import eaimenuiserie.shared.Affaire;
import eaimenuiserie.shared.Commande;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import miage.m2.core.entities.AffairesLocal;
import miage.m2.core.entities.CommandesLocal;

/**
 *
 * @author Kevin
 */
@MessageDriven(mappedName = "affaireCloturee", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "scaffaireCloturee")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "affaireCloturee")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class GetAffaireFermee implements MessageListener {

    @EJB
    private CommandesLocal commandes;

    @EJB
    private AffairesLocal affaires;
    
    public GetAffaireFermee() {
    }
    
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage obj = (TextMessage) message;
            try {
                affaires.modifierStatut(obj.getText(), Affaire.statutAffaire.FERMEE);
                commandes.fermerCommandesSuiteFermetureAffaire(obj.getText());
            } catch (JMSException exception) {
                System.err.println("Failed to get message text: " + exception);
            }
        }
    }
    
}
