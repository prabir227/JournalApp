package com.prabir.journalApp.service;

import com.prabir.journalApp.entity.JournalEntity;
import com.prabir.journalApp.repository.JournalRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;

    public void saveEntry(JournalEntity journalEntity) {
        journalRepository.save(journalEntity);

    }

    public List<JournalEntity> findAll() {
        return journalRepository.findAll();
    }

    public Optional<JournalEntity> findJournalById(ObjectId id) {
        return journalRepository.findById(id);
    }

    public void deleteJournalById(ObjectId id) {
        journalRepository.deleteById(id);
    }

}
