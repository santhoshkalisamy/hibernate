package com.accolite.hibernateau.repository;

import com.accolite.hibernateau.entity.Movie;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void addMovie(Movie movie){
        entityManager.persist(movie);
    }

    public Movie getMovieById(int id){
        return entityManager.find(Movie.class, id);
    }

    public void deleteMovie(Movie movie){
        entityManager.remove(movie);
    }

    public Movie updateMovie(Movie movie){
        return entityManager.merge(movie);
    }

    public List<Movie> getMovieUsingQuery(int year, String language) {
        Query query =
                entityManager.createQuery("select m from movie m where m.releaseYear > :rel_year and m.lang = :language");
        query.setParameter("rel_year", year);
        query.setParameter("language", language);
        entityManager.createNativeQuery("select * from movie m where m.release_year > 0");
        return query.getResultList();

        //select * from movie m where m.release_year > 0;
    }

}
