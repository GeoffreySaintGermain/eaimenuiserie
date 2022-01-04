/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import miage.m2.entity.RendezVousLocal;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("rendezvous")
@RequestScoped
public class RendezVous {

    RendezVousLocal rendezVous = lookupRendezVousLocal();
    
    private Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RendezVous
     */
    public RendezVous() {
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.RendezVous
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{type}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("id") String userId, @PathParam("type") String type) {
        Client client = ClientBuilder.newClient();
        WebTarget target;
        if(type.equals("poseurs")) {
            target = client.target("http://localhost:8080/eaimenuiserie-sp-web/webresources/");
        } else {
            target = client.target("http://localhost:8080/eaimenuiserie-sc-web/webresources/");
        }
        target = target.path("rendezvous/" + userId);
	
	Invocation.Builder builder = target.request();
	Response response = builder.get();
        return response;
    }
    /**
     * PUT method for updating or creating an instance of RendezVous
     * @param content representation for the resource
     */
    @POST
    @Path("{type}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(@PathParam("type") String type, String content) {
        try {
            SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.FRANCE);
            JsonObject  jobj = this.gson.fromJson(content, JsonObject.class);            
            eaimenuiserie.shared.RendezVous rendezVousObj = new eaimenuiserie.shared.RendezVous(dateformatter.parse(jobj.get("dateDebut").getAsString()), dateformatter.parse(jobj.get("dateFin").getAsString()), jobj.get("identite").getAsString());
            this.rendezVous.envoyerRendezVous(rendezVousObj, type);
            return Response.status(Response.Status.CREATED).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private RendezVousLocal lookupRendezVousLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (RendezVousLocal) c.lookup("java:global/eaimenuiserie-sca-ear/eaimenuiserie-sca-ejb-1.0-SNAPSHOT/RendezVous!miage.m2.entity.RendezVousLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
