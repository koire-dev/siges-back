package com.siges.repository;

import com.siges.model.SanctionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SanctionRepository extends MongoRepository<SanctionModel, String> {
}
