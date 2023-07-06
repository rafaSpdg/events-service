package com.dolphinevents.eventservice.event;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService= eventService;
    }

    @GetMapping("/events")
    public List<Event> retrieveAllEvents() {
        return eventService.findAllEvents();
    }

    @GetMapping("/events/{id}")
    public EntityModel<Event> retrieveEvent(@PathVariable Integer id) throws EventNotFoundException {
        Event event = eventService.findById(id);

        if(event == null) {
            throw new EventNotFoundException("ID:" + id);
        }

        EntityModel<Event> entityModel = EntityModel.of(event);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllEvents());

        entityModel.add(link.withRel("all-events"));

        return entityModel;
    }

    @PostMapping("/events")
    public ResponseEntity<Event> createNewEvent(@Valid @RequestBody Event event) {

        Event savedEvent = eventService.saveEvent(event);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedEvent.getId())
        .toUri(); 

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/events/{eventId}")
    public void deleteEvent(@PathVariable Integer id) {

        eventService.deleteById(id);
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Integer id, @RequestBody Event event) throws EventNotFoundException {
        Event updateEvent = eventService.findById(id);

        if(event == null) {
            throw new EventNotFoundException("Event with id " + id + " not found.");
        }

        updateEvent.setDate(updateEvent.getDate());
        updateEvent.setEventType(updateEvent.getEventType());
        updateEvent.setLocation(updateEvent.getLocation());
        updateEvent.setName(updateEvent.getName());
        updateEvent.setPrice(updateEvent.getPrice());

        return ResponseEntity.ok(updateEvent);
    }
 } 


