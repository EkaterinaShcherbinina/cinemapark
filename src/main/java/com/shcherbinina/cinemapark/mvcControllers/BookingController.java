package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.BookedDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.dto.services.ReservationService;
import com.shcherbinina.cinemapark.exceptions.businessExceptions.InsufficientFundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/session{id}", method = RequestMethod.GET)
    public String getLayout(@PathVariable String id, Model model) {
        List<RowDTO> rowDTOs = reservationService.getHallLayout(Integer.valueOf(id));
        model.addAttribute("rows", rowDTOs);
        model.addAttribute("sessionId", id);
        return "booking";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @Transactional
    public String postReservation(@ModelAttribute ReservationDTO reservationDTO, Model model) {
        reservationDTO.setUserId(8); //TODO: workaround for user, will be fixed after adding spring security

        if(reservationDTO.getIsPaid()) {
            try {
                accountService.getMoney(reservationDTO);
            } catch (InsufficientFundsException ex) {
                List<RowDTO> rowDTOs = reservationService.getHallLayout(Integer.valueOf(reservationDTO.getSessionId()));
                model.addAttribute("rows", rowDTOs);
                model.addAttribute("sessionId", reservationDTO.getSessionId());
                String errorMessage = ex.getMessage();
                model.addAttribute("errorMessage", errorMessage);
                return "booking";
            }
        }

        if(reservationDTO.getId() == 0)
        reservationService.addNewReservation(reservationDTO);

        BookedDTO booked = reservationService.getBookedPlace(reservationDTO);
        model.addAttribute("booked", booked);

        return "reservation";
    }
}
