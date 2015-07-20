package com.egx.citanda.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by artyr on 14.09.14.
 */
public enum Role implements GrantedAuthority {
    ROLE_ANONYMOUS,  ROLE_USER, ROLE_ADMIN, ROLE_API;

    @Override
    public String getAuthority() {
        return toString();
    }

}
