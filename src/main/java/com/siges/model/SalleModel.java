package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "salle")
public class SalleModel {
    // Attributes
    @Id
    private String id;

    private String label;
    @DBRef(lazy = true)
    private List<EleveModel> eleve;
    @DBRef(lazy = true)
    private List<MatiereModel> matiere;

    public SalleModel(String label, String id) {
        this.id = id;
        this.label = label;
    }
}
