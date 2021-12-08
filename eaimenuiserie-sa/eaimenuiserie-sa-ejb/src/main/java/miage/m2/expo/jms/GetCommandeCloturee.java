/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.jms;

import eaimenuiserie.shared.Commande;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import miage.m2.core.entities.CommandesBean;

/**
 *
 * @author Kevin
 */
@MessageDriven(mappedName = "commandeCloturee", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "saCommandeClotureeV")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "commandeCloturee")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class GetCommandeCloturee implements MessageListener {

    @EJB
    private CommandesBean commandesBean;

    public GetCommandeCloturee() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof ObjectMessage) {
                ObjectMessage obj = (ObjectMessage) message;
                try {
                    commandesBean.removeCommandes(((Commande)obj.getObject()).getIdentite());
                } catch (JMSException exception) {
                    System.err.println("Failed to0 get message text: " + exception);
                }
            }
        } catch (Exception exception) {
                System.err.println("Failed to get message text: " + exception);
        }
    }
    
}
