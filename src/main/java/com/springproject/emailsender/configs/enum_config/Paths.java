package com.springproject.emailsender.configs.enum_config;

import java.io.File;

/**
 * Enum that contains all PATHS used on application.
 */
public enum Paths {;
    private static final File[] MESSAGE_FILES = {new File("DeleteMessage"), new File("RegisterMessage"), new File("UpdateMessage")};

    private static final File PROPERTIES = new File("application.properties");
    public static final String DELETE_MESSAGE_PATH = MESSAGE_FILES[0].getAbsolutePath().replace("DeleteMessage", "src\\main\\resources\\messages\\DeleteMessage");
    public static final String REGISTER_MESSAGE_PATH = MESSAGE_FILES[1].getAbsolutePath().replace("RegisterMessage", "src\\main\\resources\\messages\\RegisterMessage");
    public static final String UPDATE_MESSAGE_PATH = MESSAGE_FILES[2].getAbsolutePath().replace("UpdateMessage", "src\\main\\resources\\messages\\UpdateMessage");

    public static final String PROPERTIES_PATH = PROPERTIES.getAbsolutePath().replace("application.properties", "/src/main/resources/application.properties");
}

