package com.siges.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.result.UpdateResult;
import com.siges.model.EleveModel;
import com.siges.model.NotesModel;
import com.siges.repository.EleveRepository;
import com.siges.repository.MatiereRepository;
import com.siges.repository.NotesRepository;
import com.siges.service.EleveService;
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
    MongoClient mongo = MongoClients.create("mongodb://localhost:27017");
    private MongoOperations mongoOperations = new MongoTemplate(mongo, "sigesDB");

    @PostMapping("/addEleve")
    public ResponseEntity<EleveModel> saveEleve(@RequestBody EleveModel eleveModel){
        if (eleveModel == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        EleveModel createdEleve = eleveRepository.save(eleveModel);
        return new ResponseEntity<>(createdEleve, HttpStatus.OK);
    }

    @GetMapping("/findAllEleve")
    public List<EleveModel> getAllEleve(){
        return eleveRepository.findAll();
    }

//  Je n'arrive pas a ajouter une note a l'eleve
    @PutMapping("/updateEleve/{id}")
    public ResponseEntity<EleveModel> updateEleve(@PathVariable(value = "id") String id, @RequestBody EleveModel eleveModel){
        EleveModel eleve = eleveRepository.findById(id).orElse(null);
        if (eleve == null)
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        HashSet<NotesModel> notesModelList = new HashSet<>();

        for(NotesModel notesModel : eleveModel.getNotes()){

            NotesModel notes = notesRepository.findById(notesModel.getId()).orElse(null);
            notesModelList.add(new NotesModel(notes.getId(), notes.getAppreciation(),notes.getValeur(), notes.getSequence(), notes.getTrimestre()));
        }
        if (notesModelList.isEmpty())
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        Update update = new Update();
        update.set("nom", eleveModel.getNom());
        update.set("apte", eleveModel.getApte());
        update.set("date_naiss", eleveModel.getDate_naiss());
        update.set("email_parent", eleveModel.getEmail_parent());
        update.set("Lieu_naiss",eleveModel.getLieu_naiss());
        update.set("nationalite", eleveModel.getNationalite());
        update.set("nom_parent", eleveModel.getNom_parent());
        update.set("option", eleveModel.getOption());
        update.set("redoublant", eleveModel.getRedoublant());
        update.set("sexe", eleveModel.getSexe());
        update.set("tel_parent", eleveModel.getTel_parent());
        update.set("notes", notesModelList);
        update.set("dossier", eleveModel.getDossier());
        Query query = new Query(Criteria.where("_id").is(eleveModel.getId()));
        UpdateResult updateResult = mongoOperations.updateFirst(query, update, EleveModel.class);
        if (updateResult.getModifiedCount() == 1)
        {
            eleve = eleveRepository.findById(eleveModel.getId()).get();
            return new ResponseEntity<>(eleve, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
    public List<EleveModel> getByNom(@PathParam(value = "nom") String nom){
        return eleveService.getEleveByNom(nom);
    }

    @DeleteMapping("/deleteEleve/{id}")
    public String deleteEleve(@PathVariable String id){
        eleveRepository.deleteById(id);
        return "Deleted Successfully";
    }


}
