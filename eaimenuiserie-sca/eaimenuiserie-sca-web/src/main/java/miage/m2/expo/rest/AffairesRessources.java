/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import eaimenuiserie.shared.Affaire;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("affaires")
@RequestScoped
public class AffairesRessources {

    miage.m2.entity.AffairesLocal affaires = lookupAffairesLocal();
    
    private Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AffairesRessources
     */
    public AffairesRessources() {
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.AffairesRessources
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        System.out.println("miage.m2.expo.rest.AffairesRessources.getJson()" + affaires.getAffaires());
        return Response.ok(this.gson.toJson(affaires.getAffaires())).build();
    }

    /**
     * PUT method for updating or creating an instance of AffairesRessources
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(String affaire) {
        try {
            Affaire affaireObj = (Affaire)this.gson.fromJson(affaire, Affaire.class);
            this.affaires.creerAffaire(affaireObj);
            return Response.status(Response.Status.CREATED).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    /**
     * PUT method for updating or creating an instance of AffairesRessources
     * @param content representation for the resource
     */
    /*@PUT
    @Path("{idAffaire}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response validateAffaire(String affaire, @PathParam("idAffaire") String idAffaire) {
        try {
            Affaire.statutAffaire statut;
            if(affaire.equals("CREEE")) {
                statut = Affaire.statutAffaire.CREEE;
            } else if(affaire.equals("MODIFIEE")) {
                statut = Affaire.statutAffaire.MODIFIEE;
            } else if(affaire.equals("FERMEE")) {
                statut = Affaire.statutAffaire.FERMEE;
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            this.affaires.modifierStatut(idAffaire, statut);
            return Response.status(Response.Status.ACCEPTED).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }*/

    private miage.m2.entity.AffairesLocal lookupAffairesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (miage.m2.entity.AffairesLocal) c.lookup("java:global/eaimenuiserie-sca-ear/eaimenuiserie-sca-ejb-1.0-SNAPSHOT/Affaires!miage.m2.entity.AffairesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
