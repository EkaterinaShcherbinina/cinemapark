package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.AdminSessionDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieSessionDTO;
import com.shcherbinina.cinemapark.dto.services.AdminMovieSessionService;
import com.shcherbinina.cinemapark.dto.services.MovieSessionService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.utility.Utility;
import com.shcherbinina.cinemapark.validation.payloadValidation.MovieSessionDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin-session")
public class AdminMovieSessionController {
    @Autowired
    private AdminMovieSessionService sessionService;
    @Autowired
    private MovieSessionService movieSessionService;
    @Autowired
    private MovieSessionDTOValidator sessionValidator;

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
    public String postEditSession(
            @ModelAttribute("session") @Validated(AdminSessionDTO.Update.class) AdminSessionDTO session,
            BindingResult bindingResult) {
        sessionValidator.validate(session, bindingResult);
        if(bindingResult.hasErrors()) return "/sessionEdit";
        sessionService.updateMovieSession(session);
        return "redirect:/admin-session/sessions";
    }

    @GetMapping()
    public String newSession(Model model) {
        model.addAttribute("session", new AdminSessionDTO());
        return "newSession";
    }

    @PostMapping()
    public String postNewHall(
            @ModelAttribute("session") @Validated(AdminSessionDTO.New.class) AdminSessionDTO session,
            BindingResult bindingResult) throws BusinessValidationException {
        sessionValidator.validate(session, bindingResult);
        if(bindingResult.hasErrors()) return "/sessionEdit";
        sessionService.addMovieSession(session);
        return "redirect:/admin";
    }
}
