package com.siges.repository;

import com.siges.model.NotesModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NotesRepository extends MongoRepository<NotesModel, String> {

    public List<NotesModel> findNotesBySequence(Long sequence);
}
