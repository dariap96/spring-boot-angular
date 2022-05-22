package com.web.springbootangular.services.impl;

import com.web.springbootangular.models.Ingredient;
import com.web.springbootangular.repository.IngredientRepository;
import com.web.springbootangular.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class IngredientsService implements IService<Ingredient> {

    public IngredientRepository getIngredientsRepository() {
        return ingredientsRepository;
    }

    private final IngredientRepository ingredientsRepository;

    @Autowired
    public IngredientsService(IngredientRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return ingredientsRepository.findAll();
    }


    @Override
    public void create(Ingredient ingredient) {
           ingredientsRepository.save(ingredient);
    }

    @Override
    public Optional<Ingredient> findById(Long id) {
        return ingredientsRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return (ingredientsRepository.existsById(id));
    }

    public Ingredient getIngredientByName(String name) {
        return this.ingredientsRepository.getByName(name);
    }
}
