package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "salle")
public class SalleModel {
    // Attributes
    @Id
    private String id;
    @DBRef
    private UserModel prof_principal;
    private String nom_salle;
    private String code_salle;
}
