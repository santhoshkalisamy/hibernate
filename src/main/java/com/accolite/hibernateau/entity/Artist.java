package com.accolite.hibernateau.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name  = "age")
    private Integer age;

    @ManyToMany(mappedBy = "artists")
    Set<Movie> movies;

}
