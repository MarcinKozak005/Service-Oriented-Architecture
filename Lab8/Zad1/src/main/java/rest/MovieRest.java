package rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import databaseAPI.DataBaseAPI;
import model.Movie;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("/movies")
//Example endpoint: http://localhost:8080/Zad1_war_exploded/api/movies
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieRest {
    @EJB
    DataBaseAPI dataBase;

    @GET
    @Path("/{movieId}")
    public Response getMovie(@PathParam("movieId") int movieId)
    {
        try {
            Movie m = dataBase.getMovie(movieId);
            if (m == null) return Response.status(404).build();
            else return Response.status(200).entity(m).build();
        }catch (RuntimeException e) {return Response.status(500).build();}
    }

    @GET
    public Response getMovies(@QueryParam("title") String title)
    {
        try {
            List<Movie> tmpList = dataBase.getMovies();
            if(title!=null && !title.equals("")){
                tmpList = tmpList.stream()
                        .filter(m -> m.getTitle().equals(title))
                        .collect(Collectors.toList());
            }
            if(tmpList.size()==0) return Response.status(404).build();
            return Response.status(200).entity(tmpList).build();
        }catch (RuntimeException e) {return Response.status(500).build();}
    }

    @POST
    public Response addMovie(Movie movie)
    {
        try {
            dataBase.addMovie(movie);
            return Response.status(201).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @PUT
    @Path("/{movieId}")
    public Response updateMovie(Movie movie, @PathParam("movieId") int movieId){
        try {
            if(dataBase.getMovie(movieId)==null) return Response.status(404).build();
            dataBase.updateMovie(movie,movieId);
            return Response.status(200).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @DELETE
    public Response deleteMovies(){
        try {
            dataBase.deleteMovies();
            return Response.status(200).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @DELETE
    @Path("/{movieId}")
    public Response deleteMovie(@PathParam("movieId") int movieId){
        try {
            if(dataBase.getMovie(movieId)==null) return Response.status(404).build();
            dataBase.deleteMovie(movieId);
            return Response.status(200).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @PATCH
    @Path("/{movieId}")
    public Response partialUpdateMovie(@PathParam("movieId") int movieId, Movie movie){
        try{
            if(dataBase.getMovie(movieId)==null) return Response.status(404).build();
            dataBase.partialUpdateMovie(movieId,movie);
            return Response.status(204).build();
        }catch (Exception e){return Response.status(500).build();}
    }

    @GET
    @Path("/uri-list")
    @Produces("text/uri-list")
    public String getUris() throws JsonProcessingException {
        List<Movie> tmpList = dataBase.getMovies();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(tmpList.stream().map(Movie::getUri).collect(Collectors.toList()));
    }
}
