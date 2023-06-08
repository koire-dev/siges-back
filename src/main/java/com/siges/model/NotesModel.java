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
@Document(collection = "notes")
public class NotesModel {

    @Id
    private String id;
    private String appreciation;
    private Double valeur;
    private Long sequence;
    private String trimestre;

    @DBRef
    private MatiereModel matiereModel;
    @DBRef
    private EleveModel eleveModel;

    public NotesModel(String id, String appreciation, Double valeur, Long sequence, String trimestre) {

        this.id = id;
        this.appreciation = appreciation;
        this.valeur = valeur;
        this.sequence = sequence;
        this.trimestre = trimestre;
    }

    public NotesModel(String id, String appreciation, Double valeur, Long sequence) {
        this.id = id;
        this.sequence = sequence;
        this.valeur = valeur;
        this.appreciation = appreciation;
    }

    public String getAppreciationByValeur(Double valeur){

        if (valeur < 10){
            return "Mediocre";
        }else if ((valeur >= 10) && (valeur <12)){
            return "Passable";
        }else if ((valeur >= 12) && (valeur < 14)){
            return "Assez-bien";
        }else if ((valeur >= 14) && (valeur < 16)){
            return "Bien";
        }else if ((valeur >= 16) && (valeur < 18)){
            return "Tres-bien";
        }else{
            return "Excellent";
        }
    }
}
