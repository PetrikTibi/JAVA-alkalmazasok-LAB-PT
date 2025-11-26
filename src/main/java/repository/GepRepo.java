package com.example.notebook.repository;

import com.example.notebook.model.Gep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GepRepo extends JpaRepository<Gep, Integer> {
}