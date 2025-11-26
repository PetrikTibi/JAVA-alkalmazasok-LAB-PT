package com.example.notebook.controller;

import com.example.notebook.repository.GepRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Injektáljuk a repository-t
    private final GepRepo gepRepo;

    public HomeController(GepRepo gepRepo) {
        this.gepRepo = gepRepo;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("gepek", gepRepo.findAll());

        return "index";
    }
}