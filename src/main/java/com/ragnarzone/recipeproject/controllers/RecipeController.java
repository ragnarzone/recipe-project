package com.ragnarzone.recipeproject.controllers;

import com.ragnarzone.recipeproject.services.RecipeService;

public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
}
