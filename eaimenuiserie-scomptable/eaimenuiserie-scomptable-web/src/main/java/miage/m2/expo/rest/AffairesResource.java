/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
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
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("affaires")
@RequestScoped
public class AffairesResource {

    miage.m2.core.entities.AffairesLocal affaires = lookupAffairesLocal();

    private Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AffairesResource
     */
    public AffairesResource() {
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.AffairesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(gson.toJson(affaires.getAffaires())).build();
    }
    
    @POST
    @Path("{id}/encaisser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response encaisserJson(@PathParam("id") String affaireId) {
        try {
            this.affaires.encaisserAffaire(affaireId);
            return Response.status(Response.Status.OK).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private miage.m2.core.entities.AffairesLocal lookupAffairesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (miage.m2.core.entities.AffairesLocal) c.lookup("java:global/eaimenuiserie-scomptable-ear/eaimenuiserie-scomptable-ejb-1.0-SNAPSHOT/Affaires!miage.m2.core.entities.AffairesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
