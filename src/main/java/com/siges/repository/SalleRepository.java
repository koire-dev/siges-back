package com.siges.repository;

import com.siges.model.SalleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalleRepository extends MongoRepository<SalleModel, String> {
}
