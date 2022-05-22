package com.web.springbootangular.repository;

import com.web.springbootangular.models.Cuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CuisinesRepository extends JpaRepository<Cuisine, Long> {

    Cuisine getByType(String s);
}
