package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TypeAlias("Tranche")
@Document(collection = "tranche")
public class TrancheModel {
    @Id
    private String id;
    private String label;
    private String montant;

    private TypePaiementModel type_paiement;

//    @DBRef(lazy = true)
//    private List<DossierModel> dossierTranche = new ArrayList<>();

}
