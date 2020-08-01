package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import com.shcherbinina.cinemapark.dto.services.AdminMovieSessionService;
import com.shcherbinina.cinemapark.dto.services.MovieSessionService;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin-session")
public class AdminMovieSessionController {
    @Autowired
    AdminMovieSessionService sessionService;
    @Autowired
    MovieSessionService movieSessionService;

    @GetMapping("/sessions")
    public String getSessions(Model model) {
        List<MovieSessionDTO> sessions = movieSessionService.getAllMovieSessionsByDate(Utility.getNowOnlyDate());
        model.addAttribute("sessions", sessions);
        model.addAttribute("date", Utility.getNowFormattedDateWithTimeZone());
        return "adminSessions";
    }

    @PostMapping("/sessions/date")
    public String getSessionsByDate(@RequestParam("date") String date, Model model) {
        List<MovieSessionDTO> sessions = null;
        if(date != null) {
            sessions = movieSessionService.getAllMovieSessionsByDate(date);
        }
        model.addAttribute("sessions", sessions);
        model.addAttribute("date", Utility.getFormattedDate(date).toString());
        return "adminSessions";
    }

    @GetMapping("/edit{id}")
    public String editSession(@PathVariable("id") int id, Model model) {
        AdminSessionDTO session = sessionService.getById(id);
        model.addAttribute("session", session);
        return "sessionEdit";
    }

    @PostMapping("/edit")
    public String postEditSession(@ModelAttribute AdminSessionDTO session, Model model) {
        sessionService.updateMovieSession(session);
        return "redirect:/admin-session/sessions";
    }

    @GetMapping("/new")
    public String newSession(Model model) {
        model.addAttribute("session", new AdminSessionDTO());
        return "newSession";
    }

    @PostMapping("/new")
    public String postNewHall(@ModelAttribute AdminSessionDTO sessionDTO,
                              BindingResult bindingResult, Model model) {
        //TODO: validation fields
        sessionService.addMovieSession(sessionDTO);
        return "redirect:/admin";
    }
}
