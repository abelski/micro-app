package com.egx.citanda.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by artyr on 14.09.14.
 */
public enum Role implements GrantedAuthority {
    ROLE_ANONYMOUS,  ROLE_ADMIN, ROLE_CONSUMER, ROLE_SUPPLIER;

    @Override
    public String getAuthority() {
        return toString();
    }

}
