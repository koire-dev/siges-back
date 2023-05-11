package com.siges.repository;

import com.siges.model.SequenceModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SequenceRepository extends MongoRepository<SequenceModel, String> {
}
