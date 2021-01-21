package com.accolite.hibernateau.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String directorName;

    @Column
    private Double imdbRating;

    @Column
    private Integer releaseYear;

    @Column
    private String lang;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Certificate certificate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Artist> artists;

}
