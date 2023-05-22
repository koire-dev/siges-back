package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dossier")
public class DossierModel {
    @Id
    private String id;
    private String nom_dossier;
    private String created_at;

//  @Migrations
    private AnneeModel annee;
    private SalleModel salle;

    private Set<MatiereModel> listOfMatiereNotes = new HashSet<>();
    private Set<PaiementModel> paiementFrais = new HashSet<>();
    private Set<SanctionModel> listOfSanctions = new HashSet<>();
    private Set<PermissionModel> listOfPermissions = new HashSet<>();


}
