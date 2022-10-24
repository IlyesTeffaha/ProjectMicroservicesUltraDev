package com.esprit.microservice.Service;

import com.esprit.microservice.Entity.EmailDetails;

public interface IEmailService {



    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
