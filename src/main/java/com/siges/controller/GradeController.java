package com.siges.controller;

import com.siges.model.GradeModel;
import com.siges.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GradeController {
    @Autowired(required = false)
    private GradeRepository gradeRepository;

    @GetMapping("/homeGrade")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addGrade")
    public String saveGrade(@RequestBody GradeModel grade){
        gradeRepository.save(grade);
        return "Added Successfully";
    }

    @GetMapping("/findAllGrade")
    public List<GradeModel> getGrade() {
        return gradeRepository.findAll();
    }

    @DeleteMapping("/deleteGrade/{id}")
    public String deleteGrade(@PathVariable String id){
        gradeRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
