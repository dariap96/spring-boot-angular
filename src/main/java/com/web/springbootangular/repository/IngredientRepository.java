package com.web.springbootangular.repository;

import com.web.springbootangular.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface IngredientRepository extends JpaRepository<Ingredient,Long> {
    Ingredient getByName(String s);
}
