package com.web.springbootangular.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="Ingredients", schema = "goodmeal")
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private Float energy;
    
    @Column
    private Float fat;
    
    @Column
    private Float protein;
    
    @Column
    private Float carbs;
    
    @Column
    private Float fiber;

    @Column
    private String image;

    @Column
    private String originalId;

    @OneToMany(mappedBy = "ingredient")
    private Set<IngredientsToRecipes> ingredientsSet;

//    @ManyToMany(mappedBy = "ingredientSet")
//    private Set<Selection> selectionSet;

    public Ingredient() {}

    public Ingredient(
            String name,
            Float energy,
            Float fat,
            Float protein,
            Float carbs,
            Float fiber,
            String image,
            String originalId
    ) {
        this.name = name;
        this.energy = energy;
        this.fat = fat;
        this.protein = protein;
        this.carbs = carbs;
        this.fiber = fiber;
        this.image = image;
        this.originalId = originalId;
    }
}
