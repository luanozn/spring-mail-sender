package com.springproject.emailsender.configs;

import com.springproject.emailsender.configs.enum_config.Paths;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailConfig {

    /**
     * Instantiates, configures and returns the JavaMailSender.
     *
     * @return JavaMailSender
     */
    @Bean
    public static JavaMailSender getJavaMailSender() { //
        Properties props = loadProperties();
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        props.put("mail.smtp.starttls.enable", true);
        mailSender.setJavaMailProperties(props);
        mailSender.setUsername(mailSender.getJavaMailProperties().getProperty("spring.mail.name"));
        mailSender.setPassword(mailSender.getJavaMailProperties().getProperty("spring.mail.password"));
        mailSender.setHost(mailSender.getJavaMailProperties().getProperty("spring.mail.host"));

        return mailSender;
    }

    /**
     * loads the properties located in the application.properties file
     *
     * @return Properties
     */
    public static Properties loadProperties() {
        Properties props = new Properties();
        try (FileInputStream stream = new FileInputStream(Paths.PROPERTIES_PATH)) {
            props.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

}
