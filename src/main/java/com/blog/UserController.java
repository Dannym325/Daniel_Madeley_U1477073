package com.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.blog.User;
import com.blog.UserService;

/**
 * Created by Danny Madeley on 23/01/17.
 */

@Controller
public class UserController {

    @Autowired
    protected UserService userService;

    @GetMapping("/login") // takes a user to the login page
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    /**
    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute User user) {
        return "result";
    } */

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        User user1 = userService.validateUser(user.getUsername(), user.getPassword());
        if(user1.getUsername().equalsIgnoreCase(user.getUsername())) {
            if(user1.getPassword().equalsIgnoreCase(user.getPassword())) {
                model.addAttribute("user", new User());
                model.addAttribute("users", userService.findAll());
                model.addAttribute("type", "success");
                model.addAttribute("message", "A new user has been created");
                // should get here if the username and password is correct.
                return "index";
            }
            return "login";
        }

        return "login";
    }


}