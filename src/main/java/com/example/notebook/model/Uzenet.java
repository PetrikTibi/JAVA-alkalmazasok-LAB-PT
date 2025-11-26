package com.example.notebook.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "uzenetek")
public class Uzenet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "A név megadása kötelező!")
    @Size(min = 2, max = 50, message = "A név 2 és 50 karakter között legyen!")
    private String nev;

    @NotEmpty(message = "Az email cím kötelező!")
    @Email(message = "Nem megfelelő email formátum!")
    private String email;

    @NotEmpty(message = "Az üzenet szövege nem lehet üres!")
    @Column(columnDefinition = "TEXT") // Hosszú szöveg
    private String szoveg;

    private LocalDateTime datum; // Mikor küldték

    // Konstruktor, ami beállítja az aktuális időt
    public Uzenet() {
        this.datum = LocalDateTime.now();
    }

    // Getterek és Setterek
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNev() { return nev; }
    public void setNev(String nev) { this.nev = nev; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSzoveg() { return szoveg; }
    public void setSzoveg(String szoveg) { this.szoveg = szoveg; }
    public LocalDateTime getDatum() { return datum; }
    public void setDatum(LocalDateTime datum) { this.datum = datum; }
}