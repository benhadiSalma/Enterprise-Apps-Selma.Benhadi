package com.example.demo.controllers;

import com.example.demo.models.ContactForm;
import jakarta.validation.Valid;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    private final JavaMailSender mailSender;

    public ContactController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    // Toont het contactformulier
    @GetMapping("/contact")
    public String showContactForm(Model model) {

        if (!model.containsAttribute("contactForm")) {
            model.addAttribute("contactForm", new ContactForm());
        }

        return "contact";
    }

    // Verstuurt het bericht naar de administrator
    @PostMapping("/contact")
    public String sendContactMessage(
            @Valid @ModelAttribute ContactForm contactForm,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "contact";
        }

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("noreply@ngo-anderlecht.be");
            message.setTo("admin@ngo-anderlecht.be");
            message.setReplyTo(contactForm.getEmail());
            message.setSubject("Contactformulier: " + contactForm.getOnderwerp());

            message.setText(
                    "Naam: " + contactForm.getNaam() + "\n" +
                            "E-mailadres: " + contactForm.getEmail() + "\n\n" +
                            "Bericht:\n" + contactForm.getBericht()
            );

            mailSender.send(message);

            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Je bericht is succesvol verzonden."
            );

            return "redirect:/contact";

        } catch (MailException exception) {


            model.addAttribute(
                    "sendError",
                    "Je bericht kon niet worden verzonden. Controleer de mailconfiguratie en probeer opnieuw."
            );

            return "contact";
        }
    }
}

