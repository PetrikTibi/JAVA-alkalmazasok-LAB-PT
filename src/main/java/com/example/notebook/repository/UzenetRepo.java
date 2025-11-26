package com.example.notebook.repository;

import com.example.notebook.model.Uzenet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UzenetRepo extends JpaRepository<Uzenet, Integer> {
    // Ez a varázsmetódus: lekéri az összeset, dátum szerint csökkenő sorrendben
    List<Uzenet> findAllByOrderByDatumDesc();
}