package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import com.shcherbinina.cinemapark.dto.services.MovieSessionService;
import com.shcherbinina.cinemapark.utility.Utility;
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
    @Autowired
    MovieSessionService sessionService;

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public String getMovie(@PathVariable String id, Model model) {
        MovieDTO movie = movieService.getMovieBySecondaryKey(id);
        List<MovieSessionDTO> sessions = sessionService.getSessionsByDateAndMovieName("today", movie.getId());
        model.addAttribute("movie", movie);
        model.addAttribute("sessions", sessions);
        model.addAttribute("userInfo", Utility.getCurrentUserName());
        return "movie";
    }
}
