package com.siges.repository;

import com.siges.model.PaiementModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaiementRepository extends MongoRepository<PaiementModel, String> {
}
