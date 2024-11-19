package com.deba.movieInfo.controller;

import com.deba.movieInfo.entity.AboutMovie;
import com.deba.movieInfo.entity.Movie;
import com.deba.movieInfo.service.AboutMovieService;
import com.deba.movieInfo.service.MovieService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {
    @Autowired
    MovieService movieService;
    @Autowired
    AboutMovieService aboutMovieService;

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie)
    {
        return movieService.addMovie(movie);
    }

    @GetMapping("/get")
    public List<Movie> getAllMovies()
    {
        return movieService.getAll();
    }

    @GetMapping("/get/{movieName}")
    public List<Movie> getByName(@PathVariable("movieName") String movieName)
    {
        return movieService.getMovieByName(movieName);
    }

    @PutMapping("/update/{id}")
    public Movie updateMove(@PathVariable(name = "id") Integer id,@RequestBody Movie movie)
    {
        return movieService.updateMovie(id,movie);
    }

    @PostMapping("/about/add")
    public AboutMovie addAbout(@RequestBody AboutMovie aboutMovie)
    {
        return aboutMovieService.addAbout(aboutMovie);
    }

    @GetMapping("/about/get")
    public List<AboutMovie> getAll()
    {
        return aboutMovieService.getAll();
    }

    @GetMapping("/about/get/{title}")
    public List<AboutMovie> getByTitle(@PathVariable(name = "title") String title)
    {
        return aboutMovieService.getByTitle(title);
    }

    @GetMapping("/about/get/movie/{id}")
    public AboutMovie getById(@PathVariable(name = "id") Integer id)
    {
        return aboutMovieService.getById(id);
    }
    @PutMapping("/about/get/{id}")
    public AboutMovie updateAbout(@RequestBody AboutMovie aboutMovie,@PathVariable(name = "id") Integer id)
    {
        return aboutMovieService.updateAbout(aboutMovie,id);
    }


}
