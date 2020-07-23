package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.BusinessValidationException;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.validation.payloadValidation.UserDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AuthorizationController {
    @Autowired
    private UserDTOValidator userValidator;
    @Autowired
    private UserService userService;

    @GetMapping("/sign-up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new UserDTO());
        return "signUp";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute @Valid UserDTO user, BindingResult result, Model model)
            throws PayloadValidationException {
        userValidator.validate(user);
        if (result.hasErrors()) {
            model.addAttribute("error", "Invalid input data");
            return "signUp";
        }
        userService.addNewUser(user);
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "error", required = false) Boolean error,
        Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "signIn";
    }

    @ExceptionHandler({PayloadValidationException.class, BusinessValidationException.class})
    public ModelAndView handlePayloadValidationException(HttpServletRequest req, Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("error", ex.getMessage());
        mav.setViewName("signUp");
        return mav;
    }
}
