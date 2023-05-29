package com.siges.repository;

import com.siges.model.NotesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotesRepository extends MongoRepository<NotesModel, String> {
}
