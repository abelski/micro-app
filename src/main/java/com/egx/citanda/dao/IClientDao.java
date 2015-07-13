package com.egx.citanda.dao;

import com.egx.citanda.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Artur Belski
 */
public interface IClientDao extends PagingAndSortingRepository<Client, String> {

}
