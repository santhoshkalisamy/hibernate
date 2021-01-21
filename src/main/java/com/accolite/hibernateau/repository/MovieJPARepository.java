package com.accolite.hibernateau.repository;

import com.accolite.hibernateau.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieJPARepository extends CrudRepository<Movie, Integer> {

    public Movie findMovieByName(String name);

    // select * from movie where name = :name

    public Movie findMovieByReleaseYear(int year);

    public List<Movie> findMoviesByDirectorNameOrderByName(String name);

    //Spring Data JPA

}
