package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "personnel")
public class PersonnelModel {
    @Id
    private String id;
    private String nom_prenom;
    private String email;
    private String telephone;
    private String cni;
    private String image;

//    Role Model
    private RoleModel role;
    private CompteModel compte;
}
