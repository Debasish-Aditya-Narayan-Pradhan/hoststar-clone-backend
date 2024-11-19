package com.deba.movieInfo.service;

import com.deba.movieInfo.Reposotory.AboutRepo;
import com.deba.movieInfo.entity.AboutMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AboutMovieService {
    @Autowired
    AboutRepo aboutRepo;

    public AboutMovie addAbout(AboutMovie aboutMovie)
    {
        return aboutRepo.save(aboutMovie);
    }

    public List<AboutMovie> getAll()
    {
        List<AboutMovie> abouts = new ArrayList<>();
        abouts = aboutRepo.findAll();

        return abouts;
    }


    public List<AboutMovie> getByTitle(String title)
    {
        List<AboutMovie> all = aboutRepo.findAll();
        List<AboutMovie> searchedTitle = new ArrayList<>();

        for(AboutMovie aboutMovie:all)
        {
            if(aboutMovie.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                searchedTitle.add(aboutMovie);
            }
        }

        return searchedTitle;
    }

    public AboutMovie updateAbout(AboutMovie aboutMovie,Integer id)
    {
        Optional<AboutMovie> op = aboutRepo.findById(id);
        if(op.isPresent())
        {
            AboutMovie movie = op.get();
            movie.setTitle(aboutMovie.getTitle());
            movie.setUsername(aboutMovie.getUsername());
            movie.setAbout(aboutMovie.getAbout());

            return aboutRepo.save(movie);
        }

        return null;
    }
    public AboutMovie getById(Integer id)
    {
        Optional<AboutMovie> movie = aboutRepo.findById(id);
        if(movie.isPresent())
        {
            return movie.get();
        }

        return null;
    }
}
