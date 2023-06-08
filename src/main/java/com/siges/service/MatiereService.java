package com.siges.service;

import com.siges.model.EleveModel;
import com.siges.model.MatiereModel;
import com.siges.model.NotesModel;
import com.siges.repository.MatiereRepository;
import com.siges.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatiereService {

    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private NotesRepository notesRepository;

    public List<NotesModel> getNotesEleve(String id){

        MatiereModel matiereModel = matiereRepository.findById(id).orElse(null);
        List<NotesModel> notesModelList = new ArrayList<>();

        for (EleveModel eleveModel : matiereModel.getEleve()){
            for (NotesModel notesModel : eleveModel.getNotes()){
                if (notesModel.getMatiereModel().getId() == matiereModel.getId()){
                    notesModelList.add(notesModel);
                }
//                notesModelList.add(notesModel);
            }
        }
        return notesModelList;
    }

    public MatiereModel updateMatiere(String id, MatiereModel matiereModel){

        MatiereModel matiere = matiereRepository.findById(id).orElse(null);
        if (matiere == null)
        {
            return null;
        }

        List<EleveModel> eleveModelList = new ArrayList<>();
        for (EleveModel eleveModel : matiere.getEleve()){
            eleveModelList.add(eleveModel);
        }

        for (EleveModel eleveModel : matiereModel.getEleve()){
            eleveModelList.add(eleveModel);
        }
        matiere.setGroupe_matiere(matiereModel.getGroupe_matiere());
//        matiere.setCode(matiereModel.getCode());
        matiere.setEleve(eleveModelList);
        matiere.setIntitule(matiereModel.getIntitule());
        matiere.setEnseignant(matiereModel.getEnseignant());
        MatiereModel updateMatiere = matiereRepository.save(matiere);

        return updateMatiere;
    }
}
