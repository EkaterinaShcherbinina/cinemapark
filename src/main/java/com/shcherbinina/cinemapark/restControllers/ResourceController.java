package com.shcherbinina.cinemapark.restControllers;

import com.shcherbinina.cinemapark.dto.entity.MovieImageDTO;
import com.shcherbinina.cinemapark.dto.services.MovieImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Blob;
import java.sql.SQLException;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    @Autowired
    MovieImageService imageService;

    @RequestMapping(value = "/getMovieImage/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getMovieImage(@PathVariable int id) throws SQLException {
        HttpHeaders headers = new HttpHeaders();
        MovieImageDTO imageDTO = imageService.getMovieImageDTOByImageId(id);
        Blob image = imageDTO.getImage();
        byte[] bytes = image.getBytes(1, (int) image.length());
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());

        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        return responseEntity;
    }

}
