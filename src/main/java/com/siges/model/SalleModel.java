package com.siges.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "salle")
public class SalleModel {
    // Attributes
    @Id
    private String intitule;
    private String code;
}
