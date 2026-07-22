package com.careflow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careflow.entity.Ticket;
import com.careflow.service.TicketService;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService service;

    @PostMapping
    public Ticket saveTicket(@RequestBody Ticket ticket) {
        return service.saveTicket(ticket);
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return service.getAllTickets();
    }

    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable Long id) {
        return service.getTicketById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTicket(@PathVariable Long id) {
        service.deleteTicket(id);
        return "Ticket Deleted Successfully";
    }
}