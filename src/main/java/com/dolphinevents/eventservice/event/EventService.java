package com.dolphinevents.eventservice.event;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EventService {

    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Event findById(Integer id) throws EventNotFoundException {
         return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException("Could not find an event in the database."));
    }

    public void deleteById(Integer id) {
        eventRepository.deleteById(id);
    }

    public Event saveEvent(Event event) {
        eventRepository.save(event);
        return event;
    }
}
