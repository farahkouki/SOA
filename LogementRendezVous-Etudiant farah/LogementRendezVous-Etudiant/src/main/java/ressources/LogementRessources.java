package ressources;

import entities.Logement;
import filtres.Secured;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Path("logements")
public class LogementRessources {
    public static LogementBusiness logementMetier = new LogementBusiness();






    @POST
    @Secured
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLogement(Logement l) {
     if(logementMetier.addLogement(l))
         return  Response.status(Status.CREATED).build();
     return  Response.status(Status.NOT_FOUND).build();
    }

@Secured
@Path("/getLogement")
@GET
@Produces(MediaType.APPLICATION_JSON)
    public Response getLogements() {
        List<Logement> liste=logementMetier.getLogements();
    if(liste.size()==0)
        return  Response.status(Status.NOT_FOUND).build();
    return  Response.status(Status.OK).entity(liste).build();


    }
    @PUT
    @Secured
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLogement(@PathParam("id") int id, Logement logement){
        return Response.ok()
                .entity(this.logementMetier.updateLogement(id,logement)).build();
    }

/*@PUT
@Consumes(MediaType.APPLICATION_JSON)
    public Response updateLogement(Logement updatedLogement, int reference) {


        if (logementMetier.updateLogement(reference,updatedLogement)) {
            return Response.status(Status.OK).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }*/

        @DELETE
        @Secured
        @Path("/delete/{reference}")
        @Produces(MediaType.APPLICATION_JSON)
        public  Response deleteLogement(int reference){
           if(logementMetier.deleteLogement(reference))
                    return Response.status(Status.OK).build();


            return Response.status(Status.NOT_FOUND).build();

        }








    @GET
    @Secured
    @Path("/getbyid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id){
        return Response.ok()
                .entity(this.logementMetier.getLogementsByReference(id)).build();

    }

    @GET
    @Secured
    @Path("/getbydelegation/{delegation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDelegation(String delegation){
        return Response.ok()
                .entity(this.logementMetier.getLogementsByDeleguation(delegation)).build();

    }
    @GET
    @Secured
    @Path("/getbydelegation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementsListeByref(int ref) {
        return Response.ok()
                .entity(this.logementMetier.getLogementsListeByref(ref)).build();
    }








    @PUT
    @Secured
    @Path("/set")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setLogement() {
        List<Logement> logements = logementMetier.getLogements();
        logementMetier.setLogements(logements);
        return Response.ok(logements).build();
    }



}
