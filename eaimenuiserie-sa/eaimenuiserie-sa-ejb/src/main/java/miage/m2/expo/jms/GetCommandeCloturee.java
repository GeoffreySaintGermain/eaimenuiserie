/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Kevin
 */
@MessageDriven(mappedName = "commandeCloturee", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "saCommandeCloturee")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "commandeCloturee")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class GetCommandeCloturee implements MessageListener {
    
    public GetCommandeCloturee() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
