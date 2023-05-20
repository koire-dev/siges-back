package com.siges.repository;

import com.siges.model.TrancheModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrancheRepository extends MongoRepository<TrancheModel, String> {
}
