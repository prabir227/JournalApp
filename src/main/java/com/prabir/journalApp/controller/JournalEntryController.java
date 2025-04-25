package com.prabir.journalApp.controller;
import com.prabir.journalApp.entity.JournalEntity;
import com.prabir.journalApp.service.JournalService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journals")
public class JournalEntryController {
    @Autowired
    JournalService journalService;

//    @GetMapping("/allEntries")

    @PostMapping("/createJournal")
    public Boolean journalEntry(@RequestBody JournalEntity entry){
        journalService.saveEntry(entry);
        return true;
    }

    @GetMapping("/getAllJournals")
    public List<JournalEntity> getAllJournals(){
        return journalService.findAll();
    }

    @GetMapping("/getJournalById/{id}")
    public JournalEntity getJournalById(@PathVariable ObjectId id){
        return journalService.findJournalById(id).orElse(null);
    }

    @DeleteMapping("/deleteJournal/{id}")
    public void deleteJournalById(@PathVariable ObjectId id){
        journalService.deleteJournalById(id);
    }

    @PutMapping("/updateJournal/{id}")
    public JournalEntity updateJournal(@PathVariable ObjectId id, @RequestBody JournalEntity entry){
        JournalEntity journal = journalService.findJournalById(id).orElse(null);
        if(journal != null){
            journal.setTitle(entry.getTitle()!=null && !entry.getTitle().equals("") ? entry.getTitle() : journal.getTitle());
            journal.setContent(entry.getContent()!=null && !entry.getContent().equals("") ? entry.getContent() : journal.getContent());
        }
        journalService.saveEntry(journal);
        return journal;
    }
}
