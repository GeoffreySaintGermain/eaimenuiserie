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
import javax.jms.ObjectMessage;
import miage.m2.core.entities.AffairesLocal;

/**
 *
 * @author Kevin
 */
@MessageDriven(mappedName = "affaireModifiee", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "scoaffaireEmise")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "affaireModifiee")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
    ,
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JMSType = 'ENCAISSEMENTOBJECT'")
})
public class GetAffaireEmise implements MessageListener {

    @EJB
    private AffairesLocal affaires;
    
    
    
    public GetAffaireEmise() {
    }
    
    @Override
    public void onMessage(Message message) {
        System.out.println("ccx");
        if (message instanceof ObjectMessage) {
            ObjectMessage obj = (ObjectMessage) message;
            try {
                affaires.ajouterAffaire((Affaire)obj.getObject());
            } catch (JMSException exception) {
                System.err.println("Failed to get message text: " + exception);
            }
        }
    }
    
}
