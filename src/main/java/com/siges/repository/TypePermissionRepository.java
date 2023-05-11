package com.siges.repository;

import com.siges.model.TypePermissionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypePermissionRepository extends MongoRepository<TypePermissionModel, String> {
}
