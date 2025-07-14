package com.ae.tests.ui;

import com.ae.base.BaseUiTest;
import com.ae.config.Config;
import com.ae.pages.RegistrationPage;
import com.ae.testdata.UserData;
import com.ae.testdata.UserDataFactory;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("User Registration")
@Feature("UI Registration")
@Tag("smoke")
public class RegistrationTests extends BaseUiTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Successful user registration")
    @Description("Registers a new user via UI")
    public void testSuccessfulRegistration() {
        driver.get(Config.get("base.url"));

        UserData user = UserDataFactory.generateRandomUser();
        fillRegistrationForm(user);

        boolean isLoggedIn = driver.getPageSource().contains("Sign Out") ||
                driver.getPageSource().contains("My Account");

        assertTrue(isLoggedIn, "Registration failed — 'Sign Out' or 'My Account' not found.");
    }

    @Step("Fill registration with: {user.email}, {user.firstName} {user.lastName}, zip={user.zip}, birth={user.birthMonth} {user.birthDay}")
    private void fillRegistrationForm(UserData user) {
        new RegistrationPage(driver)
                .openRegistration()
                .enterEmail(user.email)
                .enterFirstName(user.firstName)
                .enterLastName(user.lastName)
                .enterPassword(user.password)
                .confirmPassword(user.password)
                .enterZipCode(user.zip)
                .selectBirthMonth(user.birthMonth)
                .selectBirthDay(user.birthDay)
                .acceptTerms()
                .submit();
    }
}
