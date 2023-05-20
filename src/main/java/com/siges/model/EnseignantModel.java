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
@Document(collection = "enseignant")
public class EnseignantModel {
    @Id
    private String id;
    private String matricule;
    private String nom_prenom;
    private String email;
    private String telephone;
    private String cni;
    private String image;

//  @Migrations
    private RoleModel role;
    private GradeModel grade;
    private CompteModel compte;
    
    private List<SalleModel> classOfTeacher = new ArrayList<>();
    private List<MatiereModel> matiereOfTeacher = new ArrayList<>();
    
}
