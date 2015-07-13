package com.egx.citanda.web;

import com.egx.citanda.dao.IClientDao;
import com.egx.citanda.dao.ITenderDao;
import com.egx.citanda.model.Client;
import com.egx.citanda.model.Tender;
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
@RequestMapping("/tender")
@Data
public class TenderController {
    @Autowired
    private ITenderDao tenderDao;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void save(@RequestBody Tender client) {
        System.out.println(client);
        tenderDao.save(client);
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Iterable<Tender> search(@RequestBody FilterRequest request) {
        if (request == null || request.getSearch() == null) return getAll();
        return tenderDao.findByTenderRequestFromNameLikeAndTenderRequestNameLike(request.getSearch(), request.getSearch());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        tenderDao.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Tender> getAll() {
        return tenderDao.findAll();
    }
}
