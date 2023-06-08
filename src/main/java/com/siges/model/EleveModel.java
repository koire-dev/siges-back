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
@Document(collection = "eleve")
public class EleveModel {

    @Id
    private String id;
    private String nom;
    private String prenom;
    private String matricule;
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
    private List<NotesModel> notes;
    @DBRef
    private SalleModel salle;

    public EleveModel(String id, String nom, String prenom, String matricule, String date_naiss, String lieu_naiss, String nationalite, String sexe, String redoublant, String apte, String option, String nom_parent, String tel_parent, String email_parent) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.date_naiss = date_naiss;
        this.lieu_naiss = lieu_naiss;
        this.nationalite = nationalite;
        this.sexe = sexe;
        this.redoublant = redoublant;
        this.apte = apte;
        this.option = option;
        this.nom_parent = nom_parent;
        this.tel_parent = tel_parent;
        this.email_parent = email_parent;
    }

    public EleveModel(String id, String nom, String prenom, String matricule, String date_naiss, String lieu_naiss, String nationalite, String sexe, String redoublant, String apte, String option, String nom_parent, String tel_parent, String email_parent, List<NotesModel> notes) {

        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.date_naiss = date_naiss;
        this.lieu_naiss = lieu_naiss;
        this.nationalite = nationalite;
        this.sexe = sexe;
        this.redoublant = redoublant;
        this.apte = apte;
        this.option = option;
        this.nom_parent = nom_parent;
        this.tel_parent = tel_parent;
        this.email_parent = email_parent;
        this.notes = notes;
    }
}
