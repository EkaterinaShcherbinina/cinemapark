package com.shcherbinina.cinemapark.dto.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Data
public class MovieDTO {
    public interface New {
    }

    interface Exist {
    }

    public interface Update extends Exist {
    }

    @NegativeOrZero(message = "Id must be 0", groups = {New.class})
    @Positive(message = "Id mustn't be 0", groups = {Update.class})
    private int id;

    @NotEmpty(message = "SecondaryKey shouldn't be empty", groups = {Update.class})
    private String secondaryKey;

    @NotEmpty(message = "Movie name shouldn't be empty", groups = {New.class, Update.class})
    private String name;

    @NotEmpty(message = "Actors field shouldn't be empty", groups = {New.class, Update.class})
    private String actors;

    @NotEmpty(message = "Duration field shouldn't be empty", groups = {New.class, Update.class})
    private String duration;

    @NotEmpty(message = "Description shouldn't be empty", groups = {New.class, Update.class})
    private String description;

    /*@NotBlank
    @Min(value=1)
    @Max(value=10)*/
    @NotEmpty(groups = {New.class, Update.class})
    private String rating;

    @NotEmpty(message = "Genre shouldn't be empty", groups = {New.class, Update.class})
    private String genre;

    @NotEmpty(message = "Producer field shouldn't be empty", groups = {New.class, Update.class})
    private String producer;

    @NotEmpty(message = "Production year field shouldn't be empty", groups = {New.class, Update.class})
    private String productionYear;

    @NotEmpty(message = "Premiere date field shouldn't be empty", groups = {New.class, Update.class})
    private String premiereDate;

    private MultipartFile image;
}
