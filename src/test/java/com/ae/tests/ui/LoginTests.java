package com.ae.tests.ui;

import com.ae.base.BaseUiTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseUiTest {

    @Test
    void loginWithValidCredentials_ShouldSucceed() {
        driver.get("https://www.ae.com/us/en/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement signUpButton = driver.findElement(By.xpath("//*[@data-testid='icon-account']"));
        signUpButton.click();

        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-btn='signin']")));
        signInButton.click();

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-test='form-control-input' and @type='email']"))
        );
        emailInput.sendKeys("mail2906251739@mail.com");

        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-test-form-input='password']//input[@type='password']"))
        );
        passwordInput.sendKeys("7111482aA!");

        WebElement signInSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-test-btn='submit']"))
        );
        signInSubmitButton.click();

        WebElement signOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@data-test-btn='sign-out']"))
        );
        assertTrue(signOutButton.isDisplayed(), "Sign Out button is not visible — login may have failed");
    }
}
