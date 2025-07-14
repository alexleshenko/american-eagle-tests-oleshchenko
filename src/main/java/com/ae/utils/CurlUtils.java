package com.ae.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CurlUtils {
    public static String toCurlRequest(String url, String token, Object body) {
        try {
            String json = new ObjectMapper().writeValueAsString(body).replace("\"", "\\\"");
            return "curl --location '" + url + "' \\\n" +
                    "--header 'Content-Type: application/json' \\\n" +
                    "--header 'authorization: Bearer " + token + "' \\\n" +
                    "--header 'aesite: AEO_US' \\\n" +
                    "--header 'aelang: en_US' \\\n" +
                    "--header 'origin: https://www.ae.com' \\\n" +
                    "--data \"" + json + "\"";
        } catch (Exception e) {
            return "// Failed to generate curl: " + e.getMessage();
        }
    }
}
