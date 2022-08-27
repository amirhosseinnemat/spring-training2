package com.mvcsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // mapping for home page

    @RequestMapping("/home")
    public String showHome(Model model) {

        model.addAttribute("theDate", new java.util.Date());

        return "home";
    }

}
