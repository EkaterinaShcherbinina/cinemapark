package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;
import com.shcherbinina.cinemapark.dto.services.CinemaHallService;
import com.shcherbinina.cinemapark.validation.payloadValidation.HallDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin-hall")
public class AdminHallController {
    @Autowired
    private CinemaHallService hallService;
    @Autowired
    private HallDTOValidator hallValidator;

    @GetMapping("/halls")
    public String getHalls(Model model) {
        List <CinemaHallDTO> halls = hallService.getAllCinemaHalls();
        model.addAttribute("halls", halls);
        return "adminHalls";
    }

    @GetMapping("/edit{id}")
    public String editHall(@PathVariable("id") int id, Model model) {
        CinemaHallDTO hall = hallService.getHallById(id);
        model.addAttribute("hall", hall);
        return "hallEdit";
    }

    @PostMapping("/edit")
    public String createEditHall(@ModelAttribute("hall") @Validated(CinemaHallDTO.Update.class) CinemaHallDTO hallDTO,
                                BindingResult bindingResult) {
        hallValidator.validate(hallDTO, bindingResult);
        if(bindingResult.hasErrors()) return "/hallEdit";

        hallService.updateCinemaHall(hallDTO);
        return "redirect:/admin";
    }

    @GetMapping()
    public String newHall(Model model) {
        model.addAttribute("hall", new CinemaHallDTO());
        return "newHall";
    }

    @PostMapping()
    public String createNewHall(@ModelAttribute("hall") @Validated(CinemaHallDTO.New.class) CinemaHallDTO cinemaHallDTO,
                               BindingResult bindingResult) {
        hallValidator.validate(cinemaHallDTO, bindingResult);
        if(bindingResult.hasErrors()) return "/newHall";

        hallService.addNewCinemaHall(cinemaHallDTO);
        return "redirect:/admin";
    }
}
