package com.shcherbinina.cinemapark.controllers;

import com.shcherbinina.cinemapark.dao.repository.UserRepository;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.services.IUserService;
import com.shcherbinina.cinemapark.dto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

}
