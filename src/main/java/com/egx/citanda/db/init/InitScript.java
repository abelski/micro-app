package com.egx.citanda.db.init;

import com.egx.citanda.model.*;
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


        final com.egx.citanda.model.Client client = new com.egx.citanda.model.Client();
        client.setName("Client1");
        client.getSubscribes().add("Stuff1");
        client.getSubscribes().add("Stuff2");
        client.setPassword("1");
        client.setUsername("1");
        client.getAuthorities().add(Role.ROLE_CONSUMER);

        final com.egx.citanda.model.Client client1 = new com.egx.citanda.model.Client();
        client1.setName("Client2");
        client1.setPassword("2");
        client1.setUsername("2");
        client1.getAuthorities().add(Role.ROLE_SUPPLIER);

        final com.egx.citanda.model.Client client2 = new com.egx.citanda.model.Client();
        client2.setName("Client3");
        client2.setPassword("3");
        client2.setUsername("3");
        client2.getAuthorities().add(Role.ROLE_ADMIN);

        mongoTemplate.save(client);
        mongoTemplate.save(client1);
        mongoTemplate.save(client2);



    }
}
