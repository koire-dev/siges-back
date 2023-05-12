package com.siges.controller;

import com.siges.model.SectionModel;
import com.siges.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {

    @Autowired(required = false)
    private SectionRepository sectionRepository;

    @GetMapping("/homeSection")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addSection")
    public String saveSection(@RequestBody SectionModel section){
        sectionRepository.save(section);
        return "Added Successfully";
    }

    @GetMapping("/findAllSection")
    public List<SectionModel> getSections() {
        return sectionRepository.findAll();
    }

    @DeleteMapping("/deleteSection/{id}")
    public String deleteSection(@PathVariable String id){
        sectionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
