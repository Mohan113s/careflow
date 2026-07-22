package com.careflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.careflow.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

    long countByStatus(String status);

    @Query(value = "SELECT * FROM ticket ORDER BY id DESC LIMIT 5", nativeQuery = true)
    java.util.List<Ticket> findRecentTickets();

}