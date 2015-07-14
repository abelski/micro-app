package com.egx.citanda.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Artur Belski
 */
@Document
public class TenderOffer extends TenderTemplate{
    @Id
    private String id;
}
