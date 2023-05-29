package com.siges.controller;

import com.siges.model.EleveModel;
import com.siges.model.NotesModel;
import com.siges.repository.EleveRepository;
import com.siges.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;

    @PostMapping("/addNotes")
    public ResponseEntity<NotesModel> saveNotes(@RequestBody NotesModel notesModel){
        if (notesModel == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        NotesModel createdNotes = notesRepository.save(notesModel);
        return new ResponseEntity<>(createdNotes, HttpStatus.OK);
    }

    @GetMapping("/findAllNotes")
    public List<NotesModel> getAllNotes(){
        return notesRepository.findAll();
    }

    @PutMapping("/updateNotes/{id}")
    public ResponseEntity<NotesModel> updateNotes(@PathVariable(value = "id") String id, @RequestBody NotesModel notesModel){
        NotesModel notes = notesRepository.findById(id).orElse(null);
        if (notes == null)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        notes.setAppreciation(notesModel.getAppreciation());
        notes.setSequence(notesModel.getSequence());
        notes.setTrimestre(notesModel.getTrimestre());
        notes.setValeur(notesModel.getValeur());

        NotesModel updateNotes = notesRepository.save(notes);
        return new ResponseEntity<>(updateNotes, HttpStatus.OK);
    }

    @DeleteMapping("/deleteNotes/{id}")
    public String deleteNotes(@PathVariable String id){
        notesRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
