package com.ae.utils;

import io.qameta.allure.Allure;

public class AllureUtils {
    public static void logCurlStep(String name, Object body, String token) {
        String curl = CurlUtils.toCurlRequest("https://www.ae.com/ugp-api/bag/v1/items", token, body);
        Allure.addAttachment(name + " - CURL", "text/plain", curl, ".sh");
        System.out.println("\n===== " + name + " =====\n" + curl);
    }

    public static void attachJson(String name, String json) {
        Allure.addAttachment(name, "application/json", json, ".json");
    }

    public static void attachText(String name, String content) {
        Allure.addAttachment(name, "text/plain", content);
    }

}
