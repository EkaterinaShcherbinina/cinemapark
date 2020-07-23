package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import com.shcherbinina.cinemapark.dto.services.MovieSessionService;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movie-schedule")
public class MoviesScheduleController {
    @Autowired
    MovieSessionService movieSessionService;

    @RequestMapping(value="/{date}", method=RequestMethod.GET)
    public String getMovie(@PathVariable String date, Model model) {
        List<MovieSessionDTO> sessions = movieSessionService.getAllMovieSessionsByDate(date);
        model.addAttribute("sessions", sessions);
        model.addAttribute("userInfo", Utility.getCurrentUserName());
        return "movieSchedule";
    }
}
