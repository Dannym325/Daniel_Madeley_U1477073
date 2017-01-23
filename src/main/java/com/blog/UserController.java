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

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute User user) {
        return "result";
    }

    @RequestMapping(value = "/create/user", method = RequestMethod.POST)
    public String createUser(Model model, @Valid @ModelAttribute("user") User user, BindingResult bindingResult) {

        userService.save(user); // save the user to the database

        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("type", "success");
        model.addAttribute("message", "A new user has been created");

        return "result";
    }

}