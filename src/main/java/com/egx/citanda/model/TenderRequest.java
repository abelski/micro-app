package com.egx.citanda.model;

import lombok.Data;

/**
 * @author Artur Belski
 */
@Data
public class TenderRequest extends TenderTemplate{
    private TenderRequestStatus status;
}
