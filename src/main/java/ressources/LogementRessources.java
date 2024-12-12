package ressources;

import entities.Logement;
import metiers.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/logement")
public class LogementRessources {

    LogementBusiness logementBusiness=new LogementBusiness();

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.ok()
                       .entity(this.logementBusiness.getLogements()).build();

    }




    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addLogement(Logement logement) {
        if (this.logementBusiness.addLogement(logement)) {
            return Response.status(201).entity("created").build();
        }else
             return Response.status(200).entity("error").build();
    }

//wallah 5edmti

    @GET
    @Path("/getbyid")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(int id){
        return Response.ok()
                .entity(this.logementBusiness.getLogementsByReference(id)).build();

    }

    @GET
    @Path("/getbydelegation/{delegation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByDelegation(String delegation){
        return Response.ok()
                .entity(this.logementBusiness.getLogementsByDeleguation(delegation)).build();

    }
    @GET
    @Path("/getbydelegation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLogementsListeByref(int ref) {
        return Response.ok()
                .entity(this.logementBusiness.getLogementsListeByref(ref)).build();
    }



    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        return Response.ok()
                .entity(this.logementBusiness.deleteLogement(id)).build();
    }

    @PUT
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLogement(@PathParam("id") int id, Logement logement){
    return Response.ok()
            .entity(this.logementBusiness.updateLogement(id,logement)).build();
    }


    @PUT
    @Path("/set")
    @Produces(MediaType.APPLICATION_JSON)
    public Response setLogement() {
        List<Logement> logements = logementBusiness.getLogements();
        logementBusiness.setLogements(logements);
        return Response.ok(logements).build();
    }












    }











