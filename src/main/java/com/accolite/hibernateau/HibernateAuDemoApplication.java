package com.accolite.hibernateau;

import com.accolite.hibernateau.entity.Artist;
import com.accolite.hibernateau.entity.Certificate;
import com.accolite.hibernateau.entity.Movie;
import com.accolite.hibernateau.repository.MovieJPARepository;
import com.accolite.hibernateau.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@Transactional
public class HibernateAuDemoApplication implements CommandLineRunner {

    @Resource
    MovieRepository movieRepository;

    @Autowired
    MovieJPARepository movieJPARepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateAuDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Certificate certificate = new Certificate();
        certificate.setDescription("UA");
        certificate.setIssuedDate(new Date(System.currentTimeMillis()));

        Artist artist = new Artist();
        artist.setAge(25);
        artist.setName("Dhanush");

        Artist artist2 = new Artist();
        artist2.setAge(30);
        artist2.setName("Vivek");

        Set<Artist> artistSet = new HashSet<>();
        artistSet.add(artist);
        artistSet.add(artist2);

        Movie movie = new Movie();
        movie.setArtists(artistSet);
        movie.setName("Dark");
        movie.setDirectorName("XYZ");
        movie.setLang("en");
        movie.setCertificate(certificate);

        //Save/Add
        movieJPARepository.save(movie);

        //
        movieJPARepository.delete(movie);

        //movieRepository.addMovie(movie);


        //Movie fromDb = movieRepository.getMovieById(1);

        //System.out.println(fromDb);

        //Ehcache manager - Caching
    }
}
