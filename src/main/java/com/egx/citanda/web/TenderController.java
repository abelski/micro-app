package com.egx.citanda.web;

import com.egx.citanda.dao.IClientDao;
import com.egx.citanda.dao.ITenderDao;
import com.egx.citanda.dao.ITenderOfferDao;
import com.egx.citanda.model.Tender;
import com.egx.citanda.model.TenderOffer;
import com.egx.citanda.model.TenderOfferStatus;
import com.egx.citanda.model.TenderRequestStatus;
import com.egx.citanda.web.request.FilterRequest;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        tender.getTenderRequest().setFrom(clientDao.findAll().iterator().next());
        tenderDao.save(tender);
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Iterable<Tender> search(@RequestBody FilterRequest request) {
        if (request == null || request.getSearch() == null) return getAll();
        return tenderDao.findByTenderRequestNameLike(request.getSearch());
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
}
