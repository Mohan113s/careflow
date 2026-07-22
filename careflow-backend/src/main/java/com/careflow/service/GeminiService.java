package com.careflow.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Value("${openrouter.api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    public String askGemini(String message) {

        String url = "https://openrouter.ai/api/v1/chat/completions";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.setBearerAuth(apiKey);

        headers.set("HTTP-Referer", "http://localhost:8081");
        headers.set("X-Title", "CareFlow");

        Map<String, Object> body = Map.of(
                "model", "meta-llama/llama-3.1-8b-instruct",
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", message
                        )
                )
        );

        HttpEntity<Map<String, Object>> entity =
                new HttpEntity<>(body, headers);

        try {

            ResponseEntity<Map> response =
                    restTemplate.exchange(url, HttpMethod.POST, entity, Map.class);

            Map choice =
                    (Map) ((List<?>) response.getBody().get("choices")).get(0);

            Map msg = (Map) choice.get("message");

            return msg.get("content").toString();

        } catch (Exception e) {

            e.printStackTrace();

            return e.getMessage();
        }
    }
}