package com.siges.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "type_sanction")
public class TypeSanctionModel {
    // Attributes
    @Id
    private String id;
    private String label;
}
