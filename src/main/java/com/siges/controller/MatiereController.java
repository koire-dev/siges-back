package com.siges.controller;

import com.siges.model.EleveModel;
import com.siges.model.MatiereModel;
import com.siges.repository.EleveRepository;
import com.siges.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatiereController {

    @Autowired
    private MatiereRepository matiereRepository;

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

    @PutMapping("/updateMatiere/{id}")
    public ResponseEntity<MatiereModel> updateMatiere(@PathVariable(value = "id") String id, @RequestBody MatiereModel matiereModel){
        MatiereModel matiere = matiereRepository.findById(id).orElse(null);
        if (matiere == null)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        matiere.setGroupe_matiere(matiereModel.getGroupe_matiere());
        matiere.setCode(matiereModel.getCode());
        matiere.setEleve(matiereModel.getEleve());
        matiere.setGrade_enseignant(matiereModel.getGrade_enseignant());
        matiere.setIntitule(matiereModel.getIntitule());
        matiere.setNom_enseignant(matiereModel.getNom_enseignant());
        matiere.setRole_enseignant(matiereModel.getRole_enseignant());

        MatiereModel updateMatiere = matiereRepository.save(matiere);
        return new ResponseEntity<>(updateMatiere, HttpStatus.OK);
    }

    @DeleteMapping("/deleteMatiere/{id}")
    public String deleteMatiere(@PathVariable String id){
        matiereRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
