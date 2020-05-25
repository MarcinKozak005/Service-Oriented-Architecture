package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = "getAllMovies", query = "SELECT m FROM Movie m")
})
@XmlRootElement
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String uri;

    @ManyToMany(mappedBy = "movieList", fetch = FetchType.EAGER)
    @JsonBackReference
    List<Client> clientList = new LinkedList<Client>();

    public Movie(){};

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    public void removeClient(Client client) {
        client.removeMovie(this);
        this.clientList.remove(client);
    }
}
