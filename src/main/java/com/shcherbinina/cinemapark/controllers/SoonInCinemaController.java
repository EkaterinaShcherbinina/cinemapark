package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dao.entity.Movie;
import com.shcherbinina.cinemapark.dao.repository.MovieRepository;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/soon-in-the-cinemapark")
public class SoonInCinemaController {
    @Autowired
    MovieService movieService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<MovieDTO> getMoviesSoon() {
        List<MovieDTO> movies = movieService.getMoviesSoonInCinema();
        return movies;
    }
}
