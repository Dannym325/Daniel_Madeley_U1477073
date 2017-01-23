package com.blog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Danny Madeley on 23/01/17.
 */

@Controller
public class UserController {

    @GetMapping("/login")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String greetingSubmit(@ModelAttribute User user) {
        return "result";
    }

}