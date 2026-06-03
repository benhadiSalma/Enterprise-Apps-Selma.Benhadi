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
            // Controleer of de database leeg is
            if (eventRepo.count() == 0) {

                // --- 1. ALLE LOCATIES TOEVOEGEN ---
                Location kaai = new Location("Campus Kaai", "Nijverheidskaai 170, 1070 Anderlecht", 200);
                Location centrum = new Location("Buurtcentrum", "Kliniekstraat 15, 1070 Anderlecht", 50);
                Location deRinck = new Location("Gemeenschapscentrum De Rinck", "Dapperheidsplein 7, 1070 Anderlecht", 150);
                Location veeweide = new Location("Sportzaal Veeweide", "Veeweidestraat 80, 1070 Anderlecht", 300);

                locationRepo.save(kaai);
                locationRepo.save(centrum);
                locationRepo.save(deRinck);
                locationRepo.save(veeweide);

                // --- 2. ALLE EVENEMENTEN TOEVOEGEN ---

                // Evenementen uit script 1
                Event event1 = new Event(
                        "Programmeerworkshop voor kinderen",
                        "Een speelse kennismaking met coderen en robotica voor de jeugd uit de wijk.",
                        LocalDateTime.now().plusDays(2),
                        "Logiscool",
                        "contact@logiscool.be",
                        kaai
                );

                Event event2 = new Event(
                        "Solidaire buurtmaaltijd",
                        "Verdeling van warme maaltijden voor kansarmen, in samenwerking met lokale handelaars.",
                        LocalDateTime.now().plusDays(4),
                        "Belchicken Anderlecht",
                        "solidariteit@belchicken.be",
                        centrum
                );

                Event event3 = new Event(
                        "Taaluitwisselingsavond",
                        "Oefen Frans, Nederlands en Engels bij een kopje koffie.",
                        LocalDateTime.now().plusDays(6),
                        "Eigen beheer",
                        "info@ngo-anderlecht.be",
                        kaai
                );

                // Evenementen uit script 2
                Event event4 = new Event(
                        "Buurtfeest in het park",
                        "Een gezellige namiddag met muziek, kinderactiviteiten en hapjes voor bewoners uit de buurt.",
                        LocalDateTime.now().plusDays(8),
                        "NGO Anderlecht",
                        "info@ngo-anderlecht.be",
                        deRinck
                );

                Event event5 = new Event(
                        "Inzameling van winterkleding",
                        "Breng propere winterjassen, sjaals en dekens binnen voor mensen die extra ondersteuning nodig hebben.",
                        LocalDateTime.now().plusDays(10),
                        "Solidariteit 1070",
                        "contact@solidariteit1070.be",
                        deRinck
                );

                Event event6 = new Event(
                        "Sportnamiddag voor jongeren",
                        "Een gratis sportnamiddag met voetbal, basketbal en begeleide groepsactiviteiten.",
                        LocalDateTime.now().plusDays(14),
                        "Jeugdwerking Anderlecht",
                        "jongeren@anderlecht.be",
                        veeweide
                );

                eventRepo.save(event1);
                eventRepo.save(event2);
                eventRepo.save(event3);
                eventRepo.save(event4);
                eventRepo.save(event5);
                eventRepo.save(event6);
            }
        };
    }
}