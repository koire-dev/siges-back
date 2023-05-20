package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "event")
public class EventModel {
    @Id
    private String id;
    private String nom_event;
    private String type_event;
    private String lieu_event;
    private String date_debut;
    private String date_fin;
}
