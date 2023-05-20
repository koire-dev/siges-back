package com.siges.repository;


import com.siges.model.NoteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<NoteModel, String> {
}
