package com.siges.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matiere")
public class MatiereModel {
    @Id
    private String id;
    private String intitule;
    private String code;

}
