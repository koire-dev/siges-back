package com.siges.controller;

import com.siges.model.EventModel;
import com.siges.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {
    @Autowired(required = false)
    private EventRepository eventRepository;

    @PostMapping("/addEvent")
    public String saveEvent(@RequestBody EventModel event){
        eventRepository.save(event);
        return "Added Successfully";
    }

    @GetMapping("/findAllEvents")
    public List<EventModel> getAllEvents() {
        return eventRepository.findAll();
    }

    @DeleteMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable String id){
        eventRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
