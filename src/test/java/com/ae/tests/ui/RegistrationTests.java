package com.ae.tests.ui;

import com.ae.base.BaseUiTest;
import com.ae.config.UiConfig;
import com.ae.pages.RegistrationPage;
import com.ae.testdata.UserData;
import com.ae.testdata.UserDataFactory;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("User Registration")
@Feature("UI Registration")
@Tag("smoke")
public class RegistrationTests extends BaseUiTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Successful user registration")
    @Description("Test registers a new user via the UI and verifies successful login by checking for 'Sign Out'")
    public void testSuccessfulRegistration() {
        step("Open website: " + UiConfig.getBaseUrl(), () -> driver.get(UiConfig.getBaseUrl()));

        UserData user = UserDataFactory.generateRandomUser();

        step("Fill registration form with user data", () -> fillRegistrationForm(user));

        step("Verify user is logged in", () -> {
            boolean isLoggedIn = driver.getPageSource().contains("Sign Out") ||
                    driver.getPageSource().contains("My Account");
            assertTrue(isLoggedIn, "Registration failed  'Sign Out' not found.");
        });
    }

    @Step("Fill registration form with: email={user.email}, name={user.firstName} {user.lastName}, zip={user.zip}, birth: {user.birthMonth} {user.birthDay}")
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
