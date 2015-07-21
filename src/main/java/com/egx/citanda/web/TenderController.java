package com.egx.citanda.web;

import com.egx.citanda.UserService;
import com.egx.citanda.dao.IClientDao;
import com.egx.citanda.dao.ITenderDao;
import com.egx.citanda.dao.ITenderOfferDao;
import com.egx.citanda.model.*;
import com.egx.citanda.web.request.FilterRequest;
import lombok.Data;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Artur Belski
 */
@Controller
@RequestMapping("/tender")
@Data
public class TenderController {
    @Autowired
    private ITenderDao tenderDao;

    @Autowired
    private ITenderOfferDao offerDao;

    @Autowired
    private IClientDao clientDao;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void save(@RequestBody Tender tender) {
        System.out.println(tender);
        tender.getTenderRequest().setStatus(TenderRequestStatus.STARTED);
        tender.getTenderRequest().setFrom(UserService.getAuthUser());
        tenderDao.save(tender);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/offer/{id}", method = RequestMethod.PUT)
    public void putOffer(@RequestBody TenderOffer offer, @PathVariable String id) {
        offer.setFrom(UserService.getAuthUser());
        offer.setStatus(TenderOfferStatus.NOT_SELECTED);
        offerDao.save(offer);
        final Tender tender = tenderDao.findOne(id);
        tender.getTenderOffers().add(offer);
        tenderDao.save(tender);
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Tender> search(@RequestBody FilterRequest request) {
        if (request == null || request.getSearch() == null) return getAll();
        final List<Tender> tenderList = tenderDao.findByTenderRequestNameLike(request.getSearch());
        return filterByUser(tenderList, UserService.getAuthUser());
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        tenderDao.delete(id);
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Tender> getAll() {
        return filterByUser(IteratorUtils.toList(tenderDao.findAll().iterator()), UserService.getAuthUser());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "accept/{tenderId}/{offerId}", method = RequestMethod.GET)
    public void accept(@PathVariable String tenderId, @PathVariable String offerId) {
        final Tender tender = tenderDao.findOne(tenderId);
        final List<TenderOffer> tenderOffers = tender.getTenderOffers();
        for (TenderOffer tenderOffer : tenderOffers) {
            if (tenderOffer.getId().equals(offerId)) {
                tenderOffer.setStatus(TenderOfferStatus.ACCEPTED);
            } else {
                tenderOffer.setStatus(TenderOfferStatus.DECLINED);
            }
            offerDao.save(tenderOffer);
            tender.getTenderRequest().setStatus(TenderRequestStatus.ENDED);
            tenderDao.save(tender);

        }
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "decline/{tenderId}/{offerId}", method = RequestMethod.GET)
    public void decline(@PathVariable String tenderId, @PathVariable String offerId) {
        final Tender tender = tenderDao.findOne(tenderId);
        final List<TenderOffer> tenderOffers = tender.getTenderOffers();
        for (TenderOffer tenderOffer : tenderOffers) {
            if (tenderOffer.getId().equals(offerId)) {
                tenderOffer.setStatus(TenderOfferStatus.DECLINED);
                offerDao.save(tenderOffer);
            }
        }
    }

    private List<Tender> filterByUser(List<Tender> tenderList, Client user) {

        final ArrayList<Tender> tenders = new ArrayList<Tender>();
        if (user.getAuthorities().contains(Role.ROLE_ADMIN)) {
            tenders.addAll(tenderList);
        } else if (user.getAuthorities().contains(Role.ROLE_SUPPLIER)) {
            for (Tender tender : tenderList) {
                final Iterator<TenderOffer> iterator = tender.getTenderOffers().iterator();
                while (iterator.hasNext()) {
                    final TenderOffer next = iterator.next();
                    if (!next.getFrom().getId().equals(user.getId())) {
                        iterator.remove();
                    }
                }
                tenders.add(tender);
            }
        } else {
            for (Tender tender : tenderList) {
                if (tender.getTenderRequest().getFrom().getId().equals(user.getId())) {
                    tenders.add(tender);
                }
            }
        }
        return tenders;
    }
}
