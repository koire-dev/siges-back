package com.siges.controller;

import com.siges.model.EnseignantModel;
import com.siges.model.MatiereModel;
import com.siges.model.SalleModel;
import com.siges.repository.EnseignantRepository;
import com.siges.repository.MatiereRepository;
import com.siges.repository.SalleRepository;
import com.siges.service.MatiereService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnseignantController {

    @Autowired
    private EnseignantRepository enseignantRepository;
    @Autowired
    private SalleRepository salleRepository;
    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private MatiereService matiereService;

    @PostMapping("/addEnseignant")
    public ResponseEntity<EnseignantModel> saveEnseignant(@RequestBody EnseignantModel enseignantModel){

        if (enseignantModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        EnseignantModel enseignant = enseignantRepository.save(enseignantModel);

        for (MatiereModel matiereModel : enseignant.getMatiere()){

            matiereModel.setEnseignant(enseignant);
            matiereService.updateMatiere(matiereModel.getId(), matiereModel);
        }

        return new ResponseEntity<>(enseignant, HttpStatus.OK);
    }

    @GetMapping("/findAllEnseignant")
    public List<EnseignantModel> getAllEnseignant(){
        return enseignantRepository.findAll();
    }

    @GetMapping("/findEnseignantById/{id}")
    public ResponseEntity<EnseignantModel> getEnseignantById(@PathVariable("id") String id){

        EnseignantModel enseignantModel = enseignantRepository.findById(id).orElse(null);
        if (enseignantModel == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(enseignantModel,HttpStatus.OK);
    }

    @GetMapping("/findEnseignantByNom")
    public ResponseEntity<EnseignantModel> getEnseignantByNom(@PathParam("nom") String nom){
        EnseignantModel enseignantModel = enseignantRepository.findEnseignantByNom(nom);
        return new ResponseEntity<>(enseignantModel,HttpStatus.OK);
    }

    //La liste des salles ou enseigne un enseignant
    @GetMapping("/findAllSalleFormEnseignant/{id}")
    public List<SalleModel> getAllSalleFormEnseignant(@PathVariable("id") String id){

        EnseignantModel enseignantModel = enseignantRepository.findById(id).orElse(null);
        if (enseignantModel == null){
            return null;
        }
        List<SalleModel> salleModelList = new ArrayList<>();
        for (SalleModel salleModel : enseignantModel.getSalle()){
            salleModelList.add(salleModel);
        }
        return salleModelList;
    }

    //La liste des matieres tenues par un enseignant dans une salle
    @GetMapping("/findAllMatiereFormEnseignant/{id}/Salle/{idSalle}")
    public List<MatiereModel> getAllMatiereFormEnseignant(@PathVariable("id") String id, @PathVariable("idSalle") String idSalle){

        EnseignantModel enseignantModel = enseignantRepository.findById(id).orElse(null);
        List<MatiereModel> matiereModelList = new ArrayList<>();

        for (SalleModel salleModel : enseignantModel.getSalle()){
            if (salleModel.getId() == idSalle){
                for (MatiereModel matiereModel : salleModel.getMatiere()){
                    for (MatiereModel matiere : enseignantModel.getMatiere()){
                        if (matiereModel.getId() == matiere.getId()){
                            matiereModelList.add(new MatiereModel(matiere.getId(), matiere.getIntitule(), matiere.getGroupe_matiere()));
                        }
                    }
                }
            }
        }
        return matiereModelList;
    }

    @PutMapping("/updateEnseignant/{id}")
    public ResponseEntity<EnseignantModel> updateEnseignant(@PathVariable("id") String id, @RequestBody EnseignantModel enseignantModel){

        EnseignantModel enseignant = enseignantRepository.findById(id).orElse(null);
        if (enseignant == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        List<SalleModel> salleModelList = enseignant.getSalle();
        for (SalleModel salleModel : enseignantModel.getSalle()){
            salleModelList.add(new SalleModel(
                    salleModel.getId(),
                    salleModel.getLabel(),
                    salleModel.getEleve(),
                    salleModel.getMatiere()
            ));
        }

        List<MatiereModel> matiereModelList = enseignant.getMatiere();
        for (MatiereModel matiereModel : enseignantModel.getMatiere()){
            matiereModelList.add(new MatiereModel(matiereModel.getId(), matiereModel.getIntitule(), matiereModel.getGroupe_matiere()));
        }

        enseignant.setSalle(salleModelList);
        enseignant.setMatiere(matiereModelList);
        enseignant.setGrade(enseignantModel.getGrade());
        enseignant.setMatricule(enseignantModel.getMatricule());
        enseignant.setNom(enseignantModel.getNom());
        enseignant.setPrenom(enseignantModel.getPrenom());

        EnseignantModel updateEnseignant = enseignantRepository.save(enseignant);
        for (MatiereModel matiereModel : updateEnseignant.getMatiere()){
            MatiereModel matiere = matiereRepository.findById(matiereModel.getId()).orElse(new MatiereModel(
                    matiereModel.getId(),
                    matiereModel.getIntitule(),
                    matiereModel.getGroupe_matiere(),
                    matiereModel.getEnseignant(),
                    matiereModel.getEleve()
            ));
            matiere.setEnseignant(updateEnseignant);
            matiereService.updateMatiere(matiere.getId(), matiere);
        }
        return new ResponseEntity<>(updateEnseignant, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEnseignantById/{id}")
    public String deleteEnseignantById(@PathVariable("id") String id){
        enseignantRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
