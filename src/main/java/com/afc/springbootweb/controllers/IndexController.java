package com.afc.springbootweb.controllers;

import com.afc.springbootweb.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${indexController.index.title}")
    private String indexText;

    @Value("${indexController.profile.title}")
    private String profileText;

    @Value("${indexController.list.title}")
    private String listText;


    @GetMapping({"/index", "/", "", "/home"})
    public String index(Model model) {
        model.addAttribute("title", indexText);
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model) {

        User user = new User();
        user.setName("Andrea");
        user.setLastName("Fuentes");
        user.setEmail("dev@test.com");

        model.addAttribute("user", user);
        model.addAttribute("title", profileText.concat(user.getName()));
        return "profile";
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("title", listText);
            return"list";
    }

    @ModelAttribute("users")
    public List<User> loadUsers(){
        List<User> users = Arrays.asList(new User("Daniel", "Torres", "dt@test.com"),
                new User("Juli", "Davila", "jd@test.com"),
                new User("Mich", "Perez", "mp@test.com"),
                new User("Juan", "Molina", "jm@test.com"),
                new User("Rick", "Noulose", "jm@test.com"));
        return users;
    }
}
