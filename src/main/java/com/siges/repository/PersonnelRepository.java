package com.siges.repository;

import com.siges.model.PersonnelModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonnelRepository extends MongoRepository<PersonnelModel, String> {
}
