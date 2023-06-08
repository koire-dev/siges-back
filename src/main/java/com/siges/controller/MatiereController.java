package com.siges.controller;

import com.siges.model.EleveModel;
import com.siges.model.MatiereModel;
import com.siges.model.NotesModel;
import com.siges.repository.EleveRepository;
import com.siges.repository.MatiereRepository;
import com.siges.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatiereController {

    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private MatiereService matiereService;

    @PostMapping("/addMatiere")
    public ResponseEntity<MatiereModel> saveMatiere(@RequestBody MatiereModel matiereModel){
        if (matiereModel == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        MatiereModel createdMatiere = matiereRepository.save(matiereModel);
        return new ResponseEntity<>(createdMatiere, HttpStatus.OK);
    }

    @GetMapping("/findAllMatiere")
    public List<MatiereModel> getAllMatiere(){
        return matiereRepository.findAll();
    }

    //La liste des notes des eleves pour une matiere par sequence
    @GetMapping("/findNotesEleveByIdMatiere/{id}/{sequence}")
    public List<NotesModel> getNotesEleve(@PathVariable("id") String id, @PathVariable("sequence") Long sequence){
        return matiereService.getNotesEleve(id, sequence);
    }

    @GetMapping("/findMatiereBYId/{id}")
    public ResponseEntity<MatiereModel> getMatiereById(@PathVariable("id") String id){
        MatiereModel matiereModel = matiereRepository.findById(id).orElse(null);
        return new ResponseEntity<>(matiereModel, HttpStatus.OK);
    }

    @PutMapping("/updateMatiere/{id}")
    public ResponseEntity<MatiereModel> updateMatiere(@PathVariable(value = "id") String id, @RequestBody MatiereModel matiereModel){

        return new ResponseEntity<>(matiereService.updateMatiere(id, matiereModel), HttpStatus.OK);
    }

    @DeleteMapping("/deleteMatiere/{id}")
    public String deleteMatiere(@PathVariable String id){
        matiereRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
