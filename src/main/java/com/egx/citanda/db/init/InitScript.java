package com.egx.citanda.db.init;

import com.egx.citanda.model.Tender;
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
        mongoTemplate.save(tender);
    }
}
