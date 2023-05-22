package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "eleve")

public class EleveModel {
    @Id
    private String id;
    private String matricule;
    private String nom;
    private String prenom;
    private String date_naissance;
    private String lieu_naissance;
    private String sexe;
    private String nationalite;
    private String apte;
    private String nom_parent;
    private String contact_parent;
    private String email_parent;

//  @Migrations
    private Set<DossierModel> dossierEleve = new HashSet<>();

}
