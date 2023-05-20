package com.siges.controller;

import com.siges.model.InfoEtablissementModel;
import com.siges.repository.InfoEtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InfoEtablissementController {
    @Autowired(required = false)
    private InfoEtablissementRepository infoEtablissementRepository;

    @PostMapping("/addInfoEstablishment")
    public String saveInfoEtablissement(@RequestBody InfoEtablissementModel infoEtablissement){
        infoEtablissementRepository.save(infoEtablissement);
        return "Added Successfully";
    }

    @GetMapping("/findAllInfoEstablishment")
    public List<InfoEtablissementModel> getAllInfoEtablissements() {
        return infoEtablissementRepository.findAll();
    }

    @DeleteMapping("/deleteInfoEstablishment/{id}")
    public String deleteInfoEtablissement(@PathVariable String id){
        infoEtablissementRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
