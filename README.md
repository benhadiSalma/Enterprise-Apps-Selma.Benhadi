# Enterprise Apps Salma.Benhadi

Prototype van een webapplicatie voor een Anderlechtse NGO (1070), ontwikkeld in Java met Spring Boot volgens de MVC-architectuur.

## Over het project
Dit project is een web-gebaseerd prototype voor een NGO in Anderlecht. Het stelt de organisatie in staat om evenementen te beheren, locaties bij te houden en in contact te blijven met de buurt via een dynamische interface.

## Externe Libraries en Frameworks
* **Spring Boot Web / Thymeleaf / Validation / Data JPA** (Backend & Templating)
* **H2 Database** (In-memory database voor het prototype)
* **Tailwind CSS** (via CDN geïntegreerd voor een lokaal, neo-brutalistisch design)
* **Mailtrap** (voor het testen van de mailfunctionaliteit op de contactpagina)

## AI Chatlog Samenvatting
Tijdens de ontwikkeling van dit project werd Google Gemini (AI) ingezet als collaboratieve assistent:

* **Fase 1: Architectuur & Model Setup**
    * Bespreking van de MVC-architectuur en configuratie van JPA-entiteiten (`Event` en `Location`).
    * Implementatie van de `@ManyToOne` relatie en `LocalDateTime` voor tijdsregistratie.
* **Fase 2: Backend Logica & Validatie**
    * Opzetten van de `MainController` en `EventForm` (DTO).
    * Implementatie van `Jakarta Validation` (`@Valid`, `@Email`, `@NotBlank`) om datakwaliteit te garanderen.
* **Fase 3: Design & UI/UX (Tailwind)**
    * Iteratie op het visuele design om een professionele "1070/Brusselse" esthetiek te bekomen.
    * Integratie van een "brutalistisch" thema met `Archivo Black` en `Space Mono` fonts en `city-grid` styling.
* **Fase 4: Database & Configuratie**
    * Foutopsporing en centralisatie van de database-seeding (`DataSeeder`) voor een stabiele dataset bij opstart.

## Handleiding om het project uit te voeren
1. Clone deze repository naar je lokale machine.
2. Open het project in IntelliJ IDEA.
3. Zorg ervoor dat Java 17 (of recenter) is geïnstalleerd.
4. Ga naar `src/main/resources/application.properties` en verifieer de Mailtrap credentials indien je de mailfunctionaliteit wilt testen.
5. Voer de klasse `DemoApplication.java` uit.
6. De applicatie is lokaal beschikbaar op: `http://localhost:8080/`

## Gebruikte tutorials en bronnen
* Officiële Spring Boot & Thymeleaf Documentatie
* Tailwind CSS Documentation (UI components)
* Mailtrap.io integratie handleiding

---
*Project ingediend door Salma Benhadi - Graduaat Programmeren EHB.*
