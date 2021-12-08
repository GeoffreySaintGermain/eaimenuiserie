/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import eaimenuiserie.shared.Commande;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import miage.m2.core.entities.CommandesLocal;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("commandes")
@RequestScoped
public class SendCommandes {

    CommandesLocal commandes = lookupCommandesLocal();    
    
    private Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SendCommandes
     */
    public SendCommandes() {
        this.gson = new Gson();
    }

    /**
     * PUT method for updating or creating an instance of SendCommandes
     * @param commande JSON Commande
     * @return CREATED
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String commande) {
        try {
            Commande commandeObj = (Commande)this.gson.fromJson(commande, Commande.class);
            this.commandes.addCommandes(commandeObj);
            return Response.status(Response.Status.CREATED).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private CommandesLocal lookupCommandesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (CommandesLocal) c.lookup("java:global/eaimenuiserie-sc-ear/eaimenuiserie-sc-ejb-1.0-SNAPSHOT/Commandes!miage.m2.core.entities.CommandesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
