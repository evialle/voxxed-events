package com.voxxeddays.events.api;


import com.voxxeddays.events.beans.Events;
import com.voxxeddays.events.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.StringBufferInputStream;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/events",  consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    public Events postEvent(@RequestBody  Events events) {
        Events savedEvents = eventRepository.save(events);
        kafkaTemplate.send("events", UUID.randomUUID().toString(), savedEvents.toString());

        return savedEvents;
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


