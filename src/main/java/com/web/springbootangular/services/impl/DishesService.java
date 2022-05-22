package com.web.springbootangular.services.impl;

import com.web.springbootangular.models.Dish;
import com.web.springbootangular.repository.DishesRepository;
import com.web.springbootangular.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class DishesService implements IService<Dish> {

    private final DishesRepository dishesRepository;

    public DishesRepository getDishesRepository() {
        return dishesRepository;
    }

    @Autowired
    public DishesService(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    @Override
    public Iterable<Dish> findAll() {
        return dishesRepository.findAll();
    }

    @Override
    public void create(Dish dish) {
        dishesRepository.save(dish);
    }

    @Override
    public Optional<Dish> findById(Long id) {
        return dishesRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return (dishesRepository.existsById(id));
    }
}
