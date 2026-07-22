package com.careflow.service;

import java.util.List;

import com.careflow.entity.Ticket;

public interface TicketService {
	Ticket saveTicket(Ticket ticket);
	List<Ticket> getAllTickets();
	Ticket getTicketById(Long id);
    void deleteTicket(Long id);

}
