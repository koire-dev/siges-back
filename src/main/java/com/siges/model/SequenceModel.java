package com.siges.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
public class SequenceModel {
    // Attributes
    @Id
    private String id;
    private String label;
}
