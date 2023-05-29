package com.siges.repository;

import com.siges.model.EleveModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EleveRepository extends MongoRepository<EleveModel, String> {

    public List<EleveModel> findEleveByNom(String nom);
}
