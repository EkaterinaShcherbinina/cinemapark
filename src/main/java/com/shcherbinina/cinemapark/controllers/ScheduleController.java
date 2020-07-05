package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import com.shcherbinina.cinemapark.dto.services.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private MovieSessionService movieSessionService;

    @RequestMapping(value = "/{date}", method = RequestMethod.GET)
    public List<MovieSessionDTO> getSchedule(@PathVariable String date) {
        List<MovieSessionDTO> sessions = movieSessionService.getAllMovieSessionsByDate(date);
        return sessions;
    }
}
