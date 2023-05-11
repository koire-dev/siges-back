package com.siges.controller;

import com.siges.model.AnneeModel;
import com.siges.repository.AnneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class AnneeController {

    @Autowired(required = false)
    private  AnneeRepository anneeRepository;

    @GetMapping("/home")
    public String hello() {
        return "Hello World to SIGES APP!";
    }
    @PostMapping("/addYear")
    public String saveCycle(@RequestBody AnneeModel annee){
        anneeRepository.save(annee);
        return "Added Successfully";
    }

    @GetMapping("/findAllYears")
    public List<AnneeModel> getYears() {
        return anneeRepository.findAll();
    }

    @DeleteMapping("/deleteYear/{id}")
    public String deleteYear(@PathVariable String id){
        anneeRepository.deleteById(id);
        return "Deleted Successfully";
    }






//    @GetMapping("/years")
//    public ResponseEntity<List<AnneeModel>> getAllYears(@RequestParam(required = false) String dateDebut) {
//        try {
//            List<AnneeModel> years = new ArrayList<AnneeModel>();
//
//            if (dateDebut == null)
//                anneeRepository.findAll().forEach(years::add);
//            if (years.isEmpty()) {
//                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//            }
//
//            return new ResponseEntity<>(years, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PostMapping("/years")
//    public ResponseEntity<AnneeModel> createYear(@RequestBody AnneeModel anneeModel) {
//        try {
//            AnneeModel _annee = anneeRepository.save(new AnneeModel(anneeModel.getDate_debut(), anneeModel.getDate_fin(), anneeModel.getStatut()));
//            return new ResponseEntity<>(_annee, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}
