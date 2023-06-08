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
@Document(collection ="enseignant")
public class EnseignantModel {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String grade;
    private String matricule;

    @DBRef
    private List<MatiereModel> matiere;
    @DBRef
    private List<SalleModel> salle;
}
