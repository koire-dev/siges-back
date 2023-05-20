package com.siges.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "infos_etablissement")
public class InfoEtablissementModel {
    @Id
    private String id;
    private String nom;
    private String devise;
    private String logo;
    private String bp;
    private String mail;
    private String contact;
    private String reglement_interieur;
}
