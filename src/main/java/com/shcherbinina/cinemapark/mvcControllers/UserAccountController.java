package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.DTOConverter;
import com.shcherbinina.cinemapark.dto.entity.AccountEditDTO;
import com.shcherbinina.cinemapark.dto.entity.UserDTO;
import com.shcherbinina.cinemapark.dto.entity.UserHistoryDTO;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.security.AuthProvider;
import com.shcherbinina.cinemapark.security.AuthenticationFacade;
import com.shcherbinina.cinemapark.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class UserAccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    private AuthProvider authProvider;
    @Autowired
    private DTOConverter dtoConverter;
    @Autowired
    private AuthenticationFacade authenticationFacade;

    @GetMapping
    public String getAccount(Model model) {
        UserHistoryDTO historyDTO = accountService.getUserHistory(Utility.getCurrentUserId());
        model.addAttribute("history", historyDTO);
        return "account";
    }

    @GetMapping("/settings")
    public String settingsAccount(Model model) {
        AccountEditDTO user = userService.getUserAccountById(Utility.getCurrentUserId());
        model.addAttribute("user", user);
        return "settings";
    }

    @GetMapping("/edit-account")
    public String editAccount(Model model) {
        AccountEditDTO user = userService.getUserAccountById(Utility.getCurrentUserId());
        model.addAttribute("user", user);
        return "editAccount";
    }

    @PostMapping("/edit-account")
    public String postEditAccount(@ModelAttribute AccountEditDTO userDTO) {
        userService.updateUserAccount(userDTO);
        authProvider.updateUserName(userDTO);
        return "redirect:/account";
    }

    @GetMapping("/edit-password")
    public String editPassword(Model model) {
        AccountEditDTO user = userService.getUserAccountById(Utility.getCurrentUserId());
        model.addAttribute("user", user);
        return "editPassword";
    }

    @PostMapping("/edit-password")
    public String postEditPassword(@ModelAttribute AccountEditDTO userDTO) {
        UserDTO user = userService.getById(authenticationFacade.getCurrentUserId());

        //TODO: password validation
        if (!authProvider.checkIfValidOldPassword(user.getPassword(), userDTO.getOldPassword())) {
            //throw new InvalidOldPasswordException();
        }

        userService.updateUserAccount(userDTO);
        authProvider.updateUserPassword(userDTO);
        return "redirect:/account";
    }

    @GetMapping("/edit-email")
    public String editEmail(Model model) {
        AccountEditDTO user = userService.getUserAccountById(Utility.getCurrentUserId());
        model.addAttribute("user", user);
        return "editEmail";
    }

    @PostMapping("/edit-email")
    public String postEditEmail(@ModelAttribute @Valid AccountEditDTO userDTO, BindingResult bindingResult) throws PayloadValidationException {
        UserDTO user = userService.getById(authenticationFacade.getCurrentUserId());
         if(bindingResult.hasErrors()) throw new PayloadValidationException("Invalid email");

        userService.updateUserAccount(userDTO);
        authProvider.updateUserEmail(userDTO);
        return "redirect:/account";
    }
}
