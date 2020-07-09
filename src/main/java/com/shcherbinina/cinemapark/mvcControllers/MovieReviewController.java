package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieReviewController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public String getMovie(@PathVariable String id, Model model) {
        MovieDTO movie = movieService.getMovieBySecondaryKey(id);
        model.addAttribute("movie", movie);
        return "movie";
    }
}
