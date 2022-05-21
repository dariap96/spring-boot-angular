package com.web.springbootangular.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;


@Entity
@Table(name = "Recipes", schema="goodmeal")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column(name = "time_")
    @NonNull
    private Integer time; //in minutes

    @Column
    @NonNull
    private String image;

    @Column
    @NonNull
    private String originalId;

    @Column(name = "actions_sequence")
    @NonNull
    private String actionsSequence;

//    @ManyToOne
//    private Cuisine cuisine;
//
//    @ManyToOne
//    private Meal meal;
//
//    @ManyToOne
//    private Dish dish;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "Labels_Recipes",
//            schema = "goodmeal",
//            joinColumns = @JoinColumn(name = "recipe_id"),
//            inverseJoinColumns = @JoinColumn(name = "label_id"))
//    private Set<HealthDietLabel> labelsSet;

//    @OneToMany(mappedBy = "recipe")
//    @NonNull
//    @ToString.Exclude
//    private Set<IngredientsToRecipes> ingredientsSet;

//
//    @OneToMany(mappedBy = "recipe")
//    private Set<RecipesRating> ratingSet;

    public Recipe() {}

    public Recipe(
            String name,
            Integer time,
            String image,
            String actionsSequence,
//            Cuisine cuisine,
//            Meal meal,
//            Dish dish,
            String originalId
           // Set<HealthDietLabel> labels
    ) {
        this.name = name;
        this.time = time;
        this.image = image;
        this.actionsSequence = actionsSequence;
//        this.cuisine = cuisine;
//        this.meal = meal;
//        this.dish = dish;
        this.originalId = originalId;
//        this.labelsSet = labels;
    }

//    public Recipe(String name, Integer time, String image, String actionsSequence, String originalId) {
//    }

//    public Double getRating(){
//        if(ratingSet.size() == 0){
//            return null;
//        }
//
//        return ratingSet.stream().collect(Collectors.averagingInt(RecipesRating::getRating));
//    }
}

