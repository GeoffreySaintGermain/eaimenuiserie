/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import eaimenuiserie.shared.Affaire;
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
import javax.ws.rs.PathParam;
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
     * @param idCommande La commande que l'on veut modifier
     * @param statutCommandeObj Le nouveau statut de la commande
     * @return Ok/Nok
     */
    @PUT
    @Path("{idCommande}/{statutCommande}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJson(@PathParam("idCommande") String idCommande, @PathParam("statutCommande") String statutCommandeObj) {
        try {
            switch(statutCommandeObj) {
                case "ATTENTEFOURNISSEUR" :
                    commandes.passerCommandeFournisseur(idCommande);
                    break;
                case "LIVREEETSTOCKEE" :
                    commandes.receptionFournisseur(idCommande);
                    break;
                default:
                    return Response.status(Response.Status.BAD_REQUEST).build();
            }
            
            return Response.status(Response.Status.OK).build();
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
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
