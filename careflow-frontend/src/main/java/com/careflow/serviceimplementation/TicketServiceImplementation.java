package com.careflow.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careflow.entity.Ticket;
import com.careflow.repository.TicketRepository;
import com.careflow.service.TicketService;

@Service
public class TicketServiceImplementation implements TicketService {

    @Autowired
    private TicketRepository repo;

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return repo.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return repo.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void deleteTicket(Long id) {
        repo.deleteById(id);
    }
}