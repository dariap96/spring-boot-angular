package com.web.springbootangular.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class IngredientsToRecipesKey implements Serializable {

    @Column
    private Long recipeId;

    @Column
    private Long ingredientId;

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, ingredientId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        IngredientsToRecipesKey that = (IngredientsToRecipesKey) o;
        return Objects.equals(recipeId, that.recipeId) &&
                Objects.equals(ingredientId, that.ingredientId);
    }

    public IngredientsToRecipesKey(Long ingredientId, Long recipeId) {
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
    }

    public IngredientsToRecipesKey() {}
}
