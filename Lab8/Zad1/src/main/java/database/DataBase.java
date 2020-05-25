package database;

//import model.User;

import databaseAPI.DataBaseAPI;
import model.Client;
import model.Movie;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

@Local(DataBaseAPI.class)
@Stateful
public class DataBase implements DataBaseAPI {

    @PersistenceContext(name = "PersistenceName1")
    EntityManager em;

    public List<Movie> getMovies() {
        TypedQuery<Movie> query = (TypedQuery<Movie>) em.createNamedQuery("getAllMovies");
        return query.getResultList();
    }

    public Movie getMovie(int id) {
        return em.find(Movie.class,id);
    }

    public void addMovie(Movie movie) {
        try {
            em.persist(movie);
        }
        catch (Exception e){System.out.println("Error persist Movie: "+e);}
    }

    public void updateMovie(Movie updatedMovie, int movieId){
        try{
            Movie movieFromDB = em.find(Movie.class,movieId);
            if(movieFromDB!=null){
                if (!updatedMovie.getTitle().equals(movieFromDB.getTitle())) movieFromDB.setTitle(updatedMovie.getTitle());
                if (!updatedMovie.getUri().equals(movieFromDB.getUri())) movieFromDB.setUri(updatedMovie.getUri());
                em.persist(movieFromDB);
            }
        }catch (Exception e){System.out.println("Error update movie: "+e);}
    }

    public void deleteMovie(int movieId){
        try{
            Movie movie = em.find(Movie.class,movieId);
            List<Client> tmpList = new LinkedList<Client>(movie.getClientList());

            for (Client client: tmpList) movie.removeClient(client);
            em.remove(movie);
        }catch (Exception e){System.out.println("Error delete movie: "+e);}
    }

    public void deleteMovies(){
        TypedQuery<Movie> typedQuery = (TypedQuery<Movie>) em.createNamedQuery("getAllMovies");
        for(Movie movie: typedQuery.getResultList())
            this.deleteMovie(movie.getId());
    }

    @Override
    public void partialUpdateMovie(int movieId, Movie movie) {
        try{
            Movie movieFromDB = em.find(Movie.class,movieId);
            if(movieFromDB!=null){
                if(movie.getTitle()!=null) movieFromDB.setTitle(movie.getTitle());
                if(movie.getUri()!=null) movieFromDB.setUri(movie.getUri());
                em.persist(movieFromDB);
            }
        }catch (Exception e){System.out.println("Error partialUpdate movie: "+e);}
    }

    public List<Client> getClients() {
        TypedQuery<Client> typedQuery = (TypedQuery<Client>) em.createNamedQuery("getAllClients");
        return typedQuery.getResultList();
    }

    public Client getClient(int clientId) {
        return em.find(Client.class,clientId);
    }

    public void addClient(Client client) {
        try {
            em.persist(client);
        }
        catch (Exception e){
            System.out.println("Error persist Client: "+e);}
    }

    public void updateClient(Client updatedVersion, int clientId){
        try {
            Client clientFromDB = em.find(Client.class, clientId);
            if (clientFromDB != null) {
                if (updatedVersion.getAge() != clientFromDB.getAge()) clientFromDB.setAge(updatedVersion.getAge());
                if (!updatedVersion.getName().equals(clientFromDB.getName()))
                    clientFromDB.setName(updatedVersion.getName());
                if (!updatedVersion.getImage().equals(clientFromDB.getImage()))
                    clientFromDB.setImage(updatedVersion.getImage());
                if (!updatedVersion.getMovieList().equals(clientFromDB.getMovieList())) {
                    clientFromDB.setMovieList(updatedVersion.getMovieList());
                }
                em.persist(clientFromDB);
            }
        }catch (Exception e){System.out.println("Error update client: "+e);}
    }

    public void deleteClient(int clientId){
        try {
            em.remove(em.find(Client.class,clientId));
        }
        catch (Exception e){
            System.out.println("Error delete client: "+e);}
    }

    public void deleteClients() {
        TypedQuery<Client> typedQuery = (TypedQuery<Client>) em.createNamedQuery("deleteAllClients");
        typedQuery.executeUpdate();
    }
}
