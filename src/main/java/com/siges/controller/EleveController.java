package com.siges.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.result.UpdateResult;
import com.siges.model.EleveModel;
import com.siges.model.NotesModel;
import com.siges.model.SalleModel;
import com.siges.repository.EleveRepository;
import com.siges.repository.MatiereRepository;
import com.siges.repository.NotesRepository;
import com.siges.repository.SalleRepository;
import com.siges.service.EleveService;
import com.siges.service.SalleService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EleveController {

    @Autowired
    private EleveRepository eleveRepository;
    @Autowired
    private NotesRepository notesRepository;
    @Autowired
    private EleveService eleveService;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private SalleService salleService;

    MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
    private MongoOperations mongoOperations = new MongoTemplate(mongo, "sigesDB");

    @PostMapping("/addEleve")
    public ResponseEntity<EleveModel> saveEleve(@RequestBody EleveModel eleveModel){
        if (eleveModel == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        EleveModel createdEleve = eleveRepository.save(eleveModel);
        SalleModel salleModel = eleveModel.getSalle();
        SalleModel sal = salleRepository.findById(salleModel.getId()).orElse(new SalleModel(
                salleModel.getId(),
                salleModel.getLabel()
        ));
        List<EleveModel> eleveModelList = new ArrayList<>();
        eleveModelList.add(eleveModel);
        for (EleveModel eleve : sal.getEleve()){
            eleveModelList.add(eleve);
        }
        sal.setEleve(eleveModelList);
        SalleModel salle = salleService.updateSalle(sal.getId(), sal);
        return new ResponseEntity<>(createdEleve, HttpStatus.OK);
    }

    @GetMapping("/findAllEleve")
    public List<EleveModel> getAllEleve(){
        return eleveRepository.findAll();
    }

    @PutMapping("/updateEleve/{id}")
    public ResponseEntity<EleveModel> updateEleve(@PathVariable(value = "id") String id, @RequestBody EleveModel eleveModel){

        return new ResponseEntity<>(eleveService.updateEleve(id, eleveModel), HttpStatus.OK);
    }

    @GetMapping("/findEleveById/{id}")
    public ResponseEntity<EleveModel> getEleveById(@PathVariable(value = "id") String id){
        EleveModel eleve = eleveRepository.findById(id).orElse(null);

        if(eleve == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(eleve, HttpStatus.OK);
    }

    @GetMapping("/findEleveByNom")
    public List<EleveModel> getByNom(@PathParam(value ="nom" ) String nom){
        return eleveService.getEleveByNom(nom);
    }

    @GetMapping("/findEleveByMatricule/{matricule}")
    public ResponseEntity<EleveModel> getEleveByMatriucle(@PathVariable("matricule") String matricule){
        return eleveService.getEleveByMatricule(matricule);
    }

    @DeleteMapping("/deleteEleve/{id}")
    public String deleteEleve(@PathVariable String id){

        EleveModel eleveModel = eleveRepository.findById(id).orElse(null);
        SalleModel salleModel = eleveModel.getSalle();
        for (EleveModel eleve : salleModel.getEleve()){
            if (id == eleve.getId()){
                salleModel.setEleve(null);
            }
        }
        eleveRepository.deleteById(id);

        return "Deleted Successfully";
    }


}
