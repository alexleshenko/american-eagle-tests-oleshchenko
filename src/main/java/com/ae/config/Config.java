package com.ae.config;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Can't read config", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
