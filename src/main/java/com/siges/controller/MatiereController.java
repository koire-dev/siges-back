package com.siges.controller;

import com.siges.model.MatiereModel;
import com.siges.repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatiereController {
    @Autowired(required = false)
    private MatiereRepository matiereRepository;

    @GetMapping("/homeMatiere")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addMatiere")
    public String saveMatiere(@RequestBody MatiereModel matiere){
        matiereRepository.save(matiere);
        return "Added Successfully";
    }

    @GetMapping("/findAllMatiere")
    public List<MatiereModel> getMatiere() {
        return matiereRepository.findAll();
    }

    @DeleteMapping("/deleteMatiere/{id}")
    public String deleteMatiere(@PathVariable String id){
        matiereRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
