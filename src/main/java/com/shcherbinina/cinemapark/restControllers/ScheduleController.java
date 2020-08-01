package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.services.AdminMovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private AdminMovieSessionService adminMovieSessionService;

    @RequestMapping(value = "/{date}", method = RequestMethod.GET)
    public List<AdminSessionDTO> getSchedule(@PathVariable String date) {
        List<AdminSessionDTO> sessions = adminMovieSessionService.getAllMovieSessionsByDate(date);
        return sessions;
    }
}
