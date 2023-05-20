package com.siges.repository;

import com.siges.model.EventModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<EventModel, String> {
}
