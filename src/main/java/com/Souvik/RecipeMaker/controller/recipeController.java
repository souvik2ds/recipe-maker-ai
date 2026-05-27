package com.Souvik.RecipeMaker.controller;

import com.Souvik.RecipeMaker.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class recipeController {
    @Autowired
    private RecipeService service;
    @GetMapping("/hi")
    public String greet()
    {
        return "hi";
    }
    @GetMapping("/ask")
    public String getResponse(@RequestParam String ingredients,
                              @RequestParam(defaultValue = "indian") String cuisine,
                              @RequestParam(defaultValue = "no specific diet") String dietPlan)
    {
        return service.getResponse(ingredients,cuisine,dietPlan);
    }
}
