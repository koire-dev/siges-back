package com.siges.repository;

import com.siges.model.TypePaiementModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypePaiementRepository extends MongoRepository<TypePaiementModel, String> {
}
