package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;
import com.shcherbinina.cinemapark.dto.services.ICinemaHallService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.ValidationHelper;
import com.shcherbinina.cinemapark.validation.payloadValidation.HallDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/cinema-hall")
public class AdminCinemaHallController {
    @Autowired
    ICinemaHallService cinemaHallService;
    @Autowired
    private HallDTOValidator hallValidator;

    @RequestMapping(value = "/new", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postMovie(
            @RequestBody @Validated(CinemaHallDTO.Update.class) CinemaHallDTO cinemaHallDTO,
            BindingResult bindingResult) throws PayloadValidationException {
        hallValidator.validate(cinemaHallDTO, bindingResult);
        ValidationHelper.checkErrors(bindingResult);
        cinemaHallService.addNewCinemaHall(cinemaHallDTO);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        cinemaHallService.deleteCinemaHall(Integer.valueOf(id));
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(
            @RequestBody @Validated(CinemaHallDTO.New.class) CinemaHallDTO cinemaHallDTO,
            BindingResult bindingResult) throws PayloadValidationException {
        hallValidator.validate(cinemaHallDTO, bindingResult);
        ValidationHelper.checkErrors(bindingResult);
        cinemaHallService.updateCinemaHall(cinemaHallDTO);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
