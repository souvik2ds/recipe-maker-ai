package com.Souvik.RecipeMaker.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {
    private final ChatModel chatmodel;

    public RecipeService(ChatModel chatmodel) {
        this.chatmodel = chatmodel;
    }
    public String getResponse(String ingredients,String cuisine,String dietPlan)
    {
        String prompt = """
                You are an expert chef.
                Create a recipe based on the following user preferences:
                Ingredients: %s
                Cuisine: %s
                Diet Plan: %s
                Follow these strict rules:
                1. First provide the dish name.
                2. Then provide all required ingredients.
                3. Then provide detailed cooking steps with numbering.
                4. Keep the response clean and well structured.
                """
                .formatted(ingredients, cuisine, dietPlan);
        return chatmodel.call(prompt);
    }
}
