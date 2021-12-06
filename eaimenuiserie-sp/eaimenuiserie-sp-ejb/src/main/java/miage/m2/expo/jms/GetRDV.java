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
@MessageDriven(mappedName = "rdv", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "spRdv")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "rdv")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class GetRDV implements MessageListener {
    
    public GetRDV() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
