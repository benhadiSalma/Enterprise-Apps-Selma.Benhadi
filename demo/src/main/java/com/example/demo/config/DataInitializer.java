package com.example.demo.config;

import com.example.demo.models.Event;
import com.example.demo.models.Location;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final LocationRepository locationRepository;
    private final EventRepository eventRepository;

    public DataInitializer(LocationRepository locationRepository,
                           EventRepository eventRepository) {
        this.locationRepository = locationRepository;
        this.eventRepository = eventRepository;
    }

    // Voegt voorbeeldgegevens toe wanneer de databank nog leeg is
    @Override
    public void run(String... args) {

        List<Location> locaties = new ArrayList<>();
        locationRepository.findAll().forEach(locaties::add);

        // Voegt locaties toe wanneer er nog geen locaties bestaan
        if (locaties.isEmpty()) {

            Location locatieEen = new Location(
                    "Gemeenschapscentrum De Rinck",
                    "Dapperheidsplein 7, 1070 Anderlecht",
                    150
            );

            Location locatieTwee = new Location(
                    "Sportzaal Veeweide",
                    "Veeweidestraat 80, 1070 Anderlecht",
                    300
            );

            locationRepository.save(locatieEen);
            locationRepository.save(locatieTwee);

            locaties.add(locatieEen);
            locaties.add(locatieTwee);
        }

        // Voegt voorbeeldevenementen toe wanneer er nog geen evenementen bestaan
        if (eventRepository.count() == 0) {

            Event evenementEen = new Event(
                    "Buurtfeest in het park",
                    "Een gezellige namiddag met muziek, kinderactiviteiten en hapjes voor bewoners uit de buurt.",
                    LocalDateTime.now().plusDays(5),
                    "NGO Anderlecht",
                    "info@ngo-anderlecht.be",
                    locaties.get(0)
            );

            Event evenementTwee = new Event(
                    "Inzameling van winterkleding",
                    "Breng propere winterjassen, sjaals en dekens binnen voor mensen die extra ondersteuning nodig hebben.",
                    LocalDateTime.now().plusDays(10),
                    "Solidariteit 1070",
                    "contact@solidariteit1070.be",
                    locaties.get(0)
            );

            Event evenementDrie = new Event(
                    "Sportnamiddag voor jongeren",
                    "Een gratis sportnamiddag met voetbal, basketbal en begeleide groepsactiviteiten.",
                    LocalDateTime.now().plusDays(14),
                    "Jeugdwerking Anderlecht",
                    "jongeren@anderlecht.be",
                    locaties.get(1)
            );

            eventRepository.save(evenementEen);
            eventRepository.save(evenementTwee);
            eventRepository.save(evenementDrie);
        }
    }
}
