package by.abelski.microapp.dao;

import by.abelski.microapp.model.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author Artur Belski
 */
public interface IClientDao extends PagingAndSortingRepository<Client, String> {
    List<Client> findByNameLikeOrPhoneLike(String name, String phone);
}
