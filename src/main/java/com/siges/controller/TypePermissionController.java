package com.siges.controller;

import com.siges.model.TypePermissionModel;
import com.siges.repository.TypePermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypePermissionController {

    @Autowired(required = false)
    private TypePermissionRepository typePermissionRepository;

    @GetMapping("/homeTypePermission")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addTypePermission")
    public String saveTypePermission(@RequestBody TypePermissionModel typePermission){
        typePermissionRepository.save(typePermission);
        return "Added Successfully";
    }

    @GetMapping("/findAllTypePermission")
    public List<TypePermissionModel> getTypePermissions() {
        return typePermissionRepository.findAll();
    }

    @DeleteMapping("/deleteTypePermission/{id}")
    public String deleteTypePermission(@PathVariable String id){
        typePermissionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
