package com.web.springbootangular.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Dishes", schema = "goodmeal")
public class Dish {

    public static final String DEFAULT_NAME = "No dish type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @OneToMany(mappedBy = "dish")
    private Set<Recipe> recipes = new HashSet<>();

    public Dish(String type) {
        this.type = type;
    }

    public Dish() {};
}
