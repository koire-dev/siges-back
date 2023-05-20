package com.siges.repository;

import com.siges.model.DossierModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DossierRepository extends MongoRepository<DossierModel, String> {
}
