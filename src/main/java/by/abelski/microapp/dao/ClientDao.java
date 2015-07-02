package by.abelski.microapp.dao;

import by.abelski.microapp.model.Client;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Artur Belski
 */
@Component
@Data
public class ClientDao {
    private Map<String, Client> clients;

    @PostConstruct
    public void init(){
        clients = new HashMap<String, Client>();
        clients.put("1",new Client("1", "Bob", "777"));
        clients.put("2",new Client("2", "Peter", "777"));
        clients.put("3",new Client("3", "Sam", "777"));
        clients.put("4",new Client("4", "Artur", "777"));
        clients.put("5",new Client("5", "Andry", "777"));
        clients.put("6",new Client("6", "Nik", "777"));
    }

    public List<Client> getClients(String find) {
        final ArrayList<Client> result = new ArrayList<Client>();
        for (Client client : clients.values()) {
            if(client.getName().toUpperCase().contains(find.toUpperCase()))
                result.add(client);
        }
        return result;
    }

    public void add(Client client) {
        if (client.getId() == null || "".equals(client.getId())) {
            client.setId("" + System.currentTimeMillis());
        }
        clients.put(client.getId(), client);
    }

    public void delete(String id) {
        clients.remove(id);

    }
}
