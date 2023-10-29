package com.chirag.journalApp.service;

import com.chirag.journalApp.entity.JournalEntry;
import com.chirag.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    // dependency injection
    @Autowired private JournalEntryRepository journalEntryRepository;

    public JournalEntry saveJournal(JournalEntry je){
        return journalEntryRepository.save(je);
    }

    public List<JournalEntry> getJournalList(){
        return  journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }

    public boolean deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
        return true;
    }

//    public void  update(JournalEntry je, ObjectId id){
//        journalEntryRepository.
//    }

}
