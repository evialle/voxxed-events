package com.voxxeddays.events.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Events {

    @Id
    public String id;

    String name;

}
