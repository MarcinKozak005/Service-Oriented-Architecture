package model;

import java.util.List;

public interface DataBaseAPI {
    public List<Movie> getMovies();
    public Movie geMovie(int id);
    public void putMovie(Movie movie);
}
