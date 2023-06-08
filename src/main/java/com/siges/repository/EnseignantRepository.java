package com.siges.repository;

import com.siges.model.EnseignantModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

public interface EnseignantRepository extends MongoRepository<EnseignantModel, String> {

    public EnseignantModel findEnseignantByNom(String nom);
}
