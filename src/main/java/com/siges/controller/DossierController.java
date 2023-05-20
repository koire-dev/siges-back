package com.siges.controller;


import com.siges.model.DossierModel;
import com.siges.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DossierController {

    @Autowired(required = false)
    private DossierRepository dossierRepository;

    @PostMapping("/addFolder")
    public String saveDossier(@RequestBody DossierModel dossier){
        dossierRepository.save(dossier);
        return "Added Successfully";
    }

    @GetMapping("/findAllFolders")
    public List<DossierModel> getAllDossiers() {
        return dossierRepository.findAll();
    }

    @DeleteMapping("/deleteFolder/{id}")
    public String deleteDossier(@PathVariable String id){
        dossierRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
