package ressources;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class Hello {

    @Path("/hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHi(){

        return Response.status(200).entity("hello").build();



    }






}
