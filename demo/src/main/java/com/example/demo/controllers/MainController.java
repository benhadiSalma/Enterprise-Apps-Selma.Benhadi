package com.example.demo.controllers;

import com.example.demo.models.Event;
import com.example.demo.models.EventForm;
import com.example.demo.models.Location;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private final EventRepository eventRepository;
    private final LocationRepository locationRepository;

    public MainController(EventRepository eventRepository,
                          LocationRepository locationRepository) {
        this.eventRepository = eventRepository;
        this.locationRepository = locationRepository;
    }

    // Toont de tien meest recente evenementen op de startpagina
    @GetMapping("/")
    public String index(Model model) {

        List<Event> laatsteEvenementen =
                eventRepository.findTop10ByOrderByIdDesc();

        model.addAttribute("events", laatsteEvenementen);

        return "index";
    }

    // Toont het formulier om een nieuw evenement toe te voegen
    @GetMapping("/new")
    public String showNewEventForm(Model model) {

        model.addAttribute("eventForm", new EventForm());
        model.addAttribute("locations", locationRepository.findAll());

        return "new";
    }

    // Controleert de gegevens en slaat een nieuw evenement op
    @PostMapping("/new")
    public String saveNewEvent(
            @Valid @ModelAttribute("eventForm") EventForm eventForm,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("locations", locationRepository.findAll());

            return "new";
        }

        Location gekozenLocatie = locationRepository
                .findById(eventForm.getLocatieId())
                .orElse(null);

        if (gekozenLocatie == null) {

            bindingResult.rejectValue(
                    "locatieId",
                    "error.locatieId",
                    "Ongeldige locatie"
            );

            model.addAttribute("locations", locationRepository.findAll());

            return "new";
        }

        Event event = new Event(
                eventForm.getTitel(),
                eventForm.getOmschrijving(),
                eventForm.getTijdstip(),
                eventForm.getOrganisatie(),
                eventForm.getContactEmail(),
                gekozenLocatie
        );

        eventRepository.save(event);

        return "redirect:/";
    }

    // Toont de details van één evenement
    @GetMapping("/details/{id}")
    public String showEventDetails(@PathVariable Long id, Model model) {

        Event event = eventRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Evenement niet gevonden")
                );

        model.addAttribute("event", event);

        return "details";
    }

    // Toont de informatiepagina over de NGO
    @GetMapping("/about")
    public String showAboutPage() {

        return "about";
    }
}


