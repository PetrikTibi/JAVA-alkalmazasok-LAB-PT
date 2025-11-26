package com.example.notebook.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "oprendszer")
public class Oprendszer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nev;

    // Kapcsolat: Egy oprendszer -> Több gép
    // A "mappedBy" azt jelzi, hogy a Gep osztály "oprendszer" mezője a tulajdonos
    @OneToMany(mappedBy = "oprendszer")
    private List<Gep> gepek;

    // Getterek és Setterek
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }
    public List<Gep> getGepek() { return gepek; }
    public void setGepek(List<Gep> gepek) { this.gepek = gepek; }
}