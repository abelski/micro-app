package com.egx.citanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author Artur Belski
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Tender {
    @Id
    private String id;
    private TenderRequest tenderRequest;
    private List<TenderOffer> tenderOffers;

}
