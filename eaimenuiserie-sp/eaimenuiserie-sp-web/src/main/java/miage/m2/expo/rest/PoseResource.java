/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import eaimenuiserie.shared.Affaire;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import miage.m2.core.entities.AffairesLocal;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("pose")
@RequestScoped
public class PoseResource {

    AffairesLocal affaires = lookupAffairesLocal();
    
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PoseResource
     */
    public PoseResource() {
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.PoseResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PoseResource
     * @param content representation for the resource
     */
    @POST
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(@PathParam("id") String affaireId) {
        affaires.modifierStatut(affaireId, Affaire.statutAffaire.POSEE);
    }

    private AffairesLocal lookupAffairesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (AffairesLocal) c.lookup("java:global/eaimenuiserie-sp-ear/eaimenuiserie-sp-ejb-1.0-SNAPSHOT/Affaires!miage.m2.core.entities.AffairesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
