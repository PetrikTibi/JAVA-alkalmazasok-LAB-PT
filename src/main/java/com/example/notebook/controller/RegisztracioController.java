package com.example.notebook.controller;

import com.example.notebook.model.User;
import com.example.notebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisztracioController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Ez jeleníti meg a regisztrációs űrlapot
    @GetMapping("/regisztral")
    public String regisztralForm(Model model) {
        model.addAttribute("user", new User());
        return "regisztral";
    }

    // Ez menti el a felhasználót
    @PostMapping("/regisztral_feldolgoz")
    public String regisztralSubmit(@ModelAttribute User user) {
        // Jelszó titkosítása
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // FONTOS: Csak "ROLE_USER" lehet, admin nem!
        user.setRole("ROLE_USER");

        // Mentés
        userRepository.save(user);

        return "redirect:/login";
    }
}