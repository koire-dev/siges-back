package com.siges.service;

import com.siges.model.SalleModel;
import com.siges.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SalleService {

    @Autowired
    private SalleRepository salleRepository;

    public SalleModel updateSalle(String id, SalleModel salleModel){
        SalleModel salle = salleRepository.findById(id).orElse(null);
        if (salle == null){
            return null;
        }

        salle.setLabel(salleModel.getLabel());
        salle.setEleve(salleModel.getEleve());
        SalleModel updateSalle = salleRepository.save(salle);
        return updateSalle;
    }
}
