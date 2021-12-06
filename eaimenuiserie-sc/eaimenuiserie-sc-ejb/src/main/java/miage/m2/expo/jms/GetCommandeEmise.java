/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Kevin
 */
@MessageDriven(mappedName = "commandeEmise", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class GetCommandeEmise implements MessageListener {
    
    public GetCommandeEmise() {
    }
    
    @Override
    public void onMessage(Message message) {
    }
    
}
