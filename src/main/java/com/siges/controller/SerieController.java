package com.siges.controller;

import com.siges.model.SerieModel;
import com.siges.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SerieController {
    @Autowired(required = false)
    private SerieRepository serieRepository;

    @PostMapping("/addSerie")
    public String saveSerie(@RequestBody SerieModel serie){
        serieRepository.save(serie);
        return "Added Successfully";
    }

    @GetMapping("/findAllSeries")
    public List<SerieModel> getAllSeries() {
        return serieRepository.findAll();
    }

    @DeleteMapping("/deleteSerie/{id}")
    public String deleteSerie(@PathVariable String id){
        serieRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
