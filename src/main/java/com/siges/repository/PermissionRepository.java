package com.siges.repository;

import com.siges.model.PermissionModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PermissionRepository extends MongoRepository<PermissionModel, String> {
}
