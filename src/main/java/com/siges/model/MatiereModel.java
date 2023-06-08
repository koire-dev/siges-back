package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "matiere")
public class MatiereModel {
    @Id
    private String id;
    private String intitule;
//    private String code;
    private String groupe_matiere;

    @DBRef(lazy = true)
    private EnseignantModel enseignant;
    @DBRef
    private List<EleveModel> eleve;

    public MatiereModel(String id, String intitule, String groupe_matiere) {

        this.id = id;
        this.intitule = intitule;
        this.groupe_matiere = groupe_matiere;
    }
}
