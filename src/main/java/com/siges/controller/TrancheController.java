package com.siges.controller;

import com.siges.model.TrancheModel;
import com.siges.repository.TrancheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrancheController {
    @Autowired(required = false)
    private TrancheRepository trancheRepository;

    @PostMapping("/addSlice")
    public String saveTranche(@RequestBody TrancheModel tranche){
        trancheRepository.save(tranche);
        return "Added Successfully";
    }

    @GetMapping("/findAllSlices")
    public List<TrancheModel> getAllTranches() {
        return trancheRepository.findAll();
    }

    @DeleteMapping("/deleteSlice/{id}")
    public String deleteTranche(@PathVariable String id){
        trancheRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
