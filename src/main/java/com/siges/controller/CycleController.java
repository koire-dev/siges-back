package com.siges.controller;


import com.siges.model.CycleModel;
import com.siges.repository.CycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CycleController {
    
    @Autowired(required = false)
    private CycleRepository cycleRepository;

    @GetMapping("/home")
    public String hello() {
        return "Hello World to SIGES APP!";
    }
    @PostMapping("/addCycle")
    public String saveCycle(@RequestBody CycleModel cycle){
        cycleRepository.save(cycle);
        return "Added Successfully";
    }

    @GetMapping("/findAllCycle")
    public List<CycleModel> getCycle() {
        return cycleRepository.findAll();
    }

    @DeleteMapping("/deleteCycle/{id}")
    public String deleteCycle(@PathVariable String id){
        cycleRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
