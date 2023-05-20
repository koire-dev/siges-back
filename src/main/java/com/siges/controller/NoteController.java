package com.siges.controller;

import com.siges.model.NoteModel;
import com.siges.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired(required = false)
    private NoteRepository noteRepository;

    @PostMapping("/addNote")
    public String saveNote(@RequestBody NoteModel note){
        noteRepository.save(note);
        return "Added Successfully";
    }

    @GetMapping("/findAllNotes")
    public List<NoteModel> getAllNotes() {
        return noteRepository.findAll();
    }

    @DeleteMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable String id){
        noteRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
