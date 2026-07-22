package com.careflow.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careflow.entity.ChatMessage;
import com.careflow.repository.ChatRepository;
import com.careflow.service.ChatService;

@Service
public class ChatServiceImplementation implements ChatService  {
@Autowired
private ChatRepository repo;
@Override
public ChatMessage saveChat(ChatMessage chatMessage) {
    String userMessage =chatMessage.getMessage().toLowerCase();
    if (userMessage.contains("order")) {
        chatMessage.setReply("Your order is on the way and will arrive tomorrow.");
    }
    else if (userMessage.contains("refund")) {
        chatMessage.setReply("Your refund request has been submitted successfully.");
    }
    else if (userMessage.contains("payment")) {
        chatMessage.setReply( "Please verify your payment method and try again.");

    }
    else if (userMessage.contains("hello")) {
        chatMessage.setReply("Hello! How can I assist you today?");
    }

    else {

        chatMessage.setReply( "Thank you for contacting CareFlow. A support agent will assist you if needed.");

    }
    return repo.save(chatMessage);
}
@Override
public List<ChatMessage> getAllChats() {
    return repo.findAll();

}
}
