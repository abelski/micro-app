package com.egx.citanda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Belski
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Client {
   @Id
   private String id;
   private String name;
   private IClientInfo clientInfo;
   private List<String> subscribes = new ArrayList<String>();
}
