package com.example.notebook.model;

import jakarta.persistence.*;

@Entity
@Table(name = "gep")
public class Gep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String gyarto;
    private String tipus;
    private Double kijelzo;
    private Integer memoria;
    private String merevlemez;
    private Integer ar;

    // Összekötés: Sok gép -> Egy oprendszer
    @ManyToOne
    @JoinColumn(name = "oprendszerid") // Ez a mező neve az SQL táblában!
    private Oprendszer oprendszer;

    // Összekötés: Sok gép -> Egy processzor
    @ManyToOne
    @JoinColumn(name = "processzorid") // Ez a mező neve az SQL táblában!
    private Processzor processzor;

    // Üres konstruktor (kötelező a JPA miatt)
    public Gep() {}

    // Getterek és Setterek
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getGyarto() { return gyarto; }
    public void setGyarto(String gyarto) { this.gyarto = gyarto; }
    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = tipus; }
    public Double getKijelzo() { return kijelzo; }
    public void setKijelzo(Double kijelzo) { this.kijelzo = kijelzo; }
    public Integer getMemoria() { return memoria; }
    public void setMemoria(Integer memoria) { this.memoria = memoria; }
    public String getMerevlemez() { return merevlemez; }
    public void setMerevlemez(String merevlemez) { this.merevlemez = merevlemez; }
    public Integer getAr() { return ar; }
    public void setAr(Integer ar) { this.ar = ar; }
    public Oprendszer getOprendszer() { return oprendszer; }
    public void setOprendszer(Oprendszer oprendszer) { this.oprendszer = oprendszer; }
    public Processzor getProcesszor() { return processzor; }
    public void setProcesszor(Processzor processzor) { this.processzor = processzor; }
}