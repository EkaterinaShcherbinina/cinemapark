package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin-movie")
public class AdminMovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public String getMovies(Model model) {
        List<MovieDTO> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/edit{id}")
    public String editMovie(@PathVariable("id") int id, Model model) {
        MovieDTO movieDTO = movieService.getMovieById(id);
        model.addAttribute("movie", movieDTO);
        return "movieEdit";
    }

    @PostMapping("/edit")
    public String postEditMovie(@ModelAttribute MovieDTO movieDTO, @RequestParam("file") MultipartFile file,
                                BindingResult bindingResult, Model model) throws IOException, SQLException {
        //TODO: validation fields

        Blob blob = null;
        if (file != null) {
            blob = new SerialBlob(file.getBytes());
        }

        movieService.updateMovie(movieDTO, blob);
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newMovie(Model model) {
        model.addAttribute("movie", new MovieDTO());
        return "newMovie";
    }

    @PostMapping("/new")
    public String postNewMovie(@ModelAttribute MovieDTO movieDTO, @RequestParam("file") MultipartFile file,
                                BindingResult bindingResult, Model model) throws IOException, SQLException {
        //TODO: validation fields

        Blob blob = null;
        if (file != null) {
            blob = new SerialBlob(file.getBytes());
        }

        movieService.addNewMovie(movieDTO, blob);
        return "redirect:/admin";
    }
}
