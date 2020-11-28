package pl.coderslab.charity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registration(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String createNewUser(Model model, @Valid User user, BindingResult bindingResult) {
        User userExists = this.userService.findByUserName(user.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue("username", "error.user",
                    "Taki użytkownik już istnieje!");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            user.setRegisteredOn(String.valueOf(LocalDateTime.now()));
            this.userService.save(user);
            model.addAttribute("successMessage", "Konto zostało pomyślnie utworzone!");
            model.addAttribute("user", new User());
            return "login";
        }
    }

}