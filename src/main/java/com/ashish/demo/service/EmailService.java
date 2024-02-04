package com.ashish.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ashish.demo.util.EmailDetails;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("spring.mail.username")
    private String sender;

    public boolean SendEmail(EmailDetails details){
        SimpleMailMessage mailMessage=new SimpleMailMessage();

        mailMessage.setFrom(sender);
        mailMessage.setTo(details.getMail_to());
        mailMessage.setSubject(details.getMail_subject());
        mailMessage.setText(details.getMail_body());
        javaMailSender.send(mailMessage);
        return true;
    }
}
