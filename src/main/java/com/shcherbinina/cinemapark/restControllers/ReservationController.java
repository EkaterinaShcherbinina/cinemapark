package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.dto.services.ReservationService;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.ValidationHelper;
import com.shcherbinina.cinemapark.validation.payloadValidation.ReservationDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
    public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    UserService userService;
    @Autowired
    ReservationDTOValidator reservationDTOValidator;

    @RequestMapping(value = "/session{id}", method = RequestMethod.GET)
    public List<RowDTO> getHallPlan(@PathVariable String id) {
        List<RowDTO> rowDTOs = reservationService.getHallLayout(Integer.valueOf(id));
        return rowDTOs;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ReservationDTO getReservation(@PathVariable String id) {
        return reservationService.getReservationById(Integer.valueOf(id));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postReservation(@Validated(ReservationDTO.New.class) @RequestBody ReservationDTO reservationDTO,
                                                  BindingResult bindingResult) throws PayloadValidationException, BusinessValidationException {

        ValidationHelper.checkErrors(bindingResult);

        if(reservationDTO.getIsPaid())
            userService.withdrawMoney(reservationDTO);

        reservationService.addNewReservation(reservationDTO);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        reservationService.deleteReservation(Integer.valueOf(id));
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@Validated(ReservationDTO.Update.class)@RequestBody ReservationDTO reservationDTO,
                                                BindingResult bindingResult) throws PayloadValidationException {
        ValidationHelper.checkErrors(bindingResult);
        reservationService.updateReservation(reservationDTO);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
