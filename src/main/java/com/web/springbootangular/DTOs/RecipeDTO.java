package com.web.springbootangular.DTOs;

import com.web.springbootangular.models.HealthDietLabel;
import com.web.springbootangular.models.IngredientsToRecipes;
import com.web.springbootangular.models.Recipe;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RecipeDTO {
    private String name;
    private Integer time;
    private String image;
    private String actionsSequence;
    private String originalId;
    private Set<String> ingredients = new HashSet<>();
   // private Set<Set<Float>>ingredientsNut;
    private String cuisine;
    private String meal;
    private String dish;

    public RecipeDTO(String name, Integer time, String image, String actionsSequence, String originalId, Set<String> ingredients,
                     String cuisine, String meal, String dish) {
        this.name = name;
        this.time = time;
        this.image = image;
        this.actionsSequence = actionsSequence;
        this.originalId = originalId;
        this.ingredients = ingredients;
        this.cuisine = cuisine;
        this.meal = meal;
        this.dish = dish;
    }
    public RecipeDTO(Recipe recipe) {
        this.name = recipe.getName();
        this.time = recipe.getTime();
        this.image = recipe.getImage();
        this.actionsSequence = recipe.getActionsSequence();
        this.originalId = recipe.getOriginalId();
        for (IngredientsToRecipes ingredient: recipe.getIngredientsSet()) {
            this.ingredients.add(ingredient.getIngredient().getName());
        }
        this.cuisine = recipe.getCuisine().getType();
        this.meal = recipe.getMeal().getType();
        this.dish = recipe.getDish().getType();

    }
}
