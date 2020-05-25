package model;

import model.Movie;
//import model.User;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Local(DataBaseAPI.class)
@Stateful
public class DataBase implements DataBaseAPI {
    public List<User> users = new LinkedList<User>();
    public List<Movie> movies = new LinkedList<Movie>();

    public DataBase(){
        Movie m1 = new Movie(); m1.setId(123);m1.setTitle("Movie 1");
        Movie m2 = new Movie(); m2.setId(223);m2.setTitle("Movie 2");
        Movie m3 = new Movie(); m3.setId(323);m3.setTitle("Movie 3");
        movies.addAll(Arrays.asList(m1,m2,m3));

        User u1 = new User();u1.setId(1);u1.setName("Adam");u1.setAge(12);u1.getMovieList().addAll(Arrays.asList(m1,m2,m3));
        User u2 = new User();u2.setId(2);u2.setName("Adam");u2.setAge(22);u1.getMovieList().addAll(Arrays.asList(m2,m3));
        users.addAll(Arrays.asList(u1,u2));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Movie geMovie(int id) {
        for(Movie m: movies)
            if(m == null) return m;
        return null;
    }

    public void putMovie(Movie movie) {
        movies.add(movie);
    }
}
