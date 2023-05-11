package com.siges.repository;

import com.siges.model.GroupeMatiereModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupeMatiereRepository extends MongoRepository<GroupeMatiereModel, String> {
}
