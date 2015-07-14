package com.egx.citanda.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Artur Belski
 */
@Document
@Data
public class TenderOffer extends TenderTemplate{
    @Id
    private String id;
    private TenderOfferStatus status;
}
