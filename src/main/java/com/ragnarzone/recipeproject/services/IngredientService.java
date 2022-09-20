package com.ragnarzone.recipeproject.services;

import com.ragnarzone.recipeproject.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
