package com.shcherbinina.cinemapark.validation.payloadValidation;

import com.shcherbinina.cinemapark.dto.entity.MovieDTO;
import com.shcherbinina.cinemapark.dto.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MovieDTOValidator implements Validator {
    private final String imageErrorMessage = "Image must be added";

    @Autowired
    private MovieService movieService;

    @Override
    public boolean supports(Class<?> aClass) {
        return MovieDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        MovieDTO movieDTO = (MovieDTO) o;
        MultipartFile image = movieDTO.getImage();
        if(movieDTO.getId() == 0 && image.isEmpty()) errors.rejectValue("image", "", imageErrorMessage);
    }
}
