package com.siges.repository;

import com.siges.model.TypeSanctionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeSanctionRepository extends MongoRepository<TypeSanctionModel, String> {
}
