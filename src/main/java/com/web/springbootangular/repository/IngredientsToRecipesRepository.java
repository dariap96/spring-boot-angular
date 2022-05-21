package com.web.springbootangular.repository;

import com.web.springbootangular.models.IngredientsToRecipes;
import com.web.springbootangular.models.IngredientsToRecipesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IngredientsToRecipesRepository extends JpaRepository<IngredientsToRecipes, IngredientsToRecipesKey> {
    IngredientsToRecipes getByRecipe_IdAndIngredient_Id(Long id, Long id1);
}
