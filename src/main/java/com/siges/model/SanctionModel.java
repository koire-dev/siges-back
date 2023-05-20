package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sanction")
public class SanctionModel {
    @Id
    private String id;
    private String motif;
    private String date_debut;
    private String date_fin;

//  @Migrations
    private TypeSanctionModel type_sanction;
}
