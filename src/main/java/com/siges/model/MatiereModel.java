package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "matiere")
public class MatiereModel {
    @Id
    private String id;
    private String intitule;
    private String code;
    private String nb_heure;
    private String coefficient;

//  @Migrations
    private GroupeMatiereModel groupe_matiere;

    private List<NoteModel> listOfNotes = new ArrayList<>();


}
