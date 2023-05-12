package com.siges.controller;

import com.siges.model.GroupeMatiereModel;
import com.siges.repository.GroupeMatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupeMatiereController {
    @Autowired(required = false)
    private GroupeMatiereRepository groupeMatiereRepository;

    @GetMapping("/homeGroupeMatiere")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addGroupeMatiere")
    public String saveGroupeMatiere(@RequestBody GroupeMatiereModel groupeMatiere){
        groupeMatiereRepository.save(groupeMatiere);
        return "Added Successfully";
    }

    @GetMapping("/findAllGroupeMatiere")
    public List<GroupeMatiereModel> getGroupeMatiere() {
        return groupeMatiereRepository.findAll();
    }

    @DeleteMapping("/deleteGroupeMatiere/{id}")
    public String deleteGroupeMatiere(@PathVariable String id){
        groupeMatiereRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
