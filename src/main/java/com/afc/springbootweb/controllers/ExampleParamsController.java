package com.afc.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ExampleParamsController {

    @GetMapping("/")
    public String index(){

        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "text", required = false, defaultValue = "testing") String textVariable, Model model){
        model.addAttribute("result", "El texto enviado es: " + textVariable);
        return "params/show";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String greeting, @RequestParam Integer number, Model model){
        model.addAttribute("result", "El saludo enviado es: '" + greeting + "' y el número es: '" + number +"'");
        return "params/show";
    }

    @GetMapping("/mix-params-two")
    public String param(HttpServletRequest request, Model model){
        String greeting = request.getParameter("greeting");
        Integer number = null;
        try {
            number = Integer.parseInt(request.getParameter("number"));
        } catch (NumberFormatException e) {
            number = 0;
        }
        model.addAttribute("result", "El saludo enviado es: '" + greeting + "' y el número es: '" + number +"'");
        return "params/show";
    }


}
