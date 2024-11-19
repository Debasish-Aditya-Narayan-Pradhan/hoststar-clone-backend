package com.deba.movieInfo.service;

import ch.qos.logback.core.testUtil.MockInitialContext;
import com.deba.movieInfo.Reposotory.MovieRepo;
import com.deba.movieInfo.entity.AboutMovie;
import com.deba.movieInfo.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public Movie addMovie(Movie movie)
    {
        return movieRepo.save(movie);
    }

    public List<Movie> getAll()
    {
        return movieRepo.findAll();
    }

    public List<Movie> getMovieByName(String movieName)
    {
        List<Movie> movies = new ArrayList<>();
        List<Movie> allMovies = movieRepo.findAll();
        for(Movie movie:allMovies)
        {
            if(movie.getTitle().toLowerCase().contains(movieName.toLowerCase()))
            {
                movies.add(movie);
            }
        }

        return movies;
    }

    public Movie updateMovie(Integer id, Movie movie)
    {
        Optional<Movie> op = movieRepo.findById(id);
        if(op.isPresent())
        {
            Movie m = op.get();
            m.setCatagory(movie.getCatagory());
            m.setType(movie.getType());
            m.setUrl(movie.getUrl());
            m.setReleaseDate(movie.getReleaseDate());
            m.setTitle(movie.getTitle());

            return movieRepo.save(m);
        }

        return null;
    }


}
