package com.example.notebook.controller;

import com.example.notebook.repository.GepRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final GepRepo gepRepo;

    public HomeController(GepRepo gepRepo) {
        this.gepRepo = gepRepo;
    }

    // Főoldal
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("gepek", gepRepo.findAll());
        return "index";
    }


    @GetMapping("/login")
    public String login() {
        return "login";
    }
}