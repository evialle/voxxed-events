package com.voxxeddays.events.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Events {

    @Id
    public String id;

    public String key = UUID.randomUUID().toString();

    String name;

}
