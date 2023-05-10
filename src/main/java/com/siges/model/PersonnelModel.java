package com.siges.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "personnel")
public class PersonnelModel {
    @Id
    private String id;
    private String nom_prenom;
    private String email;
    private String telephone;
    private String cv;
    private String image;
}
