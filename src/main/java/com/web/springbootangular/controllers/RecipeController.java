package com.web.springbootangular.controllers;

import com.web.springbootangular.DTOs.RecipeDTO;
import com.web.springbootangular.models.Recipe;
import com.web.springbootangular.repository.RecipeRepository;
import com.web.springbootangular.services.impl.RecipesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class RecipeController {
    private final RecipesService recipesService;
    @Autowired
    RecipeRepository recipeRepository;

//    @GetMapping(("/recipe"))
//    public ResponseEntity<Iterable<RecipeDTO>> getAllRecipes() {
//        Iterable<Recipe> recipes = this.recipesService.findAll();
//        List<RecipeDTO> recipesDTO = new ArrayList<>();
//        for (Recipe recipe: recipes) {
//            recipesDTO.add(new RecipeDTO(recipe));
//        }
//        return new ResponseEntity<>(recipesDTO, HttpStatus.OK);
//    }

    @GetMapping(value = "/recipe/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Recipe recipe = this.recipesService.getRecipeById(id);
        return new ResponseEntity<>(recipe, HttpStatus.OK);
    }

    @GetMapping("/recipe")
    public ResponseEntity<Map<String,Object>> getAllRecipes(@RequestParam(required = false) String name,
                                                            @RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "3") int size) {
        try {
            List<Recipe> recipes = new ArrayList<Recipe>();
            Pageable paging = PageRequest.of(page, size);
            Page<Recipe> pageRecipes;
            if (name == null)
                pageRecipes = recipeRepository.findAll(paging);
            else
                pageRecipes = recipeRepository.findByNameContainingIgnoreCase(name, paging);
            recipes = pageRecipes.getContent();
            Map<String, Object> response = new HashMap<>();
            response.put("recipes", recipes);
            response.put("currentPage", pageRecipes.getNumber());
            response.put("totalItems", pageRecipes.getTotalElements());
            response.put("totalPages", pageRecipes.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
