package com.web.springbootangular.services.impl;

import com.web.springbootangular.models.IngredientsToRecipes;
import com.web.springbootangular.repository.IngredientsToRecipesRepository;
import com.web.springbootangular.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class IngredientsToRecipesService implements IService<IngredientsToRecipes> {

    private final IngredientsToRecipesRepository ingredientsToRecipesRepository;

    public IngredientsToRecipesRepository getIngredientsToRecipesRepository() {
        return ingredientsToRecipesRepository;
    }

    @Autowired
    public IngredientsToRecipesService(IngredientsToRecipesRepository ingredientsToRecipesRepository) {
        this.ingredientsToRecipesRepository = ingredientsToRecipesRepository;
    }

    @Override
    public Iterable<IngredientsToRecipes> findAll() {
        return ingredientsToRecipesRepository.findAll();
    }

    @Override
    public void create(IngredientsToRecipes ingredientsToRecipes) {
        ingredientsToRecipesRepository.save(ingredientsToRecipes);
    }

    @Override
    public Optional<IngredientsToRecipes> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
