package com.example.notebook.controller;

import com.example.notebook.model.Gep;
import com.example.notebook.repository.GepRepo;
import com.example.notebook.repository.OprendszerRepo;
import com.example.notebook.repository.ProcesszorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GepController {

    @Autowired
    private GepRepo gepRepo;
    @Autowired
    private OprendszerRepo oprendszerRepo;
    @Autowired
    private ProcesszorRepo processzorRepo;

    // 1. ÚJ GÉP ŰRLAP MEGJELENÍTÉSE
    @GetMapping("/gep/uj")
    public String ujGepForm(Model model) {
        model.addAttribute("gep", new Gep());
        // A legördülő menükhöz elküldjük a listákat is
        model.addAttribute("oprendszerek", oprendszerRepo.findAll());
        model.addAttribute("processzorok", processzorRepo.findAll());
        return "gep_urlap"; // Ezt a HTML-t fogjuk mindjárt létrehozni
    }

    // 2. GÉP MENTÉSE (Új és Módosítás is ide fut be)
    @PostMapping("/gep/ment")
    public String gepMentes(@ModelAttribute Gep gep) {
        gepRepo.save(gep);
        return "redirect:/"; // Visszatérünk a főoldalra
    }

    // 3. SZERKESZTÉS ŰRLAP MEGJELENÍTÉSE
    @GetMapping("/gep/szerkeszt/{id}")
    public String szerkesztForm(@PathVariable("id") Integer id, Model model) {
        Gep gep = gepRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Hibás ID: " + id));
        model.addAttribute("gep", gep);
        model.addAttribute("oprendszerek", oprendszerRepo.findAll());
        model.addAttribute("processzorok", processzorRepo.findAll());
        return "gep_urlap"; // Ugyanazt az űrlapot használjuk, mint az újnál
    }

    // 4. TÖRLÉS
    @GetMapping("/gep/torol/{id}")
    public String torles(@PathVariable("id") Integer id) {
        gepRepo.deleteById(id);
        return "redirect:/";
    }
}