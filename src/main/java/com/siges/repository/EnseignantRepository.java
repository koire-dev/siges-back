package com.siges.repository;

import com.siges.model.EnseignantModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnseignantRepository extends MongoRepository<EnseignantModel, String> {
}
