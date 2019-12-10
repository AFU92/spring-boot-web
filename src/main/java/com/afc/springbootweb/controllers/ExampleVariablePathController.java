package com.afc.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class ExampleVariablePathController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title", "Send params from Path (@PathVariable)");
        return "variables/index";
    }

    @GetMapping("/string/{text}")
    public String variables(@PathVariable String text, Model model){
        model.addAttribute("title", "Receive params from Path (@PathVariable)");
        model.addAttribute("result", "The text is: " + text);
        return "variables/show";
    }

    @GetMapping("/string/{text}/{number}")
    public String variables(@PathVariable String text, @PathVariable Integer number, Model model){
        model.addAttribute("title", "Receive params from Path (@PathVariable)");
        model.addAttribute("result", "The text is: " + text +
                ", the number is: "+ number);
        return "variables/show";
    }


}
