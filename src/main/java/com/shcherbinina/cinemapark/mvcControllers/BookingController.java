package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.BookedDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.dto.services.ReservationService;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.validation.payloadValidation.ReservationDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;
    @Autowired
    private ReservationDTOValidator reservationValidator;

    @RequestMapping(value = "/session{id}", method = RequestMethod.GET)
    public String getLayout(@PathVariable String id, Model model) {
        List<RowDTO> rowDTOs = reservationService.getHallLayout(Integer.valueOf(id));
        model.addAttribute("rows", rowDTOs);
        model.addAttribute("sessionId", id);
        model.addAttribute("reservation", new ReservationDTO());
        return "booking";
    }

    @PostMapping()
    @Transactional
    public String postReservation(@ModelAttribute("reservation") ReservationDTO reservationDTO,
        BindingResult bindingResult, Model model) throws BusinessValidationException {
        reservationValidator.validate(reservationDTO, bindingResult);

        if(bindingResult.hasErrors()) {
            List<RowDTO> rowDTOs = reservationService.getHallLayout(reservationDTO.getSessionId());
            model.addAttribute("rows", rowDTOs);
            model.addAttribute("sessionId", reservationDTO.getSessionId());
            return "/booking";
        }

        if(reservationDTO.getIsPaid())
        userService.withdrawMoney(reservationDTO);

        reservationService.addNewReservation(reservationDTO);

        BookedDTO booked = reservationService.getBookedPlace(reservationDTO);
        model.addAttribute("booked", booked);

        return "reservation";
    }

    @ExceptionHandler({BusinessValidationException.class})
    public ModelAndView handlePayloadValidationException(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex.getMessage());
        mav.setViewName("controllerError");
        return mav;
    }
}
