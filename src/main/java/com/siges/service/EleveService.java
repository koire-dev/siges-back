package com.siges.service;

import com.siges.model.EleveModel;
import com.siges.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EleveService {

    @Autowired
    private EleveRepository eleveRepository;

    public List<EleveModel> getEleveByNom(String nom){
        return eleveRepository.findEleveByNom(nom);
    }
}
