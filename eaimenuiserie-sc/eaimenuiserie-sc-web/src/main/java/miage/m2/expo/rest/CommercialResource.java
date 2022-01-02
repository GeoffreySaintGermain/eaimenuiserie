/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import eaimenuiserie.shared.Commercial;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import miage.m2.core.entities.CommerciauxLocal;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("commerciaux")
@RequestScoped
public class CommercialResource {

    CommerciauxLocal commerciaux = lookupCommerciauxLocal();
    
    private Gson gson;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CommercialResource
     */
    public CommercialResource() {
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.CommercialResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(gson.toJson(commerciaux.getCommerciaux())).build();
    }

    /**
     * PUT method for updating or creating an instance of CommercialResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(String content) {
        try {
            Commercial commercialObj = (Commercial)this.gson.fromJson(content, Commercial.class);
            System.out.println("nom " + commercialObj.getNom());
            System.out.println("prenom " + commercialObj.getPrenom());
            System.out.println("uuid " + commercialObj.getIdentite());
            this.commerciaux.addCommercial(commercialObj);
            return Response.status(Response.Status.CREATED).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private CommerciauxLocal lookupCommerciauxLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (CommerciauxLocal) c.lookup("java:global/eaimenuiserie-sc-ear/eaimenuiserie-sc-ejb-1.0-SNAPSHOT/Commerciaux!miage.m2.core.entities.CommerciauxLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
