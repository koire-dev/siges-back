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
@Document(collection = "paiement")
public class PaiementModel {
    @Id
    private String id;
    private String motif;
    private String date_paiement;
    private String status;

    private List<TrancheModel> dossierTranche = new ArrayList<>();
}
