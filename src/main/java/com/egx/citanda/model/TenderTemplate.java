package com.egx.citanda.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * @author Artur Belski
 */
@Data
public abstract class TenderTemplate {
    @DBRef
    private Client from;
    @DBRef
    private Client to;
    private Long cnt;
    private String name;
}
