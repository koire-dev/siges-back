package com.siges.repository;
;
import com.siges.model.CycleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CycleRepository extends MongoRepository<CycleModel, String> {
}
