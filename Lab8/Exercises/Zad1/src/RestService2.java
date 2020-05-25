import model.DataBase;
import model.DataBaseAPI;
import model.Movie;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class RestService2{

    @EJB
    DataBaseAPI dataBase;

    @GET
    @Path("/movies/{movieId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovie(@PathParam("movieId") int movieId)
    {
        Movie m = dataBase.geMovie(movieId);
        if(m==null) return Response.status(500).build();
        return Response.status(201).entity(m).build();
    }

    @GET
    @Path("/movies")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovies()
    {
        return Response.status(201).entity(dataBase.getMovies()).build();
    }

    @POST
    @Path("/movies")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putMovie(Movie movie)
    {
        dataBase.putMovie(movie);
        System.out.println(dataBase.getMovies());
        return Response.status(201).build();
    }


}
