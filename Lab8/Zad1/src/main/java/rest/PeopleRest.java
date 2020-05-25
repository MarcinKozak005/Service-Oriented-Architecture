package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/people")
public class PeopleRest {

    @GET
    public Response getPeople() throws URISyntaxException {
        return Response.status(308).location(new URI("/clients")).build();
    }
}
