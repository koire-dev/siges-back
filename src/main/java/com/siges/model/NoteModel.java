package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "note")

public class NoteModel {
    @Id
    private String id;
    private String valeur;
    private String appreciation;
    private String heure_absence;

//    Migrations
    private SequenceModel sequence;
}
