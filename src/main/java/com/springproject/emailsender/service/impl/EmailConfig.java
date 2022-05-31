package com.springproject.emailsender.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailConfig{

    @Bean
    public static JavaMailSender getJavaMailSender(){
        Properties props = loadProperties();
        props.put("mail.smtp.starttls.enable", "true");
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(props);
        mailSender.setHost("smtp.gmail.com");

        return mailSender;
    }

    public static Properties loadProperties(){
        Properties props = new Properties();
        try(FileInputStream stream = new FileInputStream("E:\\Luan\\IdeaProjects\\spring-mail-sender\\src\\main\\resources\\application.properties")){
                props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public static SimpleMailMessage getMailMessage(){
        return new SimpleMailMessage();
    }
}
