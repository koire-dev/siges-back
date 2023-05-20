package com.siges.repository;

import com.siges.model.SerieModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SerieRepository extends MongoRepository<SerieModel, String> {
}
