package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@Entity
@NamedQueries({
        @NamedQuery(name = "getAllClients", query = "SELECT c FROM Client c"),
        @NamedQuery(name = "deleteAllClients", query = "DELETE FROM Client c")
})
public class Client implements Serializable {
    @Id
    @GeneratedValue
    int id;

    int age;
    String name;
    String image;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Movie> movieList = new LinkedList<Movie>();

    public Client(){};

    public void removeMovie(Movie movie){
        movieList.remove(movie);
    }

}
