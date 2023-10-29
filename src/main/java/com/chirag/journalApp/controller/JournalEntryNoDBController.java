//package com.chirag.journalApp.controller;
//
//import com.chirag.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.*;
//
//@RestController
//@RequestMapping("/journalNoDb")
//public class JournalEntryNoDBController {
//
//    private Map<String, JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(@RequestParam("search") Optional<String> querySearch) {
//        String s = querySearch.orElse("");
//        System.out.println("=====>" + s);
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public void createJournal(@RequestBody JournalEntry body) {
//        journalEntries.put(body.getId(), body);
//    }
//
//    @GetMapping("{journalId}")
//    public JournalEntry getJournalById(@PathVariable("journalId") String id) {
//        return journalEntries.get(id);
//    }
//
//    @DeleteMapping("{journalId}")
//    public JournalEntry deleteJournalById(@PathVariable("journalId") String id) {
//        return journalEntries.remove(id);
//    }
//    @PutMapping("{journalId}")
//    public JournalEntry updateJournalById(@PathVariable("journalId") String id, @RequestBody JournalEntry je) {
//        return journalEntries.put(id, je);
//    }
//
//}
