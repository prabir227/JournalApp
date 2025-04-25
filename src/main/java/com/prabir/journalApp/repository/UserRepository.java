package com.prabir.journalApp.repository;

import com.prabir.journalApp.entity.JournalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<JournalEntity,String> {

}
