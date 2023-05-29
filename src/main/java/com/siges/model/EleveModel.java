package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "eleve")
public class EleveModel {

    @Id
    private String id;
    private String nom;
    private String date_naiss;
    private String lieu_naiss;
    private String nationalite;
    private String sexe;
    private String redoublant;
    private String apte;
    private String option;
    private String nom_parent;
    private String tel_parent;
    private String email_parent;
    @DBRef(lazy = true)
    private DossierModel dossier;
    @DBRef(lazy = true)
    private Set<NotesModel> notes = new HashSet<>();
}
