package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue
    int id;

    int age;
    String name;
    String image;

    @ManyToMany
    List<Movie> movieList = new LinkedList<Movie>();

    public User(){};

}
