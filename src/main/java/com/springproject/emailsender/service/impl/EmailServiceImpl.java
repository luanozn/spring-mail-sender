package com.springproject.emailsender.service.impl;

import com.springproject.emailsender.configs.EmailConfig;
import com.springproject.emailsender.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Objects;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    /*
    * Classe que cria uma mensagem personalizada com base no encoding UTF-8 e envia o email
    * de acordo com as necessidades do programado.
    * Pode ser utilizada onde houver a injeção de dependência por parte do Spring(@Autowired)
    * */

    JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) EmailConfig.getJavaMailSender();

    @Override
    public void sendEmail(String destiny, String title, String content) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        try {
            helper.setTo(destiny);
            helper.setFrom(Objects.requireNonNull(javaMailSender.getUsername()));
            helper.setSubject(title);
            helper.setText(content, true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        javaMailSender.send(mimeMessage);

    }


}
