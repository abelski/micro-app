package by.abelski.microapp.web;

import by.abelski.microapp.dao.ClientDao;
import by.abelski.microapp.model.Client;
import by.abelski.microapp.web.request.FilterRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Artur Belski
 */
@Controller
@RequestMapping("/client")
@Data
public class ClientController {
    @Autowired
    private ClientDao clientDao;

    @ResponseBody
    @RequestMapping("/")
    public List<Client> getAll() {
        return clientDao.getClients();
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Client> search(@RequestBody FilterRequest request) {
        return clientDao.getClients(request.getSearch());
    }
}
