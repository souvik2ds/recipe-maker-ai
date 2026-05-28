package com.Souvik.RecipeMaker.dto;

import java.util.List;

public class RecipeResponse {
    private String dishName;
    private List<String> ingredients;
    private List<String> steps;

    public String getDishName() {
        return dishName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
