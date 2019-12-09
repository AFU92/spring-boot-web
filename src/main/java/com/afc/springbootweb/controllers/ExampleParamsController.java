package com.afc.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ExampleParamsController {

    @GetMapping("/string")
    public String param(@RequestParam(name = "Text", required = false, defaultValue = "testing") String textVariable, Model model){
        model.addAttribute("result", "El texto enviado es: " + textVariable);
        return "params/show";
    }
}
