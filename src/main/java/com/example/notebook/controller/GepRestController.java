package com.example.notebook.controller;

import com.example.notebook.model.Gep;
import com.example.notebook.repository.GepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gepek")
public class GepRestController {

    @Autowired
    private GepRepo gepRepo;

    // 1. Összes gép lekérdezése (GET /api/gepek)
    @GetMapping
    public List<Gep> getGepek() {
        return gepRepo.findAll();
    }

    // 2. Egy gép lekérdezése ID alapján (GET /api/gepek/1)
    @GetMapping("/{id}")
    public Gep getGep(@PathVariable("id") Integer id) {
        Optional<Gep> gep = gepRepo.findById(id);
        if (gep.isPresent()) {
            return gep.get();
        } else {
            throw new RuntimeException("Nincs ilyen gép az adatbázisban: " + id);
        }
    }

    // 3. Törlés (DELETE /api/gepek/1)
    @DeleteMapping("/{id}")
    public void deleteGep(@PathVariable("id") Integer id) {
        gepRepo.deleteById(id);
    }
}