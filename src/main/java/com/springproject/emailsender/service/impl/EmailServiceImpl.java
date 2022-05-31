package com.springproject.emailsender.service.impl;

import com.springproject.emailsender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService {


    JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) EmailConfig.getJavaMailSender();

    SimpleMailMessage preConfiguredMessage = EmailConfig.getMailMessage();

    @Override
    public void sendEmail(String destiny, String title, String content) {
        SimpleMailMessage message = new SimpleMailMessage(preConfiguredMessage);
        message.setTo(destiny);
        message.setSubject(title);
        message.setText(content);
        javaMailSender.send(message);
    }


}
