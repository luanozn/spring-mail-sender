package com.springproject.emailsender.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
@PropertySource(value = "application.properties")
public class EmailConfig{

    private static final File FILE = new File("application.properties");
    private static final String ABSOLUTE_PATH = FILE.getAbsolutePath();
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
        System.out.println(ABSOLUTE_PATH);
        try(FileInputStream stream = new FileInputStream(ABSOLUTE_PATH.replace("application.properties", "/src/main/resources/application.properties"))){
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
