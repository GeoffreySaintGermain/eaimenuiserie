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
@MessageDriven(mappedName = "commandeValidee", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class GetCommandeValidee implements MessageListener {
    
    public GetCommandeValidee() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
