package com.springproject.emailsender.configs;

import com.springproject.emailsender.model.User;
import com.springproject.emailsender.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Configuration class created to read the isolated the HTML messages in respective files
 * from the main code.
 */

@Configuration
public class MessageConfig {

    private static final File[] files = {new File("DeleteMessage"), new File("RegisterMessage"), new File("UpdateMessage")};

    private static final String DELETE_MESSAGE = files[0].getAbsolutePath().replace("DeleteMessage", "src\\main\\resources\\messages\\DeleteMessage");
    private static final String REGISTER_MESSAGE = files[1].getAbsolutePath().replace("RegisterMessage", "src\\main\\resources\\messages\\RegisterMessage");
    private static final String UPDATE_MESSAGE = files[2].getAbsolutePath().replace("UpdateMessage", "src\\main\\resources\\messages\\UpdateMessage");


    public static String getDeleteMessage(User user){
        return String.format(loadMessage(DELETE_MESSAGE) ,user.getName());
    }

    public static String getUpdateMessage(String username, User user, List<String> information){

        return String.format(loadMessage(UPDATE_MESSAGE),
                user.getName(),
                information.get(0), information.get(1), information.get(2), information.get(3),
                user.getLogin(), user.getPassword(), user.getName(), user.getEmail()
        );
    }

    public static String getRegisterMessage(User user){
        return String.format(loadMessage(REGISTER_MESSAGE), user.getName());
    }

    public static String loadMessage(String filePath){
        StringBuilder builder = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line = reader.readLine();
            while(line != null){
                builder.append(line);
                line = reader.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return String.valueOf(builder);
    }

}
