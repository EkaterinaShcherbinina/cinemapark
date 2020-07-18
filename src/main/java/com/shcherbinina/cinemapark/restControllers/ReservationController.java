package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.ReservationDTO;
import com.shcherbinina.cinemapark.dto.entity.RowDTO;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.dto.services.ReservationService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.payloadValidation.ReservationDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
    public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccountService accountService;
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

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postReservation(@RequestBody ReservationDTO reservationDTO) throws PayloadValidationException, BusinessValidationException {
        reservationDTOValidator.validate(reservationDTO);

        if(reservationDTO.getIsPaid())
            accountService.getMoney(reservationDTO);

        if(reservationDTO.getId() == 0)
            reservationService.addNewReservation(reservationDTO);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        reservationService.deleteReservation(Integer.valueOf(id));
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@RequestBody ReservationDTO reservationDTO) {
        reservationService.updateReservation(reservationDTO);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}