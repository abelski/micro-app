package com.egx.citanda;

import com.egx.citanda.dao.IClientDao;
import com.egx.citanda.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Artur Belski
 */
public class UserService implements UserDetailsService {
    @Autowired
    IClientDao clientDao;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        final Client client = clientDao.findOneByUsername(s);
        return client;
    }
}
