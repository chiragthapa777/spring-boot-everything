package com.chirag.journalApp.controller;

import com.chirag.journalApp.entity.JournalEntry;
import com.chirag.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getJournalList();
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createJournal(@RequestBody JournalEntry body) {
        try{
            body.setDate(LocalDateTime.now());
            return new ResponseEntity<>(journalEntryService.saveJournal(body), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{journalId}")
    public ResponseEntity<JournalEntry> getJournalById(@PathVariable("journalId") ObjectId id) {
        Optional<JournalEntry> je = this.journalEntryService.findById(id);
        if(je.isPresent()){
            return new ResponseEntity<>(je.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{journalId}")
    public ResponseEntity<?> deleteJournalById(@PathVariable("journalId") ObjectId id) {
        journalEntryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{journalId}")
    public ResponseEntity<?> updateJournalById(@PathVariable("journalId") ObjectId id, @RequestBody JournalEntry je) {
        JournalEntry oldJournalEntry = journalEntryService.findById(id).orElse(null);
        if(oldJournalEntry != null){
            oldJournalEntry.setTitle(je.getTitle() != null && !je.getTitle().equals("") ? je.getTitle() : oldJournalEntry.getTitle());
            oldJournalEntry.setContent(je.getContent() != null && !je.getContent().equals("") ? je.getContent() : oldJournalEntry.getContent());
            journalEntryService.saveJournal(oldJournalEntry);
            return new ResponseEntity<>(oldJournalEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
