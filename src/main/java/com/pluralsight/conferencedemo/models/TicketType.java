package com.pluralsight.conferencedemo.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ticket_types")
public class TicketType {
    @Id
    private String ticket_type_code;
    private String ticket_type_name;
    private String description;
    private Boolean includes_workshop;
}
