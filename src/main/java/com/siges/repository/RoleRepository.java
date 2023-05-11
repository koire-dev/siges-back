package com.siges.repository;

import com.siges.model.RoleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<RoleModel, String> {
}
