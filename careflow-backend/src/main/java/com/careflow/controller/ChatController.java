package com.careflow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.careflow.dto.ChatRequest;
import com.careflow.dto.ChatResponse;
import com.careflow.entity.ChatMessage;
import com.careflow.repository.ChatRepository;
import com.careflow.service.GeminiService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private ChatRepository chatRepository;

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {

        // Get AI Reply
        String reply = geminiService.askGemini(request.getMessage());

        // Save Chat
        ChatMessage chat = new ChatMessage();
        chat.setMessage(request.getMessage());
        chat.setReply(reply);

        chatRepository.save(chat);

        return new ChatResponse(reply);
    }
}