package com.siges.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "compte")
public class CompteModel {
    // Attributes
    @Id
    private String id;
    private String login;
    private String password;
    private String status;

}
