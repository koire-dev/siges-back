package com.siges.controller;

import com.siges.model.TypeSanctionModel;
import com.siges.repository.TypeSanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeSanctionController {

    @Autowired(required = false)
    private TypeSanctionRepository typeSanctionRepository;

    @GetMapping("/homeTypeSanction")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addTypeSanction")
    public String saveTypeSanction(@RequestBody TypeSanctionModel typeSanction){
        typeSanctionRepository.save(typeSanction);
        return "Added Successfully";
    }

    @GetMapping("/findAllTypeSanction")
    public List<TypeSanctionModel> getTypeSanctions() {
        return typeSanctionRepository.findAll();
    }

    @DeleteMapping("/deleteTypeSanction/{id}")
    public String deleteTypeSanction(@PathVariable String id){
        typeSanctionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
