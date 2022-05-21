package com.web.springbootangular.repository;

import com.web.springbootangular.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

@Component
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
//        Recipe getByOriginalId(String s);
       Recipe getRecipeById(Long id);
       Page<Recipe> findByNameContainingIgnoreCase(String name, Pageable paging);
}
