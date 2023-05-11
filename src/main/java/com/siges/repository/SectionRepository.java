package com.siges.repository;

import com.siges.model.SectionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectionRepository extends MongoRepository<SectionModel, String> {
}
