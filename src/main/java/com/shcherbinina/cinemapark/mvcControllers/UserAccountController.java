package com.shcherbinina.cinemapark.mvcControllers;

import com.shcherbinina.cinemapark.dto.entity.*;
import com.shcherbinina.cinemapark.dto.services.AccountService;
import com.shcherbinina.cinemapark.dto.services.UserService;
import com.shcherbinina.cinemapark.exceptions.validationExceptions.PayloadValidationException;
import com.shcherbinina.cinemapark.security.AuthenticationFacade;
import com.shcherbinina.cinemapark.utility.Utility;
import com.shcherbinina.cinemapark.validation.payloadValidation.MoneyAccountDTOValidator;
import com.shcherbinina.cinemapark.validation.payloadValidation.UserEmailValidator;
import com.shcherbinina.cinemapark.validation.payloadValidation.UserPasswordDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class UserAccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    UserPasswordDTOValidator passwordValidator;
    @Autowired
    private UserEmailValidator emailValidator;
    @Autowired
    private AuthenticationFacade authenticationFacade;
    @Autowired
    private MoneyAccountDTOValidator accountValidator;

    @GetMapping
    public String getAccount(Model model) {
        UserHistoryDTO historyDTO = accountService.getUserHistory(Utility.getCurrentUserId());
        model.addAttribute("history", historyDTO);
        return "account";
    }

    @GetMapping("/settings")
    public String settingsAccount(Model model) {
        UserNameDTO nameDTO = userService.getUserNameById(Utility.getCurrentUserId());
        UserEmailDTO email = userService.getUserEmailById(Utility.getCurrentUserId());
        model.addAttribute("user", nameDTO);
        model.addAttribute("email", email);
        return "settings";
    }

    @GetMapping("/edit-name")
    public String editAccount(Model model) {
        UserNameDTO user = userService.getUserNameById(Utility.getCurrentUserId());
        model.addAttribute("user", user);
        return "editAccount";
    }

    @PostMapping("/edit-name")
    public String postEditAccount(@ModelAttribute("user") @Valid UserNameDTO userDTO,
                                  BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "/editAccount";
        userService.updateUserName(userDTO);
        return "redirect:/account";
    }

    @GetMapping("/edit-password")
    public String editPassword(Model model) {
        model.addAttribute("password", new UserPasswordDTO());
        return "editPassword";
    }

    @PostMapping("/edit-password")
    public String postEditPassword(@ModelAttribute("password") @Valid UserPasswordDTO userPasswordDTO,
                                   BindingResult bindingResult) {
        passwordValidator.validate(userPasswordDTO, bindingResult);

        if(bindingResult.hasErrors()) return "/editPassword";
        userService.updateUserPassword(userPasswordDTO);
        return "redirect:/account";
    }

    @GetMapping("/edit-email")
    public String editEmail(Model model) {
        UserEmailDTO email = userService.getUserEmailById(authenticationFacade.getCurrentUserId());
        model.addAttribute("email", email);
        return "editEmail";
    }

    @PostMapping("/edit-email")
    public String postEditEmail(@ModelAttribute("email") @Valid UserEmailDTO email, BindingResult bindingResult) throws PayloadValidationException {
        emailValidator.validate(email, bindingResult);
        if(bindingResult.hasErrors()) return "/editEmail";

        userService.updateUserEmail(email);
        return "redirect:/account";
    }

    @GetMapping("/balance")
    public String getMoneyAccount(Model model) {
        MoneyAccountDTO moneyAccount = userService.getMoneyAccount();
        model.addAttribute("moneyAccount", moneyAccount);
        return "moneyAccount";
    }

    @GetMapping("/money")
    public String getAddMoney(Model model) {
        model.addAttribute("moneyAccount", new MoneyAccountDTO());
        return "addMoney";
    }

    @PostMapping("/money")
    public String postAddMoney(@ModelAttribute("moneyAccount") @Valid MoneyAccountDTO moneyAccount, BindingResult bindingResult) {
        accountValidator.validate(moneyAccount, bindingResult);
        if(bindingResult.hasErrors()) return "/addMoney";

        userService.topUpAccount(moneyAccount);
        return "redirect:/account/balance";
    }
}
