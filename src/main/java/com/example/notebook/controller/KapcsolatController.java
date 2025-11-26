package com.example.notebook.controller;

import com.example.notebook.model.Uzenet;
import com.example.notebook.repository.UzenetRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class KapcsolatController {

    @Autowired
    private UzenetRepo uzenetRepo;

    // 1. Az űrlap megjelenítése (Mindenki láthatja)
    @GetMapping("/kapcsolat")
    public String kapcsolatForm(Model model) {
        model.addAttribute("uzenet", new Uzenet());
        return "kapcsolat";
    }

    // 2. Az űrlap feldolgozása (Validációval)
    @PostMapping("/kapcsolat_feldolgoz")
    public String kapcsolatSubmit(@Valid @ModelAttribute Uzenet uzenet, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Ha hiba van (pl. üres név), visszaküldjük az űrlapra a hibaüzenetekkel
            return "kapcsolat";
        }
        // Ha minden oké, mentés és visszaigazolás
        uzenetRepo.save(uzenet);
        model.addAttribute("siker", true);
        return "kapcsolat";
    }

    // 3. Üzenetek listázása (Csak belépett felhasználóknak - ezt majd a Security-ben állítjuk)
    @GetMapping("/uzenetek")
    public String uzenetekLista(Model model) {
        model.addAttribute("lista", uzenetRepo.findAllByOrderByDatumDesc());
        return "uzenetek";
    }
}