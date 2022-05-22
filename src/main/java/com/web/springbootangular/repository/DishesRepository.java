package com.web.springbootangular.repository;

import com.web.springbootangular.models.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DishesRepository extends JpaRepository<Dish, Long> {

    Dish getByType(String s);
}
