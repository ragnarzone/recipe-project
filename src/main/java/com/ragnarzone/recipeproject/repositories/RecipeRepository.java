package com.ragnarzone.recipeproject.repositories;

import com.ragnarzone.recipeproject.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
