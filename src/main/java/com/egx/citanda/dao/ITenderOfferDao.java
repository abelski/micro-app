package com.egx.citanda.dao;

import com.egx.citanda.model.Tender;
import com.egx.citanda.model.TenderOffer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Artur Belski
 */
public interface ITenderOfferDao extends PagingAndSortingRepository<TenderOffer, String> {
}
