package com.ae.config;

public class UiConfig {
    public static String getBaseUrl() {
        return System.getProperty("ui.baseUrl", "https://www.ae.com/us/en");
    }
}
