package com.siges.controller;

import com.siges.model.RoleModel;
import com.siges.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired(required = false)
    private RoleRepository roleRepository;

    @GetMapping("/homeRole")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addRole")
    public String saveRole(@RequestBody RoleModel role){
        roleRepository.save(role);
        return "Added Successfully";
    }

    @GetMapping("/findAllRole")
    public List<RoleModel> getRoles() {
        return roleRepository.findAll();
    }

    @DeleteMapping("/deleteRole/{id}")
    public String deleteRole(@PathVariable String id){
        roleRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
