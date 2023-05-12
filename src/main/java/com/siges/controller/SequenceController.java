package com.siges.controller;

import com.siges.model.SequenceModel;
import com.siges.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SequenceController {

    @Autowired(required = false)
    private SequenceRepository sequenceRepository;

    @GetMapping("/homeSequence")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addSequence")
    public String saveSequence(@RequestBody SequenceModel sequence){
        sequenceRepository.save(sequence);
        return "Added Successfully";
    }

    @GetMapping("/findAllSequence")
    public List<SequenceModel> getSequences() {
        return sequenceRepository.findAll();
    }

    @DeleteMapping("/deleteSequence/{id}")
    public String deleteSequence(@PathVariable String id){
        sequenceRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
