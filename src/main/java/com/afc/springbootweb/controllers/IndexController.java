package com.afc.springbootweb.controllers;

import com.afc.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("title", "Hello buddy!");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model){

        User user = new User();
        user.setName("Andrea");
        user.setLastName("Fuentes");

        model.addAttribute("user", user);
        model.addAttribute("title", "User profile".concat(user.getName()));
        return "profile";
    }
}
