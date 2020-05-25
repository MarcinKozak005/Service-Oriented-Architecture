package rest;

import databaseAPI.DataBaseAPI;
import model.Client;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/clients")
//Example endpoint: http://localhost:8080/Zad1_war_exploded/api/clients
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientsRest{

    @EJB
    DataBaseAPI dataBase;

    @GET
    @Path("/{clientId}")
    public Response getClient(@PathParam("clientId") int clientId)
    {
        try {
            Client client = dataBase.getClient(clientId);
            if (client == null) return Response.status(404).build();
            else return Response.status(200).entity(client).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @GET
    public Response getClients(){
        try {
            List<Client> clients = dataBase.getClients();
            if(clients.size()==0) return Response.status(404).build();
            return Response.status(200).entity(clients).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @POST
    public Response addClient(Client client)
    {
        try {
            dataBase.addClient(client);
            return Response.status(201).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @PUT
    @Path("/{clientId}")
    public Response updateClient(Client client, @PathParam("clientId") int clientId){
        try {
            if(dataBase.getClient(clientId)==null) return Response.status(404).build();
            dataBase.updateClient(client,clientId);
            return Response.status(200).build();
        }catch (RuntimeException e){return Response.status(500).build();}

    }

    @DELETE
    public Response deleteClients(){
        try {
            dataBase.deleteClients();
            return Response.status(200).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }

    @DELETE
    @Path("/{clientId}")
    public Response deleteClient(@PathParam("clientId") int clientId){
        try {
            if(dataBase.getClient(clientId)==null) return Response.status(404).build();
            dataBase.deleteClient(clientId);
            return Response.status(201).build();
        }catch (RuntimeException e){return Response.status(500).build();}
    }
}
