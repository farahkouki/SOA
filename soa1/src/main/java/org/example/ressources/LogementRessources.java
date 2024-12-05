package org.example.ressources;

import org.example.entities.Logement;
import org.example.metiers.LogementBusiness;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/logements")
public class LogementRessources {
    public static LogementBusiness logb = new LogementBusiness();
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response ajouterLogement(Logement l) {
        if(logb.addLogement(l))
            return Response.status(Status.CREATED).build();
        else
            return Response.status(Status.NOT_FOUND).build();
    }
}
