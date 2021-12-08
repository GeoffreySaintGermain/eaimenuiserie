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

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("commandes")
@RequestScoped
public class SendCommandes {

    miage.m2.core.entities.CommandesBean commandesBean = lookupCommandesBeanBean();
    
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
     * Retrieves representation of an instance of miage.m2.expo.rest.SendCommandes
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of SendCommandes
     * @param content representation for the resource
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response postJson(String commande) {
        Commande commandeObj = (Commande)this.gson.fromJson(commande, Commande.class);
        this.commandesBean.addCommandes(commandeObj);
        return Response.ok(this.gson.toJson("OK")).build();
    }

    private miage.m2.core.entities.CommandesBean lookupCommandesBeanBean() {
        try {
            javax.naming.Context c = new InitialContext();
            return (miage.m2.core.entities.CommandesBean) c.lookup("java:global/eaimenuiserie-sc-ear/eaimenuiserie-sc-ejb-1.0-SNAPSHOT/CommandesBean!miage.m2.core.entities.CommandesBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
