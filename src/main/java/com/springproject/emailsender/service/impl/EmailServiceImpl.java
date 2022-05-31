package com.springproject.emailsender.service.impl;

import com.springproject.emailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendSimpleEmail(String destiny, String title, String content) {

    }
}
