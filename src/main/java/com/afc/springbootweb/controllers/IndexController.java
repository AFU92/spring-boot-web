package com.afc.springbootweb.controllers;

import com.afc.springbootweb.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("title", "Hello buddy!");
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        User user = new User();
        user.setName("Andrea");
        user.setLastName("Fuentes");
        user.setEmail("dev@test.com");

        model.addAttribute("user", user);
        model.addAttribute("title", "User profile".concat(user.getName()));
        return "profile";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("Daniel", "Torres", "dt@test.com"));
        users.add(new User("Juli", "Davila", "jd@test.com"));
        users.add(new User("Mich", "Perez", "mp@test.com"));
        users.add(new User("Juan", "Molina", "jm@test.com"));
        model.addAttribute("title", "users_list");
        model.addAttribute("users", users);
            return"list";
    }
}
