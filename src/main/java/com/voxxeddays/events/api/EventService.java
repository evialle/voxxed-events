package com.voxxeddays.events.api;


import com.voxxeddays.events.beans.Events;
import com.voxxeddays.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.StringBufferInputStream;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/events",  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping
    public Events postEvent(@RequestBody  Events events) {

        return eventRepository.save(events);
    }

    @GetMapping
    public List<Events> listEvent() {
        return eventRepository.findAll();
    }

    @DeleteMapping
    public void deleteEvent(String id) {
        Events e = new Events();
        e.setId(id);
        eventRepository.delete(e);
    }

}


