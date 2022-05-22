package com.web.springbootangular.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Cuisine", schema = "goodmeal")
public class Cuisine {

    public static final String DEFAULT_NAME = "No cuisine type";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String type;

    @OneToMany(mappedBy = "cuisine")
    private Set<Recipe> recipes;

    public Cuisine(String type) {
        this.type = type;
    }

    public Cuisine() {}
}
