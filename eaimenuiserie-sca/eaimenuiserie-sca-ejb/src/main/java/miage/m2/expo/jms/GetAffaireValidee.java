/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.jms;

import eaimenuiserie.shared.Affaire;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import miage.m2.entity.AffairesLocal;

/**
 *
 * @author Kevin
 */
@MessageDriven(mappedName = "affaireValidee", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "scaAffaireValidee")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "affaireValidee")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class GetAffaireValidee implements MessageListener {

    @EJB
    private AffairesLocal affaires;

    public GetAffaireValidee() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage obj = (TextMessage) message;
                try {
                    affaires.modifierStatut(((TextMessage) message).getText(), Affaire.statutAffaire.VALIDEE);
                } catch (JMSException exception) {
                    System.err.println("Failed to get message text: " + exception);
                }
            }
        } catch (Exception exception) {
                System.err.println("Failed to get message text: " + exception);
        }
    }
    
}
