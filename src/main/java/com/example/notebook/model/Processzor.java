package com.example.notebook.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "processzor")
public class Processzor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String gyarto;
    private String modell;

    @OneToMany(mappedBy = "processzor")
    @JsonIgnore
    private List<Gep> gepek;

    // Getterek és Setterek
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getGyarto() { return gyarto; }
    public void setGyarto(String gyarto) { this.gyarto = gyarto; }
    public String getModell() { return modell; }
    public void setModell(String modell) { this.modell = modell; }
    public List<Gep> getGepek() { return gepek; }
    public void setGepek(List<Gep> gepek) { this.gepek = gepek; }
}