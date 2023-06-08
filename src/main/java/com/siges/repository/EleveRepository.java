package com.siges.repository;

import com.siges.model.EleveModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EleveRepository extends MongoRepository<EleveModel, String> {

    public List<EleveModel> findEleveByNom(String nom);
    public ResponseEntity<EleveModel> findEleveByMatricule(String matriucle);
}
