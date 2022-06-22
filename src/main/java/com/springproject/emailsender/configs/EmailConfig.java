package com.springproject.emailsender.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailConfig{
    

    private static final File FILE = new File("application.properties");
    private static final String ABSOLUTE_PATH = FILE.getAbsolutePath();

    @Bean
    public static JavaMailSender getJavaMailSender(){ // Instancia, configura e retorna o JavaMailSender (O que enviará os emails)
        Properties props = loadProperties();
        props.put("mail.smtp.starttls.enable", "true");
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setJavaMailProperties(props);
        mailSender.setUsername(mailSender.getJavaMailProperties().getProperty("spring.mail.name"));
        mailSender.setPassword(mailSender.getJavaMailProperties().getProperty("spring.mail.password"));
        mailSender.setHost(mailSender.getJavaMailProperties().getProperty("spring.mail.host"));

        return mailSender;
    }

    public static Properties loadProperties(){  // Carrega as propriedades contidas no arquivo application.properties
        Properties props = new Properties();
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
