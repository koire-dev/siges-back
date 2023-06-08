package com.siges.service;

import com.siges.model.EleveModel;
import com.siges.model.NotesModel;
import com.siges.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EleveModel> getEleveByMatricule(String matricule){
        return eleveRepository.findEleveByMatricule(matricule);
    }

    public EleveModel updateEleve(String id, EleveModel eleveModel){

        EleveModel eleve = eleveRepository.findById(id).orElse(null);
        if (eleve == null)
        {
            return null;
        }

        eleve.setEmail_parent(eleveModel.getEmail_parent());
        eleve.setDate_naiss(eleveModel.getDate_naiss());
        eleve.setLieu_naiss(eleveModel.getLieu_naiss());
        eleve.setNationalite(eleveModel.getNationalite());
        eleve.setNom_parent(eleveModel.getNom_parent());
        eleve.setOption(eleveModel.getOption());
        eleve.setRedoublant(eleveModel.getRedoublant());
        eleve.setSexe(eleveModel.getSexe());
        eleve.setNom(eleveModel.getNom());
        eleve.setTel_parent(eleveModel.getTel_parent());
        eleve.setPrenom(eleveModel.getPrenom());
        eleve.setApte(eleveModel.getApte());
        eleve.setSalle(eleveModel.getSalle());
        eleve.setNotes(eleveModel.getNotes());

        EleveModel updateEleve = eleveRepository.save(eleve);
        return updateEleve;
    }
}
