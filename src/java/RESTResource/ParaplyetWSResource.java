/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTResource;

import ParaplyModel.EnrollCode;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Molnet
 */
@Path("paraplyetWS")
public class ParaplyetWSResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ParaplyetWSResource
     */
    public ParaplyetWSResource() {
    }

    /**
     * Retrieves representation of an instance of RESTResource.ParaplyetWSResource
     * @return an instance of java.lang.String
     */
    @GET
    
    @Produces(MediaType.APPLICATION_JSON)
    public EnrollCode getEnrollCode() {
        EnrollCode ec = new EnrollCode();
        ec.setEnrollCode("LTU12345");
        return ec;
    }

    /**
     * PUT method for updating or creating an instance of ParaplyetWSResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}