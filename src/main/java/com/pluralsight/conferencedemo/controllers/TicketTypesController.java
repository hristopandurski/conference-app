package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.TicketType;
import com.pluralsight.conferencedemo.repositories.TicketTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticketTypes")
public class TicketTypesController {
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    @GetMapping
    public List<TicketType> list() { return ticketTypeRepository.findAll(); }
}