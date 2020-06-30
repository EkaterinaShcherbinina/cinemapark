package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dao.entity.MovieSession;
import com.shcherbinina.cinemapark.dao.repository.MovieSessionRepository;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import com.shcherbinina.cinemapark.dto.services.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private MovieSessionService movieSessionService;

    @ResponseBody
    @RequestMapping(value = "/{date}", method = RequestMethod.GET)
    public List<MovieSessionDTO> getSchedule(@PathVariable String date) {
        List<MovieSessionDTO> sessions = movieSessionService.getAllMovieSessionsByDate(date);
        return sessions;
    }
}
