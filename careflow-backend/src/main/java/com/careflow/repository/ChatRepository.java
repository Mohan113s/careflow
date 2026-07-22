package com.careflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.careflow.entity.ChatMessage;

@Repository
public interface ChatRepository extends JpaRepository<ChatMessage, Long>{

}