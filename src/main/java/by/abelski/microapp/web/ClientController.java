package by.abelski.microapp.web;

import by.abelski.microapp.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Belski
 */
@Controller
@RequestMapping("/client")
public class ClientController {

    @ResponseBody
    @RequestMapping("/")
    public List<Client> getAll(){
        final ArrayList<Client> clients = new ArrayList<Client>();
        clients.add(new Client("Bob", "777"));
        clients.add(new Client("Peter", "777"));
        clients.add(new Client("Sam", "777"));
        return clients;
    }
}
