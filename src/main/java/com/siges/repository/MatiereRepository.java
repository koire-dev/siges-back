package com.siges.repository;

import com.siges.model.MatiereModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatiereRepository extends MongoRepository<MatiereModel, String> {
}
