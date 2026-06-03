package com.example.demo.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class EventForm {

    @NotBlank(message = "Titel is verplicht")
    private String titel;

    @NotBlank(message = "Omschrijving is verplicht")
    private String omschrijving;

    @NotNull(message = "Tijdstip is verplicht")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime tijdstip;

    @NotBlank(message = "Organisatie is verplicht")
    private String organisatie;

    @NotBlank(message = "E-mailadres is verplicht")
    @Email(message = "Geen geldig e-mailadres")
    private String contactEmail;

    @NotNull(message = "Locatie is verplicht")
    private Long locatieId;

    public EventForm() {
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(LocalDateTime tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getOrganisatie() {
        return organisatie;
    }

    public void setOrganisatie(String organisatie) {
        this.organisatie = organisatie;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Long getLocatieId() {
        return locatieId;
    }

    public void setLocatieId(Long locatieId) {
        this.locatieId = locatieId;
    }
}

