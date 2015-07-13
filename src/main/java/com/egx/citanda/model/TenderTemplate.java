package com.egx.citanda.model;

import lombok.Data;

/**
 * @author Artur Belski
 */
@Data
public abstract class TenderTemplate {
    private Client from;
    private Client to;
    private Long cnt;
    private String name;
}
