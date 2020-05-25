package simpleExample;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/MyRestService")
@ApplicationPath("/resources")
public class RestService extends Application {

    @GET
    @Path("/seyHello")
    public String helloWorldMsg(){
        return "Hello World";
    }

    @GET
    @Path("/echo")
    public Response getEchoMsg(@QueryParam("message") String msg){
        return Response.ok("Message was: "+msg).build();
    }

    @GET
    @Path("/obj")
    @Produces(MediaType.APPLICATION_JSON)
    public SimpleObj getObj(){
        return new SimpleObj(2,"john");
    }

}
