package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.CinemaHallDTO;
import com.shcherbinina.cinemapark.dto.services.ICinemaHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/cinema-hall")
public class AdminCinemaHallController {
    @Autowired
    ICinemaHallService cinemaHallService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> postMovie(@RequestBody CinemaHallDTO cinemaHallDTO)
    {
        cinemaHallService.addNewCinemaHall(cinemaHallDTO);
        return new ResponseEntity<>("Saved successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        cinemaHallService.deleteCinemaHall(Integer.valueOf(id));
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateProduct(@RequestBody CinemaHallDTO cinemaHallDTO) {
        cinemaHallService.updateCinemaHall(cinemaHallDTO);
        return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
    }
}
