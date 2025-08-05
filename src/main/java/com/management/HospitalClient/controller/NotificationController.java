package com.management.HospitalClient.controller;

import com.management.HospitalClient.service.EmailService;
import com.sendgrid.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/notify")
public class NotificationController {

    private final EmailService emailService;

    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email")
    public Response sendMail(@RequestParam String to) {

        return emailService.sendEmail(to, "Welcome to Hospital System", "Thanks for registering!");
    }
}
