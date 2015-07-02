package by.abelski.microapp.web;

import by.abelski.microapp.dao.IClientDao;
import by.abelski.microapp.model.Client;
import by.abelski.microapp.web.request.FilterRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Artur Belski
 */
@Controller
@RequestMapping("/client")
@Data
public class ClientController {
    @Autowired
    private IClientDao clientDao;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void save(@RequestBody Client client) {
        System.out.println(client);
        clientDao.save(client);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        clientDao.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Collection<Client> search(@RequestBody FilterRequest request) {
        if (request == null || request.getSearch() == null) return getAll();
        return clientDao.findByNameLikeOrPhoneLike(request.getSearch(), request.getSearch());
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Client> getAll() {
        final Iterable<Client> all = clientDao.findAll();
        final ArrayList<Client> clients = new ArrayList<Client>();
        for (Client client : all) {
            clients.add(client);
        }
        return clients;
    }
}
