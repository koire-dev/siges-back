package com.siges.controller;

import com.siges.model.PermissionModel;
import com.siges.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PermissionController {
    @Autowired(required = false)
    private PermissionRepository permissionRepository;

    @PostMapping("/addPermission")
    public String savePermission(@RequestBody PermissionModel permission){
        permissionRepository.save(permission);
        return "Added Successfully";
    }

    @GetMapping("/findAllPermissions")
    public List<PermissionModel> getPermissions() {
        return permissionRepository.findAll();
    }

    @DeleteMapping("/deletePermission/{id}")
    public String deletePermission(@PathVariable String id){
        permissionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
