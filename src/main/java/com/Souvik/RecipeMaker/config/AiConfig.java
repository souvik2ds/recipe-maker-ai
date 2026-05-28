package com.Souvik.RecipeMaker.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {
    @Bean
    ChatClient chatclient(ChatClient.Builder builder)
    {
        return builder.build();
    }
}
