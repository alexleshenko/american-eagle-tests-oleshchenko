package com.ae.tests.ui;

import com.ae.base.BaseUiTest;
import com.ae.config.Config;
import com.ae.pages.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseUiTest {

    @Test
    @DisplayName("Login with valid credentials")
    public void loginWithValidCredentials() {
        String baseUrl = Config.get("base.url");
        String email = Config.get("login.email");
        String password = Config.get("login.password");

        driver.get(baseUrl);

        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .openLoginForm()
                .enterEmail(email)
                .enterPassword(password)
                .submitLogin();

        assertTrue(loginPage.isSignOutVisible(), "'Sign Out' not visible — login failed");
    }

}
