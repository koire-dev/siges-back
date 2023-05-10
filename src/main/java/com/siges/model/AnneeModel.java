package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "annee")
public class AnneeModel {

//  Attributes
    @Id
    private String id;
    private String date_debut;
    private String date_fin;
    private String statut;



//    public AnneeModel() {
//    }
//
//    public AnneeModel(String date_debut, String date_fin, String statut) {
//        this.date_debut = date_debut;
//        this.date_fin = date_fin;
//        this.statut = statut;
//    }
//
//    public String getStatut() {
//        return statut;
//    }
//
//    public void setStatut(String statut) {
//        this.statut = statut;
//    }
//
//    public AnneeModel(String statut) {
//        this.statut = statut;
//    }
//
//    public AnneeModel(String date_debut, String date_fin) {
//        this.date_debut = date_debut;
//        this.date_fin = date_fin;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getDate_debut() {
//        return date_debut;
//    }
//
//    public void setDate_debut(String date_debut) {
//        this.date_debut = date_debut;
//    }
//
//    public String getDate_fin() {
//        return date_fin;
//    }
//
//    public void setDate_fin(String date_fin) {
//        this.date_fin = date_fin;
//    }
//
//    @Override
//    public String toString() {
//        return "AnneeModel{" +
//                "id='" + id + '\'' +
//                ", date_debut='" + date_debut + '\'' +
//                ", date_fin='" + date_fin + '\'' +
//                ", statut='" + statut + '\'' +
//                '}';
//    }
}
