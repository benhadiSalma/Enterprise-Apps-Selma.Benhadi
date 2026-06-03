package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;
    private String adres;
    private int capaciteit;

    // Constructors
    public Location() {}

    public Location(String naam, String adres, int capaciteit) {
        this.naam = naam;
        this.adres = adres;
        this.capaciteit = capaciteit;
    }

    // Getters en Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNaam() { return naam; }
    public void setNaam(String naam) { this.naam = naam; }

    public String getAdres() { return adres; }
    public void setAdres(String adres) { this.adres = adres; }

    public int getCapaciteit() { return capaciteit; }
    public void setCapaciteit(int capaciteit) { this.capaciteit = capaciteit; }
}
