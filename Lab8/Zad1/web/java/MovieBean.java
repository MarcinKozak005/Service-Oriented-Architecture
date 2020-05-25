import lombok.Getter;
import lombok.Setter;
import model.Movie;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ManagedBean(name = "MovieBean")
@SessionScoped
@Getter
@Setter
public class MovieBean {

    int id;
    String title;
    Client clientRest = ClientBuilder.newClient();

    static String REST_TARGET = "http://localhost:8080/Zad1_war_exploded/api/movies";

    //URI
    public void addMovie(){

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setUri("TestURI");
        Entity entity = Entity.entity(movie, MediaType.APPLICATION_JSON_TYPE);
        clientRest.target(REST_TARGET).request().post(entity).close();
    }

    public void deleteMovie(){
        clientRest.target(REST_TARGET+"/"+id).request().delete().close();
    }

    public void updateMovie(){
        Movie movie = new Movie();
        movie.setTitle(title);
        Entity entity = Entity.entity(movie,MediaType.APPLICATION_JSON_TYPE);
        clientRest.target(REST_TARGET+"/"+id).request().put(entity).close();
    }

    public List<Movie> getMovies() {
        Response response = clientRest.target(REST_TARGET).request().get();
        return response.readEntity(new GenericType<List<Movie>>(){});
    }
}
