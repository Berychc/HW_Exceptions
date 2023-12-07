package com.ExceptionsdemoHW.Controller;

import com.ExceptionsdemoHW.Service.InformationServiceImp;
import com.ExceptionsdemoHW.Exceptions.WrongLoginException;
import com.ExceptionsdemoHW.Exceptions.WrongPasswordException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class InformationController {
    private final InformationServiceImp informationService;

    public InformationController(InformationServiceImp informationService) {
        this.informationService = informationService;
    }

    @GetMapping
    public String startPage() {
        return informationService.startPage();
    }

    @GetMapping(path = "/check")
    public static void checkLoginPassword(@RequestParam("login") String login
            , @RequestParam("password") String password, @RequestParam("confirm") String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        try {
            if (login.length() > 20 && login.length() <= 20 || !login.matches("[a-zA-Z0-9_]")) {
                throw new WrongLoginException("Неверный логин");
            }
            if (password.length() > 20 || !password.matches("[a-zA-Z0-9_]")) {
                throw new WrongPasswordException("Неверный пароль");
            }
            if (password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпдают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

}

