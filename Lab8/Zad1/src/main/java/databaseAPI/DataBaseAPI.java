package databaseAPI;

import model.Client;
import model.Movie;

import java.util.List;

public interface DataBaseAPI {
    List<Movie> getMovies();
    Movie getMovie(int id);
    void addMovie(Movie movie);
    void updateMovie(Movie updatedMovie, int movieId);
    void deleteMovie(int movieId);
    void deleteMovies();
    void partialUpdateMovie(int movieId, Movie movie);

    List<Client> getClients();
    Client getClient(int clientId);
    void addClient(Client client);
    void updateClient(Client updatedVersion, int clientId);
    void deleteClient(int clientId);
    void deleteClients();


}
