package com.ragnarzone.recipeproject.services;

import com.ragnarzone.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}