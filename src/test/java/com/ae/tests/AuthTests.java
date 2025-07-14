package com.ae.tests;

import com.ae.api.AuthApi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthTests {

    @Test
    @DisplayName("Should fetch access token successfully")
    void getAccessTokenTest() {
        String token = AuthApi.getAccessToken();
        assertNotNull(token, "Access token should not be null");
        assertFalse(token.isEmpty(), "Access token should not be empty");

        System.out.println("Access token: " + token);
    }
}
