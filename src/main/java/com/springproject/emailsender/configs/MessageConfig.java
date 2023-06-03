package com.springproject.emailsender.configs;

import com.springproject.emailsender.configs.enum_config.Paths;
import com.springproject.emailsender.model.User;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Configuration class created to read the isolated the HTML messages in respective files
 * from the main code.
 */

@Configuration
public class MessageConfig {

    /**
     * Method that gets the message of account deletion contained at the DeletionMessage.txt file
     * and formats it with user data
     *
     * @param   user Used to format the respective message
     * @return  string containing the message of account deletion
     */
    public static String getDeleteMessage(String user) {
        return String.format(loadMessage(Paths.DELETE_MESSAGE_PATH), user);
    }

    /**
     * Method that gets the message of account data update contained in UpdateMessage.txt file
     * and formats it with user data
     *
     * @param   user Used to format the respective message with user's information
     * @param   information Used to get user's information before the update, like name, login, password, email.
     * @return  string containing the message of account data update
     */
    public static String getUpdateMessage(User user, List<String> information) {

        return String.format(loadMessage(Paths.UPDATE_MESSAGE_PATH),
                user.getName(),
                information.get(0), information.get(1), information.get(2), information.get(3),
                user.getLogin(), user.getPassword(), user.getName(), user.getEmail()
        );
    }

    /**
     * Method that gets the message of account creation contained at the DeletionMessage.txt file
     * and formats it with user data
     *
     * @param   user Used to format the respective message with user data
     * @return  string containing the message of account creation
     */

    public static String getRegisterMessage(User user) {
        return String.format(loadMessage(Paths.REGISTER_MESSAGE_PATH), user.getName());
    }

    /**
     * Loads the respective message from a file, be it Register, Update or Delete
     *
     * @param   filePath refers to the path of the file that contains the message.
     * @return  the unformatted String
     */
    public static String loadMessage(String filePath) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(builder);
    }

}
