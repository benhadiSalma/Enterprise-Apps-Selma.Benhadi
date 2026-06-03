package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Titel is verplicht")
    private String titel;

    @NotBlank(message = "Omschrijving is verplicht")
    @Column(length = 1000)
    private String omschrijving;

    @NotNull(message = "Tijdstip is verplicht")
    private LocalDateTime tijdstip;

    @NotBlank(message = "Organisatie is verplicht")
    private String organisatie; // "eigen beheer" of partnernaam

    @NotBlank(message = "E-mailadres is verplicht")
    @Email(message = "Geen geldig e-mailadres")
    private String contactEmail;


    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    @NotNull(message = "Locatie is verplicht")
    private Location locatie;

    // Constructors
    public Event() {}

    public Event(String titel, String omschrijving, LocalDateTime tijdstip, String organisatie, String contactEmail, Location locatie) {
        this.titel = titel;
        this.omschrijving = omschrijving;
        this.tijdstip = tijdstip;
        this.organisatie = organisatie;
        this.contactEmail = contactEmail;
        this.locatie = locatie;
    }

    // Getters en Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitel() { return titel; }
    public void setTitel(String titel) { this.titel = titel; }

    public String getOmschrijving() { return omschrijving; }
    public void setOmschrijving(String omschrijving) { this.omschrijving = omschrijving; }

    public LocalDateTime getTijdstip() { return tijdstip; }
    public void setTijdstip(LocalDateTime tijdstip) { this.tijdstip = tijdstip; }

    public String getOrganisatie() { return organisatie; }
    public void setOrganisatie(String organisatie) { this.organisatie = organisatie; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public Location getLocatie() { return locatie; }
    public void setLocatie(Location locatie) { this.locatie = locatie; }
}