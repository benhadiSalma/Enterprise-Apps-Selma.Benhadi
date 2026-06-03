package com.example.demo.config;

import com.example.demo.models.Event;
import com.example.demo.models.Location;
import com.example.demo.repositories.EventRepository;
import com.example.demo.repositories.LocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(LocationRepository locationRepo, EventRepository eventRepo) {
        return args -> {
            // We controleren of de database leeg is om dubbele data bij elke herstart te voorkomen
            if (eventRepo.count() == 0) {

                // 1. Locaties aanmaken
                Location kaai = new Location("Campus Kaai", "Nijverheidskaai 170, 1070 Anderlecht", 200);
                Location centrum = new Location("Buurtcentrum", "Kliniekstraat 15, 1070 Anderlecht", 50);
                locationRepo.save(kaai);
                locationRepo.save(centrum);

                // 2. Unieke evenementen aanmaken
                Event event1 = new Event(
                        "Programmeerworkshop voor kinderen",
                        "Een speelse kennismaking met coderen en robotica voor de jeugd uit de wijk.",
                        LocalDateTime.of(2026, 6, 15, 14, 0),
                        "Logiscool",
                        "contact@logiscool.be",
                        kaai
                );

                Event event2 = new Event(
                        "Solidaire buurtmaaltijd",
                        "Verdeling van warme maaltijden voor kansarmen, in samenwerking met lokale handelaars.",
                        LocalDateTime.of(2026, 6, 20, 18, 30),
                        "Belchicken Anderlecht",
                        "solidariteit@belchicken.be",
                        centrum
                );

                Event event3 = new Event(
                        "Taaluitwisselingsavond",
                        "Oefen Frans, Nederlands en Engels bij een kopje koffie.",
                        LocalDateTime.of(2026, 6, 25, 19, 0),
                        "Eigen beheer",
                        "info@ngo-anderlecht.be",
                        kaai
                );

                eventRepo.save(event1);
                eventRepo.save(event2);
                eventRepo.save(event3);
            }
        };
    }
}