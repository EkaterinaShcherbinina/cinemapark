package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.BookedDTO;
import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.dto.services.ReservationService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.payloadValidation.ReservationDTOValidator;
//import com.shcherbinina.cinemapark.validation.validationErrors.ReservationErrors;
//import com.shcherbinina.cinemapark.validation.validationErrors.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    ReservationService reservationService;
    @Autowired
    AccountService accountService;
    @Autowired
    private ReservationDTOValidator reservationValidator;

    @RequestMapping(value = "/session{id}", method = RequestMethod.GET)
    public String getLayout(@PathVariable String id, Model model) {
        List<RowDTO> rowDTOs = reservationService.getHallLayout(Integer.valueOf(id));
        model.addAttribute("rows", rowDTOs);
        model.addAttribute("sessionId", id);
        return "booking";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @Transactional
    public String postReservation(@ModelAttribute ReservationDTO reservationDTO,
                                  BindingResult bindingResult, Model model)
            throws PayloadValidationException, BusinessValidationException {
        reservationDTO.setUserId(8); //TODO: workaround for user, will be fixed after adding spring security
        reservationValidator.validate(reservationDTO);

        if(reservationDTO.getIsPaid())
        accountService.getMoney(reservationDTO);

        if(reservationDTO.getId() == 0)
        reservationService.addNewReservation(reservationDTO);

        BookedDTO booked = reservationService.getBookedPlace(reservationDTO);
        model.addAttribute("booked", booked);

        return "reservation";
    }

    @ExceptionHandler({PayloadValidationException.class, BusinessValidationException.class})
    public ModelAndView handlePayloadValidationException(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex.getMessage());
        mav.setViewName("controllerError");
        return mav;
    }
}
