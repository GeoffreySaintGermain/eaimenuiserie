/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.m2.expo.rest;

import com.google.gson.Gson;
import eaimenuiserie.shared.ChargeAffaire;
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
import miage.m2.entity.ChargeAffaireLocal;

/**
 * REST Web Service
 *
 * @author Kevin
 */
@Path("chargesaffaire")
@RequestScoped
public class ChargeAffaireResource {

    ChargeAffaireLocal chargeAffaire = lookupChargeAffaireLocal();
    
    private Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ChargeAffaireResource
     */
    public ChargeAffaireResource() {
        gson = new Gson();
    }

    /**
     * Retrieves representation of an instance of miage.m2.expo.rest.ChargeAffaireResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        return Response.ok(gson.toJson(chargeAffaire.getChargesAffaires())).build();
    }

    /**
     * PUT method for updating or creating an instance of ChargeAffaireResource
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJson(String content) {
        try {
            ChargeAffaire chargeAffaireObj = (ChargeAffaire)this.gson.fromJson(content, ChargeAffaire.class);
            this.chargeAffaire.addChargeAffaire(chargeAffaireObj);
            return Response.status(Response.Status.CREATED).build();        
        } catch(Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    private ChargeAffaireLocal lookupChargeAffaireLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (ChargeAffaireLocal) c.lookup("java:global/eaimenuiserie-sca-ear/eaimenuiserie-sca-ejb-1.0-SNAPSHOT/ChargeAffaire!miage.m2.entity.ChargeAffaireLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
