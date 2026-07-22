package com.careflow.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careflow.repository.ChatRepository;
import com.careflow.repository.TicketRepository;

@RestController
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ChatRepository chatRepository;

    @GetMapping("/dashboard")
    public Map<String,Object> dashboard(){

        Map<String,Object> data=new HashMap<>();

        data.put("totalTickets", ticketRepository.count());

        data.put("openTickets",
                ticketRepository.countByStatus("Open"));

        data.put("resolvedTickets",
                ticketRepository.countByStatus("Resolved"));

        data.put("totalChats",
                chatRepository.count());

        data.put("recentTickets",
                ticketRepository.findRecentTickets());

        return data;
    }

}