package com.siges.repository;

import com.siges.model.InfoEtablissementModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InfoEtablissementRepository extends MongoRepository<InfoEtablissementModel, String> {
}
