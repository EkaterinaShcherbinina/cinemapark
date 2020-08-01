package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;
import com.shcherbinina.cinemapark.dto.entity.UserInfo;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/cinemapark")
public class CinemaparkController {
    @Autowired
    MovieService movieService;
    @Autowired
    private AccountService accountService;

    @RequestMapping(method= RequestMethod.GET)
    public String getCinemaparkPage(Model model) {
        List<MovieThumbnailDTO> movies = movieService.getMoviesNowInCinema();
        model.addAttribute("movies", movies);

        return "cinemapark";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String forwardCinemaparkPage(Model model) {
        return "redirect:/cinemapark";
    }

    @RequestMapping(value="/soon", method= RequestMethod.GET)
    public String getMoviesSoonPage(Model model) {
        List<MovieThumbnailDTO> movies = movieService.getMoviesSoonInCinema();
        model.addAttribute("movies", movies);
        return "moviesSoon";
    }
}
