package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;
import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.CinemaHallService;
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
@RequestMapping("/admin-hall")
public class AdminHallController {
    @Autowired
    private CinemaHallService hallService;

    @GetMapping("/halls")
    public String getHalls(Model model) {
        List <CinemaHallDTO> halls = hallService.getAllCinemaHalls();
        model.addAttribute("halls", halls);
        return "adminHalls";
    }

    @GetMapping("/edit{id}")
    public String editMovie(@PathVariable("id") int id, Model model) {
        CinemaHallDTO hall = hallService.getHallById(id);
        model.addAttribute("hall", hall);
        return "hallEdit";
    }

    @PostMapping("/edit")
    public String postEditMovie(@ModelAttribute CinemaHallDTO hallDTO,
                                BindingResult bindingResult, Model model) {
        //TODO: validation fields

        hallService.updateCinemaHall(hallDTO);
        return "redirect:/admin";
    }

    @GetMapping("/new")
    public String newHall(Model model) {
        model.addAttribute("hall", new CinemaHallDTO());
        return "newHall";
    }

    @PostMapping("/new")
    public String postNewHall(@ModelAttribute CinemaHallDTO cinemaHallDTO,
                               BindingResult bindingResult, Model model) {
        //TODO: validation fields
        hallService.addNewCinemaHall(cinemaHallDTO);
        return "redirect:/admin";
    }
}
