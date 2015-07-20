package com.egx.citanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author Artur Belski
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Client implements UserDetails {
    @Id
    private String id;
    private String name;

    private IClientInfo clientInfo;
    private List<String> subscribes = new ArrayList<String>();

    /**
     * security part
     */
    private String username;
    private String password;

    private boolean isEnabled = true;
    private Collection<Role> authorities = new HashSet<Role>();



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
}
