package com.siges.controller;

import com.siges.model.EleveModel;
import com.siges.model.NotesModel;
import com.siges.repository.EleveRepository;
import com.siges.repository.NotesRepository;
import com.siges.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NotesController {

    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private EleveService eleveService;
    @Autowired
    private EleveRepository eleveRepository;

    @PostMapping("/addNotes")
    public ResponseEntity<NotesModel> saveNotes(@RequestBody NotesModel notesModel){
        if (notesModel == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Double valeur = notesModel.getValeur();
        String appreciation = notesModel.getAppreciationByValeur(valeur);
        notesModel.setAppreciation(appreciation);
        NotesModel createdNotes = notesRepository.save(notesModel);

        EleveModel eleveModel = notesModel.getEleveModel();
        EleveModel eleve = eleveRepository.findById(eleveModel.getId()).orElse(new EleveModel(
                eleveModel.getId(),
                eleveModel.getNom(),
                eleveModel.getPrenom(),
                eleveModel.getMatricule(),
                eleveModel.getDate_naiss(),
                eleveModel.getLieu_naiss(),
                eleveModel.getNationalite(),
                eleveModel.getSexe(),
                eleveModel.getRedoublant(),
                eleveModel.getApte(),
                eleveModel.getOption(),
                eleveModel.getNom_parent(),
                eleveModel.getTel_parent(),
                eleveModel.getEmail_parent(),
                eleveModel.getNotes()
        ));
        List<NotesModel> notesModelList = new ArrayList<>();
        notesModelList.add(createdNotes);

        if (eleve.getNotes() != null){
            for (NotesModel notes : eleve.getNotes()){
                notesModelList.add(notes);
            }
        }
        notesModelList.add(createdNotes);
        eleve.setNotes(notesModelList);
        eleveService.updateEleve(eleve.getId(), eleve);

        return new ResponseEntity<>(createdNotes, HttpStatus.OK);
    }

    //Pas necessaire en pratique
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

        Double valeur = notesModel.getValeur();

        notes.setSequence(notesModel.getSequence());
        notes.setTrimestre(notesModel.getTrimestre());
        notes.setValeur(valeur);
        String appreciation = notesModel.getAppreciationByValeur(valeur);
        notes.setAppreciation(appreciation);

        NotesModel updateNotes = notesRepository.save(notes);

        EleveModel eleveModel = updateNotes.getEleveModel();
        EleveModel eleve = eleveRepository.findById(eleveModel.getId()).orElse(new EleveModel(
                eleveModel.getId(),
                eleveModel.getNom(),
                eleveModel.getPrenom(),
                eleveModel.getMatricule(),
                eleveModel.getDate_naiss(),
                eleveModel.getLieu_naiss(),
                eleveModel.getNationalite(),
                eleveModel.getSexe(),
                eleveModel.getRedoublant(),
                eleveModel.getApte(),
                eleveModel.getOption(),
                eleveModel.getNom_parent(),
                eleveModel.getTel_parent(),
                eleveModel.getEmail_parent(),
                eleveModel.getNotes()
        ));
        List<NotesModel> notesModelList = new ArrayList<>();
        notesModelList.add(updateNotes);

        for (NotesModel note : eleve.getNotes()){
            for (NotesModel not : notesModelList){
                if (note != not){
                    notesModelList.add(note);
                }
            }
        }
        eleve.setNotes(notesModelList);
        eleveService.updateEleve(eleve.getId(), eleve);
        return new ResponseEntity<>(updateNotes, HttpStatus.OK);
    }

    @DeleteMapping("/deleteNotes/{id}")
    public String deleteNotes(@PathVariable String id){
        notesRepository.deleteById(id);
        return "Deleted Successfully";
    }
}