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
        model.addAttribute(user);
        return "register";
    }

    @PostMapping("/register")
    public String createNewUser(Model model, @Valid User user, BindingResult bindingResult) {
        User userExists = this.userService.findByUserName(user.getUsername());
        if (userExists != null) {
            bindingResult.rejectValue("userName", "error.user",
                    "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            user.setRegisteredOn(String.valueOf(LocalDateTime.now()));
            this.userService.save(user);
            model.addAttribute("successMessage", "User has been registered successfully!");
            model.addAttribute("user", new User());
            return "register";
        }
    }

}