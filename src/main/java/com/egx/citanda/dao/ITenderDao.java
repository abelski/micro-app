package com.egx.citanda.dao;

import com.egx.citanda.model.Client;
import com.egx.citanda.model.Tender;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Artur Belski
 */
public interface ITenderDao extends PagingAndSortingRepository<Tender, String> {
}
