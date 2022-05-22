package com.web.springbootangular.services.impl;

import com.web.springbootangular.models.Meal;
import com.web.springbootangular.repository.MealsRepository;
import com.web.springbootangular.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service("jpaMealsService")
public class MealsService implements IService<Meal> {

    private final MealsRepository mealsRepository;

    public MealsRepository getMealsRepository() {
        return mealsRepository;
    }

    @Autowired
    public MealsService(MealsRepository mealsRepository) {
        this.mealsRepository = mealsRepository;
    }

    @Override
    public Iterable<Meal> findAll() {
        return mealsRepository.findAll();
    }

    @Override
    public void create(Meal meal) {
        mealsRepository.save(meal);
    }

    @Override
    public Optional<Meal> findById(Long id) {
        return mealsRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return (mealsRepository.existsById(id));
    }
}
