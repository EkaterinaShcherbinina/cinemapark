package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import com.shcherbinina.cinemapark.validation.payloadValidation.MovieDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin-movie")
public class AdminMovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieDTOValidator movieValidator;

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<MovieDTO> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "adminMovies";
    }

    @GetMapping("/edit{id}")
    public String editMovie(@PathVariable("id") int id, Model model) {
        MovieDTO movieDTO = movieService.getMovieById(id);
        model.addAttribute("movie", movieDTO);
        return "movieAdminTemplate";
    }

    @PostMapping("/edit")
    public String postEditMovie(@ModelAttribute("movie") @Validated(MovieDTO.Update.class) MovieDTO movieDTO,
                                BindingResult bindingResult) {
        movieValidator.validate(movieDTO, bindingResult);
        if(bindingResult.hasErrors()) {
            return "/movieAdminTemplate";
        }

        movieService.updateMovie(movieDTO);
        return "redirect:/admin";
    }

    @GetMapping()
    public String newMovie(Model model) {
        model.addAttribute("movie", new MovieDTO());
        return "movieAdminTemplate";
    }

    @PostMapping()
    public String postNewMovie(@ModelAttribute("movie") @Validated(MovieDTO.New.class) MovieDTO movieDTO,
                               BindingResult bindingResult) {
        movieValidator.validate(movieDTO, bindingResult);
        if(bindingResult.hasErrors()) return "/movieAdminTemplate";
        movieService.addNewMovie(movieDTO);
        return "redirect:/admin";
    }
}
