package com.siges.repository;

import com.siges.model.GradeModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GradeRepository extends MongoRepository<GradeModel, String> {
}
