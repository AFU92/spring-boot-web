package com.afc.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {

    @GetMapping({"/index", "/", "/home"})
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("title", "Hello buddy!");
        mv.setViewName("index");
        return mv;
    }
}
