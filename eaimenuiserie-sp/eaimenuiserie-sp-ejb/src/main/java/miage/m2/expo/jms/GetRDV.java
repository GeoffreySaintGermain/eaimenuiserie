/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.jms;

import eaimenuiserie.shared.RendezVous;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import miage.m2.core.entities.RendezVousLocal;

/**
 *
 * @author Kevin
 */
@MessageDriven(mappedName = "rdv", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "spRdv")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "rdv")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
    ,
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JMSType = 'Poseur'")
})
public class GetRDV implements MessageListener {

    @EJB
    private RendezVousLocal rendezVous;
    
    public GetRDV() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage obj = (ObjectMessage) message;
                try {
                    rendezVous.addRendezVous(((RendezVous)obj.getObject()));
                } catch (JMSException exception) {
                    System.err.println("Failed to get message object: " + exception);
                }
            }
        } catch (Exception exception) {
                System.err.println("Failed to get message text: " + exception);
        }
    }
    
}
