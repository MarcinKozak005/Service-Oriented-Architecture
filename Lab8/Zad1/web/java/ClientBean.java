import lombok.Getter;
import lombok.Setter;
import model.Client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

@ManagedBean(name = "ClientBean")
@SessionScoped
@Getter
@Setter
public class ClientBean {

    int id;
    int age;
    String name;
    String image;
    javax.ws.rs.client.Client clientRest = ClientBuilder.newClient();

    static String REST_TARGET = "http://localhost:8080/Zad1_war_exploded/api/clients";

    public void addClient(){
        Client client = new Client();
        client.setAge(age);
        client.setName(name);
        client.setImage(MovieBean.REST_TARGET);

        Entity entity = Entity.entity(client, MediaType.APPLICATION_JSON_TYPE);
        clientRest.target(REST_TARGET).request().post(entity).close();
    }

    public void deleteClient(){clientRest.target(REST_TARGET + "/" + id).request().delete().close(); }

    public void updateClient(){
        Client client = new Client();
        if(age!=0){client.setAge(age);}
        if(name!=null){client.setName(name);}
        client.setImage(MovieBean.REST_TARGET);

        Entity entity = Entity.entity(client,MediaType.APPLICATION_JSON_TYPE);
        clientRest.target(REST_TARGET+"/"+id).request().put(entity).close();
    }

    public List<Client> getClients(){
        Response response = clientRest.target(REST_TARGET).request().get();
        return response.readEntity(new GenericType<List<Client>>(){});
    }

    public InputStream getAppleImage(){
        Response response = clientRest.target("http://localhost:8080/Zad1_war_exploded/api/images/apple").request().get();
        return response.readEntity(InputStream.class);
    }
}
