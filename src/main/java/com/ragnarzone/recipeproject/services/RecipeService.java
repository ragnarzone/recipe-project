package com.ragnarzone.recipeproject.services;

import com.ragnarzone.recipeproject.commands.RecipeCommand;
import com.ragnarzone.recipeproject.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
