package com.siges.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "groupe_matiere")
public class GroupeMatiereModel {
    @Id
    private String id;
    private String label;
}
