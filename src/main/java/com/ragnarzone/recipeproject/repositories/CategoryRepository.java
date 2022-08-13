package com.ragnarzone.recipeproject.repositories;

import com.ragnarzone.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
