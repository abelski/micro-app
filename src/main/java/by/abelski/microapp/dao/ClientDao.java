package by.abelski.microapp.dao;

import by.abelski.microapp.model.Client;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Belski
 */
@Component
@Data
public class ClientDao {
    private List<Client> clients;

    @PostConstruct
    public void init(){
        clients = new ArrayList<Client>();
        clients.add(new Client("Bob", "777"));
        clients.add(new Client("Peter", "777"));
        clients.add(new Client("Sam", "777"));
        clients.add(new Client("Artur", "777"));
        clients.add(new Client("Andry", "777"));
        clients.add(new Client("Nik", "777"));
    }

    public List<Client> getClients(String find) {
        final ArrayList<Client> result = new ArrayList<Client>();
        for (Client client : clients) {
            if(client.getName().toUpperCase().contains(find.toUpperCase()))
                result.add(client);
        }
        return result;
    }
}
