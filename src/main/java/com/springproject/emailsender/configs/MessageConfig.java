package com.springproject.emailsender.configs;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class MessageConfig {

    /*
        Classe de configuraçao criada para isolar o uso das mensagens HTML
        contidas nos emails do codigo principal
    */

    @Autowired
    static UserServiceImpl userService;


    public static String getRegisterMessage(User user){
        return String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<!-- HTML Codes by Quackit.com -->\n" +
                "<title>\n" +
                "</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<style>\n" +
                "body {background-repeat:no-repeat;background-position:center center;background-attachment:fixed;}\n" +
                "h2{font-family:Impact, sans-serif;font-variant:small-caps;color:#58181f;padding-bottom:20px}\n" +
                "p {text-align:center;font-family:Arial, sans-serif;font-size:15px;font-style:italic;font-weight:bold;color:#000000}" +
                "att {padding-top:20px}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Cadastro realizado com sucesso!</h2>\n" +
                "<p>Parabéns %s, seu usuário foi cadastrado com sucesso.</p>\n" +
                "<p>/*------------------------------------------*/</p>" +
                "<p id='att'>Atenciosamente</p>\n" +
                "<p>Projeto Mail Sender</p>\n" +
                "</body>\n" +
                "</html>\n", user.getName());
    }

    public static String getUpdateMessage(String username, User user, List<String> information){
        return String.format("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<!-- HTML Codes by Quackit.com -->\n" +
                        "<title>\n" +
                        "</title>\n" +
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "<style>\n" +
                        "body {background-repeat:no-repeat;background-position:center center;background-attachment:fixed;}\n" +
                        "h2{font-family:Impact, sans-serif;font-variant:small-caps;color:#58181f;padding-bottom:20px}\n" +
                        "p {text-align:center;font-family:Arial, sans-serif;font-size:15px;font-style:italic;font-weight:bold;color:#000000}" +
                        "att {padding-top:20px}\n" +
                        "</style>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h2>Atualização de dados cadastrais</h2>\n" +
                        "<p>%s, as seguintes alterações foram realizadas em seu cadatro:</p>\n" +
                        "<p>/*------------------------------------------*/</p>" +
                        "<p>Antigo: </p>" +
                        "<p>Usuário: %s </p>" +
                        "<p>Senha: %s </p>" +
                        "<p>Nome: %s </p>" +
                        "<p>Email: %s </p>" +
                        "<p>/*------------------------------------------*/</p>" +
                        "<p>Novo: </p>" +
                        "<p>Usuário: %s </p>" +
                        "<p>Senha: %s </p>" +
                        "<p>Nome: %s </p>" +
                        "<p>Email: %s </p>" +
                        "<p>/*------------------------------------------*/</p>" +
                        "<p id='att'>Atenciosamente</p>\n" +
                        "<p>Projeto Mail Sender</p>\n" +
                        "</body>\n" +
                        "</html>\n",
                user.getName(),
                information.get(0), information.get(1), information.get(2), information.get(3),
                user.getLogin(), user.getPassword(), user.getName(), user.getEmail()
        );
    }

    public static String getDeleteMessage(User user){
        return String.format("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<!-- HTML Codes by Quackit.com -->\n" +
                "<title>\n" +
                "</title>\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<style>\n" +
                "body {background-repeat:no-repeat;background-position:center center;background-attachment:fixed;}\n" +
                "h2{font-family:Impact, sans-serif;font-variant:small-caps;color:#58181f;padding-bottom:20px}\n" +
                "p {text-align:center;font-family:Arial, sans-serif;font-size:15px;font-style:italic;font-weight:bold;color:#000000}" +
                "att {padding-top:20px}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Deleção de cadastro realizada com sucesso</h2>\n" +
                "<p>%s, seu cadastro foi removido com sucesso.</p>\n" +
                "<p>/*------------------------------------------*/</p>" +
                "<p id='att'>Atenciosamente</p>\n" +
                "<p>Projeto Mail Sender</p>\n" +
                "</body>\n" +
                "</html>\n", user.getName());
    }
}
