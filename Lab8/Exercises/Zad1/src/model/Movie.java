package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String imagePath;

    @ManyToMany(mappedBy = "movieList")
    List<User> userList = new LinkedList<User>();
}
