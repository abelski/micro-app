package com.egx.citanda.web;

import com.egx.citanda.UserService;
import com.egx.citanda.dao.IClientDao;
import com.egx.citanda.model.Client;
import com.egx.citanda.model.Role;
import com.egx.citanda.web.request.FilterRequest;
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
        clientDao.save(client);
    }

    @ResponseBody
    @RequestMapping(value = "/active")
    public Client active() {
        final Client user = UserService.getAuthUser();
        return user;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        clientDao.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Iterable<Client> search(@RequestBody FilterRequest request) {
        if (request == null || request.getSearch() == null) return getAll();
        return clientDao.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection<Client> getAll() {
        final Client authUser = UserService.getAuthUser();
        if (!authUser.getAuthorities().contains(Role.ROLE_ADMIN)) {
            final ArrayList<Client> clients = new ArrayList<Client>();
            clients.add(authUser);
            return clients;
        }

        final Iterable<Client> all = clientDao.findAll();
        final ArrayList<Client> clients = new ArrayList<Client>();
        for (Client client : all) {
            clients.add(client);
        }
        return clients;
    }
}
