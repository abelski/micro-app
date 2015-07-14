package com.egx.citanda.db.init;

import com.egx.citanda.model.Tender;
import com.egx.citanda.model.TenderOffer;
import com.egx.citanda.model.TenderRequest;
import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Artur Belski
 */
@ChangeLog
public class InitScript {
    @ChangeSet(order = "001", id = "addFewTenders", author = "abelski")
    public void set1(MongoTemplate mongoTemplate) {
        final Tender tender = new Tender();
        final TenderRequest tenderRequest = new TenderRequest();
        tenderRequest.setName("New Some stuff");
        tenderRequest.setCnt(12l);

        final com.egx.citanda.model.Client from = new com.egx.citanda.model.Client();
        from.setName("Client1");
        tenderRequest.setFrom(from);

        final com.egx.citanda.model.Client to = new com.egx.citanda.model.Client();
        to.setName("Client2");
        tenderRequest.setTo(to);


        tender.setTenderRequest(tenderRequest);
        final TenderOffer tenderOffer = new TenderOffer();
        tenderOffer.setName("New Some stuff");
        tenderOffer.setCnt(12l);
        tenderOffer.setFrom(from);
        tender.getTenderOffers().add(tenderOffer);

        final TenderOffer tenderOffer1 = new TenderOffer();
        tenderOffer1.setName("New Some stuff");
        tenderOffer1.setCnt(12l);
        tenderOffer1.setFrom(from);

        mongoTemplate.save(tenderOffer);
        mongoTemplate.save(tenderOffer1);
        tender.getTenderOffers().add(tenderOffer1);
        mongoTemplate.save(tender);
    }
}
