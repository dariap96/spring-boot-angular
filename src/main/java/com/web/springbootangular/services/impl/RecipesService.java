package com.web.springbootangular.services.impl;

import com.web.springbootangular.DTOs.RecipeDTO;
import com.web.springbootangular.models.Recipe;
import com.web.springbootangular.repository.RecipeRepository;
import com.web.springbootangular.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Transactional
@Service
public class RecipesService implements IService<Recipe> {
    @Autowired
    private final RecipeRepository recipesRepository;

    public RecipeRepository getRecipesRepository() {
        return recipesRepository;
    }

    @Autowired
    public RecipesService(RecipeRepository recipesRepository) {
        this.recipesRepository = recipesRepository;
    }

    @Override
    public Iterable<Recipe> findAll() {
        return recipesRepository.findAll();
    }

    @Override
    public void create(Recipe recipe) {
        recipesRepository.save(recipe);
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return recipesRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return recipesRepository.existsById(id);
    }

    public Recipe getRecipeById(Long Id)  {
        return this.recipesRepository.getRecipeById(Id);
    }

}
