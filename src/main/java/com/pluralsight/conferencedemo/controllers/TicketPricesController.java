package com.pluralsight.conferencedemo.controllers;

import com.pluralsight.conferencedemo.models.TicketPrice;
import com.pluralsight.conferencedemo.repositories.TicketPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticketPrices")
public class TicketPricesController {
    @Autowired
    private TicketPriceRepository ticketPriceRepository;

    @GetMapping
    public List<TicketPrice> list() { return ticketPriceRepository.findAll(); }
}
