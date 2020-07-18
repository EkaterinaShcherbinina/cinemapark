package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dao.repository.MovieImageRepository;
import com.shcherbinina.cinemapark.dto.entity.MovieImageDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieThumbnailDTO;
import com.shcherbinina.cinemapark.dto.services.MovieImageService;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

@Controller
@RequestMapping("/cinemapark")
public class CinemaparkController {
    @Autowired
    MovieService movieService;

    @RequestMapping(method= RequestMethod.GET)
    public String getCinemaparkPage(Model model) {
        List<MovieThumbnailDTO> movies = movieService.getMoviesNowInCinema();
        model.addAttribute("movies", movies);
        return "cinemapark";
    }

    @RequestMapping(value="/soon", method= RequestMethod.GET)
    public String getMoviesSoonPage(Model model) {
        List<MovieThumbnailDTO> movies = movieService.getMoviesSoonInCinema();
        model.addAttribute("movies", movies);
        return "moviesSoon";
    }
}
