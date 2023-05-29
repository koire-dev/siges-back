package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dossier")
public class DossierModel {

    @Id
    private String id;
    @DBRef(lazy = true)
    private CycleModel cycle;
    @DBRef(lazy = true)
    private SectionModel section;
    @DBRef(lazy = true)
    private AnneeModel annee_aca;
    @DBRef(lazy = true)
    private SalleModel salle;
}
