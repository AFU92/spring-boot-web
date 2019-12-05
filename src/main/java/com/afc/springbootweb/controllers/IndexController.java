package com.afc.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class IndexController {

    @GetMapping({"/index", "/", "/home"})
    public String index(Map<String, Object> map) {
        map.put("title", "Hello buddy!");
        return "index";
    }
}
