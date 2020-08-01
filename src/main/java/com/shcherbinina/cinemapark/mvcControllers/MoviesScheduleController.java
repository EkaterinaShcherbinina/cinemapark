package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
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
    private MovieSessionService sessionService;

    @RequestMapping(method=RequestMethod.GET)
    public String getScheduleToday(Model model) {
        List<MovieSessionDTO> sessions = sessionService.getAllMovieSessionsByDate(Utility.getNowOnlyDate());
        model.addAttribute("sessions", sessions);
        model.addAttribute("date", Utility.getNowFormattedDateWithTimeZone());
        return "movieSchedule";
    }

    @RequestMapping(value = "/schedule", method= RequestMethod.POST)
    public String getScheduleByDate(@RequestParam("date") String date, Model model) {
        List<MovieSessionDTO> sessions = sessionService.getAllMovieSessionsByDate(date);
        model.addAttribute("sessions", sessions);
        model.addAttribute("date", Utility.getFormattedDate(date).toString());
        return "movieSchedule";
    }
}
