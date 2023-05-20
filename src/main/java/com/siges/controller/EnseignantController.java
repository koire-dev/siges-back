package com.siges.controller;

import com.siges.model.EnseignantModel;
import com.siges.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EnseignantController {
    @Autowired(required = false)
    private EnseignantRepository enseignantRepository;

    @PostMapping("/addTeacher")
    public String saveEnseignant(@RequestBody EnseignantModel enseignant){
        enseignantRepository.save(enseignant);
        return "Added Successfully";
    }

    @GetMapping("/findAllTeachers")
    public List<EnseignantModel> getAllEnseignants() {
        return enseignantRepository.findAll();
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public String deleteEnseignant(@PathVariable String id){
        enseignantRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
