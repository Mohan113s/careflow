package com.careflow.service;

import java.util.List;

import com.careflow.entity.ChatMessage;

public interface ChatService {
	ChatMessage saveChat(ChatMessage chatMessage);

    List<ChatMessage> getAllChats();
	 
}
