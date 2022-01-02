/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import java.util.UUID;
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
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import miage.m2.core.entities.RendezVousLocal;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("rendezvous")
@RequestScoped
public class RendezVousResource {

    RendezVousLocal rendezVous = lookupRendezVousLocal();
    
    private Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RendezVousResource
     */
    public RendezVousResource() {
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.RendezVousResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("id") String userId) {
        return Response.ok(gson.toJson(this.rendezVous.getRendezVous(userId))).build();
    }

    /**
     * PUT method for updating or creating an instance of RendezVousResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void postJson(String content) {
    }

    private RendezVousLocal lookupRendezVousLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (RendezVousLocal) c.lookup("java:global/eaimenuiserie-sc-ear/eaimenuiserie-sc-ejb-1.0-SNAPSHOT/RendezVous!miage.m2.core.entities.RendezVousLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
