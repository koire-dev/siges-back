package com.siges.repository;

import com.siges.model.AnneeModel;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AnneeRepository  extends MongoRepository<AnneeModel, String> {
}
