package com.web.springbootangular.repository;

import com.web.springbootangular.models.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface MealsRepository extends JpaRepository<Meal,Long> {

    Meal getByType(String s);
}
