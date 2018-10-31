package com.voxxeddays.events.repository;

import com.voxxeddays.events.beans.Events;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRepository extends MongoRepository<Events, String> {


}
