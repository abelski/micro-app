package com.egx.citanda.model;

import lombok.Data;

/**
 * @author Artur Belski
 */
@Data
public class Customer implements IClientInfo {
    @Override
    public String getDescription() {
        return ""; //build customer text
    }
}
