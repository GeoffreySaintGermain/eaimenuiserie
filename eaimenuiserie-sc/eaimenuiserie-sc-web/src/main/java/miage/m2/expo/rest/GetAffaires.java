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
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import miage.m2.core.entities.AffairesLocal;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("affaires")
@RequestScoped
public class GetAffaires {

    AffairesLocal affaires = lookupAffairesLocal();

    private Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GetAffaires
     */
    public GetAffaires() {
        this.gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.GetAffaires
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(this.gson.toJson(this.affaires.getAffaires())).build();
    }

    /**
     * PUT method for updating or creating an instance of GetAffaires
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

    private AffairesLocal lookupAffairesLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (AffairesLocal) c.lookup("java:global/eaimenuiserie-sc-ear/eaimenuiserie-sc-ejb-1.0-SNAPSHOT/Affaires!miage.m2.core.entities.AffairesLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
