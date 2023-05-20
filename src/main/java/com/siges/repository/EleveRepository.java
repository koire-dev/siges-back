package com.siges.repository;

import com.siges.model.EleveModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EleveRepository extends MongoRepository<EleveModel, String> {
}
