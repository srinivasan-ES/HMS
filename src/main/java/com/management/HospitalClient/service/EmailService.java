package com.management.HospitalClient.service;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.management.HospitalClient.utility.MailSubjectAndContent.*;

@Service
public class EmailService {

    @Value("${sendgrid.api.key}")
    private String sendGridApiKey;

    public Response sendEmail(String toEmail, String subject, String content) {
        Email from = new Email(fromEmail);
        Email to = new Email(toEmail);
        Content emailContent = new Content(textPlan, content);
        Mail mail = new Mail(from, subject, to, emailContent);

        SendGrid sg = new SendGrid(sendGridApiKey);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint(sendMail);
            request.setBody(mail.build());
            return sg.api(request);
        } catch (IOException ex) {
        }
        return null;
    }
}
