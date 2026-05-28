package com.Souvik.RecipeMaker.service;
import com.Souvik.RecipeMaker.dto.RecipeResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class RecipeService {
    private final ChatClient chatclient;

    public RecipeService(ChatClient chatclient) {
        this.chatclient = chatclient;
    }
    public RecipeResponse getResponse(String ingredients, String cuisine, String dietPlan)
    {

        //if i use chatclient then this is more professional.
        return chatclient
        .prompt()
        .system("""
                You are an expert chef.
                
                Create recipes based on user preferences.
                
                Return ONLY valid JSON.
                
                No markdown.
                No explanation.
                No extra words.
                
                Response format:
                
                {
                  "dishName": "string",
                  "ingredients": ["item1", "item2"],
                  "steps": ["step1", "step2"]
                }
                """)
        .user("""
                Ingredients: %s
                Cuisine: %s
                Diet Plan: %s
                """
                .formatted(ingredients, cuisine, dietPlan))
        .call()
                .entity(RecipeResponse.class);



        /*if i want to use chatmodel only then the professional style is :
        Prompt prompt = new Prompt(
        List.of(
                new SystemMessage("""
                        You are an expert chef.
                        Create a recipe based on the following user preferences

                        Follow these strict rules:
                        1. First provide the dish name.
                        2. Then provide all required ingredients.
                        3. Then provide detailed cooking steps with numbering.
                        4. Keep the response clean and well structured.
                        """),

                new UserMessage("""
                        Ingredients: %s
                        Cuisine: %s
                        Diet Plan: %s
                        """
                        .formatted(ingredients, cuisine, dietPlan))
        ));
ChatResponse response = chatmodel.call(prompt);
return response.getResult().getOutput().getText();
*/


/*if you want streming then use this with chatmodel
        return chatmodel
                .stream(prompt)
                .map(chatResponse ->
                        chatResponse
                                .getResult()
                                .getOutput()
                                .getText()
                );

 */
        /*if you want to use streming with chatclient use this
        .stream()
        .content(); instead of call().contect();
         */


    }
}
