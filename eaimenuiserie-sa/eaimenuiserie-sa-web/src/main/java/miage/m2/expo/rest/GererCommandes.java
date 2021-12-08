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
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class GererCommandes {

    CommandesLocal commandes = lookupCommandesLocal();

    @Context
    private UriInfo context;
    
    private Gson gson;

    /**
     * Creates a new instance of GererCommandes
     */
    public GererCommandes() {
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.GererCommandes
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(this.gson.toJson(commandes.getCommandes())).build();
    }

    /**
     * PUT method for updating or creating an instance of GererCommandes
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    private CommandesLocal lookupCommandesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (CommandesLocal) c.lookup("java:global/eaimenuiserie-sa-ear/eaimenuiserie-sa-ejb-1.0-SNAPSHOT/Commandes!miage.m2.core.entities.CommandesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
