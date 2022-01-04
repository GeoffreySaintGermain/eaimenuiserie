/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import eaimenuiserie.shared.Poseur;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
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
@Path("poseurs")
@RequestScoped
public class PoseursResource {

    miage.m2.core.entities.PoseursLocal poseurs = lookupPoseursLocal();
    
    private Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PoseursResource
     */
    public PoseursResource() {
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.PoseursResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(gson.toJson(poseurs.getPoseurs())).build();
    }

    /**
     * PUT method for updating or creating an instance of PoseursResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(String content) {
        try {
            Poseur poseurObj = (Poseur)this.gson.fromJson(content, Poseur.class);
            this.poseurs.addPoseur(poseurObj);
            return Response.status(Response.Status.CREATED).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private miage.m2.core.entities.PoseursLocal lookupPoseursLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (miage.m2.core.entities.PoseursLocal) c.lookup("java:global/eaimenuiserie-sp-ear/eaimenuiserie-sp-ejb-1.0-SNAPSHOT/Poseurs!miage.m2.core.entities.PoseursLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
