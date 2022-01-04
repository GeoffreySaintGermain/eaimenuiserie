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
@MessageDriven(mappedName = "commandeModifiee", activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "sccommandeModifieeLIVREEETSTOCKEE")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable")
    ,
        @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "commandeModifiee")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
    ,
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "JMSType = 'LIVREEETSTOCKEE'")
})
public class GetAffaireModifieeLIVREEETSTOCKEE implements MessageListener {

    @EJB
    private AffairesLocal affaires;

    @EJB
    private CommandesLocal commandes;
    
    
    
    public GetAffaireModifieeLIVREEETSTOCKEE() {
    }
    
    @Override
    public void onMessage(Message message) {
                if (message instanceof TextMessage) {
                    TextMessage obj = (TextMessage) message;
            try {
                String identiteAffaire = commandes.modifierStatut(obj.getText(), Commande.statutCommande.LIVREEETSTOCKEE).toString();
                affaires.modifierStatut(identiteAffaire, Affaire.statutAffaire.COMMANDELIVREE);
            } catch (JMSException exception) {
                System.err.println("Failed to get message text: " + exception);
            }
        }
    }
    
}
